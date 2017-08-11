# 1.PPSDK介绍
阿里应用分发应用商店SDK（PPSDK），将PP和豌豆荚的应用分发能力和应用运营能力通过SDK形式提供给合作方。合作方可以通过集成SDK获得原生体验的应用商店使自己的APP获得应用分发能力，并且可以通过下载广告包CPS分成的方式进行结算分成。

# 2.集成指南
## 文件放置
- ppsdk_vx.x.x.jar放到libs文件夹下
- png文件放到`res/drawable-hdpi/`文件夹下，请注意**不能修改文件名**
- xml文件放到`res/values/`文件夹下，请注意**不能修改文件名**

## 混淆说明
```
-keep class com.pp.sdk.** { *; }

# SDK使用了layoutlib.jar中的类，用做监听app的安装事件
-dontwarn android.content.pm.IPackageStatsObserver
```
# 3.API
PPSDK的入口类是com.pp.sdk.AppStoreManager，
