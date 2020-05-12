1 录制视频
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


2 人脸识别
Android SDK
Face Detector
https://www.cnblogs.com/mainroadlee/p/android_sdk_face_detection.html
第三方sdk
旷视；讯飞；OpenCV；nncn;Face++；百度；阿里；
虹软
官网：http://www.arcsoft.com.cn/ai/arcface.html
https://www.jianshu.com/p/75733cff88a3

功能实现点
(1) 人脸识别自定义框
(2) 判断人脸是否在录像框内？
(3) 判断是否是真人/活体检测