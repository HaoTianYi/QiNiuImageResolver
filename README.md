### 使用MD编辑器

推荐Typora（win感觉是最好的）

而且这里解析的是绝对路径

形如：`![snipaste_20170712_074225](C:\Users\天\Desktop\snipaste_20170712_074225.png)`

在Typora中直接拖拽就形成这样的地址

### 前提

使用七牛的图床服务，你要先完成注册

工程项目：idea2017+win10

### 使用图床JAR

在更改打包好你的JAR,使用：

![201707120910](http://oaxelf1sk.bkt.clouddn.com/201707120910.gif)

十分的简单



改造属于你自己的JAR，注意这里使用的是七牛的云服务，你要先完成注册并且创建空间等

在项目中找到LocalProperty文件然后找到getLocalPropertyByConsole()设置四个属性：

```
String accessKey = "xxxxxxxxxxxx";//就是ak
String secretKey = "xxxxxxxxxx";//就是sk
String bucketName = "xxxxxxxx";//存储空间的名称
String domainName = "xxxxxxxxx";//存储域名
```

现在就可以在idea中运行了，你也可以像笔者一样打包好JAR来使用