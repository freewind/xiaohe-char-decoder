package github.freewind.xiaohe.chardecoder

fun main(args: Array<String>) {
    val chars = XiaoHeCharDecoder.charsAll.filter {
        it.codes.map { it.first() }.distinct().size > 1
    }
    chars.forEach { println(it.char)}
    println(chars.size)
}