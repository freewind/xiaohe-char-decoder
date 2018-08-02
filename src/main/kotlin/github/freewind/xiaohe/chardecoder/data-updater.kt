package github.freewind.xiaohe.chardecoder

import com.beust.klaxon.Klaxon
import github.freewind.xiaohe.xhub.XHubFetcher

fun main(args: Array<String>) {
    val chars = XiaoHeCharDecoder.charsLevel3.map { it.char }
    for (chunk in chars.chunked(100)) {
        XHubFetcher.fetch(chunk.toList()).forEach {
            val json = Klaxon().toJsonString(it)
            println(json)
        }
        Thread.sleep(5000)
    }
}