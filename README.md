小鹤音形码反查
=======

给定一个符合《通用规范汉字表》国发〔2013〕23号文规定的汉字，查出它对应的音形码。

```
import github.freewind.xiaohe.chardecoder.XiaoHeCharDecoder

XiaoHeCharDecoder.findCode('黡')
```

输出：

```
CharCodeInfo(char=黡, codes=[yjih], parts=[Part(name=厂, code=i), Part(name=犬, code=null), Part(name=黑, code=h)])
```

如果字没有找到，则返回`null`

依赖
---

```
repositories {
    maven { url 'https://dl.bintray.com/freewind/maven/' }
}

dependencies {
    compile 'github.freewind:xiaohe-char-decoder:0.4.0'
}
```

注意
---

由于在网上无法找到文字版的《通用规范汉字表》，所以本库存在以下问题：

- 汉字数量不够，《规范》中为8105，本库只有7886个汉字
- 本库对文字分级为Level1, Level2, Level3，跟规范中并不一致，这里的Level1与Level2对应的时gb2312中的标准，Level3为gb2312以外的字

如果你有完整的文本版《通用规范汉字表》，欢迎在Issue中告知，我来更新。