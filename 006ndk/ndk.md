相关概念
(1)所有c/c++代码都会自动被编译成为so库文件才能发布
(2).h文件和.c文件
.h文件为Ｃ语言的头文件，
.c则为Ｃ语言的源文件，
头文件可以包含进入源文件，这样就可以在源文件中调用头文件里面所定义的函数和变量了，可将源文件制作成头文件，方法就是将扩展名改成.h就可以了．

1 NDK demo
Android NDK开发之从环境搭建到Demo级十步流:https://www.cnblogs.com/guanmanman/p/6769240.html
Android NDK开发-环境搭建（一）:https://blog.csdn.net/lynnlee_36/article/details/81254708
Android NDK开发-简单Demo（二）:https://blog.csdn.net/lynnlee_36/article/dmetails/81433103

2 ndk编译方式
(1)ndkCompile 即useDeprecatedNdk。已废弃
(2)ndk-build+Android.mk
(3)CMakeList

3 老项目配置ndk环境
基于已有项目的NDK环境配置：https://www.jianshu.com/p/2ff3f94328f6

4 NDK开发
Android Studio NDK开发——三步实现HelloWorld一篇就够了：
https://blog.csdn.net/w690333243/article/details/78184056
Android Studio 3.0 Jni 开发环境配置 ndk cmake编译 多个C/C++文件添加配置:
https://blog.csdn.net/m0_37677536/article/details/78557573

5 cmake
Android Studio build.gradle 中配置 cmake，及各 arguments 详解:
https://blog.csdn.net/afei__/article/details/81271594

6 JNI接口
Jni接口-深入研究参数的传递（一）：https://www.cnblogs.com/lsnproj/archive/2012/01/09/2317519.html
Jni中图片传递的3种方式（转）：https://www.cnblogs.com/zl1991/p/7778394.html

7 生成so库供使用
android cmakelist链接自定义动态库 studio：https://www.csdn.net/gather_21/MtTakg4sNTk1NC1ibG9n.html
Android 中对so库简单的调用封装流程：https://www.jianshu.com/p/ac2a32c64231
方法1：
生成so库：Build——>Make Project
将生成好的so文件copy到我们的jniLibs文件夹中即可
方法2：
生成.h头文件
E:\lexin\LxGitCode\fenqile\fenqile_app\fenqile_app_git\app\src\main\java>javah -jni com.fenqile.jni.JNIUtils
生成so库
E:\lexin\LxGitCode\fenqile\fenqile_app\fenqile_app_git\app\src\main\java>ndk-build

8 cmake编译方式
Android Studio 2.2 NDK cMake 方式:https://www.jianshu.com/p/e03028f826d7