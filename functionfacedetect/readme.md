人脸检测、人脸追踪、人脸识别、年龄识别、性别识别
Android集成虹软人脸、人证对比，活体检测:https://www.jianshu.com/p/8dee89ec4a24
1 录制视频Camera
Android Camera详解:https://www.cnblogs.com/dongweiq/p/6346857.html
自定义Camera系列之：SurfaceView + Camera:https://blog.csdn.net/afei__/article/details/85255809
Android 纯原生视频录制 MediaRecorder+SurfaceView 采坑记录：https://blog.csdn.net/qq_39731011/article/details/89916909?utm_medium=distribute.pc_relevant.none-task-blog-baidujs-6
(1) 功能点
ui
录制功能，开始、结束，视频压缩上传到服务器，时间限制，前置摄像头，
js-api方式提供
(2) 原理
现在安卓手机实现录像的功能无非就两种方式，第一是实用系统自带的照相机/摄像机进行录制，
然后通过回调的方式将源返回。
这种方式是直接调用手机的摄像功能，所以就和你打开相机摄像是一模一样的，但是这样就产生问题了，
现在的手机摄像头像素越来越高，拍摄效果越来越清晰，很多都达到了720p甚至是1080p，这样短暂的10s
时长内存占用就达到了20M，显然这样是不可能的，并且intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
这行代码，在设置EXTRA_VIDEO_QUALITY为1的情况下，视频格式保存为mp4，然而无论怎么修改EXTRA_VIDEO_QUALITY为
0.几的时候，视频保存格式为3gp，并且视频录像效果很差。
第二种方法就是利用安卓自带的MediaRecorder来录制视频，并制定视频保存路径，并且可以通过Camera来播放录制的视频。


2 人脸检测
Android SDK
Face Detector
https://www.cnblogs.com/mainroadlee/p/android_sdk_face_detection.html
第三方sdk
Face++，百度，阿里这些需要用HTTP进行网络请求返回结果，OpenCV、虹软可以本地检测
旷视；讯飞；OpenCV；nncn;Face++；百度；阿里；虹软；
虹软：
官网：http://www.arcsoft.com.cn/ai/arcface.html
https://www.jianshu.com/p/75733cff88a3
百度：
Android打造圆形相机并实现人脸识别（三）：https://blog.csdn.net/CarsonWoo/article/details/105393590?utm_medium=distribute.pc_relevant.none-task-blog-baidujs-9

功能实现点
(1) 录屏自定义圆形框
绘制圆形surfaceview，解决预览框的畸变问题：
https://blog.csdn.net/qunqunstyle99/article/details/80864214?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-8.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-8.nonecase
Android多种方式实现相机圆形预览的示例代码:https://www.jb51.net/article/167750.htm
android 圆形人脸识别框:https://blog.csdn.net/baidu_35824246/article/details/83420579
(2) 判断人脸是否在圆形录屏框内，不在圆形框内则提醒用户
(3) 判断是否是真人/活体检测
Android人脸识别活体检测开发入门--基于虹软免费SDK实现:https://www.jianshu.com/p/2477790c9d3a
Android集成虹软人脸、人证对比，活体检测:https://www.jianshu.com/p/8dee89ec4a24

3 人脸识别
活体动态人脸识别Demo:https://pan.baidu.com/s/1i5oXoJ7?errno=0&errmsg=Auth%20Login%20Sucess&&bduss=&ssnerror=0&traceid=#list/path=%2F&parentPath=%2Fsharelink2684872685-1049510151020102

4 openvc
opencvandroid配置:https://www.csdn.net/gather_27/MtjaAgzsMTgzMC1ibG9n.html

5 一个Activity覆盖另一个Activity的一部分
 透明来设置

6 绘制圆环

7 上下扫描动画
方案一：自定义View
Android使用动画实现微信扫描线效果:https://blog.csdn.net/mp624183768/article/details/79223690?utm_medium=distribute.pc_relevant.none-task-blog-baidujs-2
Android自定义View（五）——带扫描线的View：https://blog.csdn.net/yankebin/article/details/49801797?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase
精通Android自定义View(二十)自定义仿微信扫一扫效果：https://blog.csdn.net/zl18603543572/article/details/90579106?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-15.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-15.nonecase
扫脸动画：https://blog.csdn.net/xueshanhaizi/article/details/78281695
方案二：使用背景图
Android 实现人脸识别检测时的扫描动画效果（二维码扫描动画效果同理）:https://blog.csdn.net/u010231454/article/details/84986161?utm_medium=distribute.pc_relevant.none-task-blog-baidujs-1

8 后台录制视频
android 后台service 实现无预览页面录像功能：https://blog.csdn.net/fengchen118/article/details/52232499?utm_source=blogxgwz3
9 上传视频

10 h5调用原生进行人脸检测

11 毛玻璃效果
方案一：
叠加毛玻璃背景图片
方案二：
自定义View
方案三：
ImageView设置模糊值