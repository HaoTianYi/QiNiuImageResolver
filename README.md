## 使用MD编辑器

推荐Typora（win感觉是最好的）

## 使用图床JAR

在更改打包好你的JAR,使用：

![201707120910](http://oaxelf1sk.bkt.clouddn.com/201707120910.gif)

十分的简单



改造属于你自己的JAR:

找到LocalProperty文件然后找到getLocalPropertyByConsole()设置四个属性：

```
String accessKey = "xxxxxxxxxxxx";//就是ak
String secretKey = "xxxxxxxxxx";//就是sk
String bucketName = "xxxxxxxx";//存储空间的名称
String domainName = "xxxxxxxxx";//存储域名
```
