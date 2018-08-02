package github.freewind.xiaohe.chardecoder

import java.nio.charset.Charset

private val classLoader = CharCode::class.java.classLoader

fun readCharCodesFromClasspathFiles(path: String, level: CharLevel): List<CharCode> {
    val lines = classLoader.getResourceAsStream(path).reader(Charset.forName("UTF-8")).readLines().filterNot { it.isEmpty() }
    return lines.map { line -> parse(line, level) }
}

private fun parse(line: String, level: CharLevel): CharCode {
    val char = line.substringBefore(":").trim().single()
    val code = line.substringAfter(":").trim()
    return CharCode(char, code, level)
}

enum class CharLevel {
    Level1, Level2, Level3
}

data class CharCode(val char: Char, val code: String, val level: CharLevel) {
    val pinyinCode = code.take(2).also {
        if (it.length != 2) throw Exception("音码长度必须为2: ${it.length}")
    }
}

object XiaoHeCharDecoder {

    val charsLevel1 = readCharCodesFromClasspathFiles("gb2312单字音形码表-level1.txt", CharLevel.Level1)

    val charsLevel2 = readCharCodesFromClasspathFiles("gb2312单字音形码表-level2.txt", CharLevel.Level2)

    val charsLevel3 = readCharCodesFromClasspathFiles("新标准补充单字音形码表.txt", CharLevel.Level3)

    val charsAll = charsLevel1 + charsLevel2 + charsLevel3

    fun findCode(char: Char): CharCode? {
        return charsAll.find { it.char == char }
    }

}

fun main(args: Array<String>) {

}
