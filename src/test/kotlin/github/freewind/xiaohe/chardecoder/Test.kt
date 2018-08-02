package github.freewind.xiaohe.chardecoder

import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.Test

class Test {

    @Test
    fun `get code of a char`() {
        assertThat(XiaoHeCharDecoder.findCode('鹤')).isEqualTo(CharCode(char = '鹤', code = "hedn", level = CharLevel.Level1))
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