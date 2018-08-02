package github.freewind.xiaohe.chardecoder

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import github.freewind.xiaohe.chardecoder.XiaoHeCharDecoder.charsAll
import github.freewind.xiaohe.xhub.CharCodeInfo
import github.freewind.xiaohe.xhub.Part
import java.nio.charset.Charset

private val classLoader = XiaoHeCharDecoder::class.java.classLoader

fun readCharCodesFromClasspathFiles(path: String): List<CharCodeInfo> {
    val lines = classLoader.getResourceAsStream(path).reader(Charset.forName("UTF-8")).readLines().filterNot { it.isEmpty() }
    return lines.map { line -> charCodeInfo(line) }
}

private fun charCodeInfo(line: String): CharCodeInfo {
    val json = Klaxon().parseJsonObject(line.reader())
    return CharCodeInfo(
            char = json.string("char")!!.single(),
            codes = json.array<String>("codes")!!.toList(),
            parts = json.array<JsonObject>("parts")!!.map { obj ->
                Part(
                        name = obj.string("name")!!,
                        code = obj.string("code")?.single()
                )
            }
    )
}

object XiaoHeCharDecoder {

    val charsLevel1 = readCharCodesFromClasspathFiles("level1.txt")

    val charsLevel2 = readCharCodesFromClasspathFiles("level2.txt")

    val charsLevel3 = readCharCodesFromClasspathFiles("level3.txt")

    val charsAll = charsLevel1 + charsLevel2 + charsLevel3

    fun findCode(char: Char): CharCodeInfo? {
        return charsAll.find { it.char == char }
    }

}

fun main(args: Array<String>) {
    charsAll.forEach { println(it) }
}
