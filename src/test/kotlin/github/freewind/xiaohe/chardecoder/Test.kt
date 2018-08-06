package github.freewind.xiaohe.chardecoder

import github.freewind.xiaohe.xhub.CharCodeInfo
import github.freewind.xiaohe.xhub.Part
import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.Test

class Test {

    @Test
    fun `get code of a char`() {
        assertThat(XiaoHeCharDecoder.findCode('鹤')).isEqualTo(
                CharCodeInfo(char = '鹤', codes = listOf("hedn"), parts = listOf(Part(name = "丶", code = 'd'), Part(name = "フ"), Part(name = "ノ"), Part(name = "丨"), Part(name = "亠"), Part(name = "\uE82B"), Part(name = "鸟", code = 'n')))
        )
    }

    @Test
    fun `get code for a char which is not in the spec`() {
        assertThat(XiaoHeCharDecoder.findCode('頿')).isNull()
    }

    @Test()
    @Ignore
    fun `check the total count of chars`() {
        assertThat(XiaoHeCharDecoder.charsAll).hasSize(8105)
    }

}