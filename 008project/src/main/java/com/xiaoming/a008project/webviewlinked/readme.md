1 webview与外层Scrollview滑动冲突
Android webview scrollview 冲突解决记录:  https://blog.csdn.net/yuyuanhuang/article/details/111208225
ScrollView嵌套WebView与原生控件组合的一些问题:https://blog.csdn.net/ysy950803/article/details/86657790

Android中ScrollView嵌套WebView:   https://blog.csdn.net/pangzaifei/article/details/33729817?utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control
Android中scrollview嵌套webview的实现:  https://blog.csdn.net/jakezhang1990/article/details/77746378
android---webview和scrollview（等滑动冲突）:  https://blog.csdn.net/li15225271052/article/details/71105250
Android中ScrollView嵌套WebView: https://blog.csdn.net/pangzaifei/article/details/33729817
我们知道由于WebView本身是可滑动的，ScrollView也可滑动，自然就有了滑动冲突。 其实你不处理滑动冲突大部分情况下也没问题，WebView会一次性全部加载并填充高度，然后滑动事件只在ScrollView上，WebView接收不到任何触摸事件（被父布局ScrollView拦截），表面上手感和视觉效果差异不大，下面组合的原生控件也能正常展示。 但这仅仅是对于静态HTML页面，你换作加载动态页面，问题就来了，比如一些网页图片都是懒加载的，必须依赖向下滚动才会继续加载，这时候你就会发现上面的做法加载不出来图片，因为WebView没吃到滑动事件。


2 WebView与外层RecyclerView滑动冲突
RecyclerView里面套用webview 显示不全: https://blog.csdn.net/u013200864/article/details/51766931
RecyclerView 顶部嵌套WebView 导致显示不完全: https://www.jianshu.com/p/4cb72e854cb2


3 ScrollView vs RecyclerView
(1) 什么时候使用ScrollView
ANDROID-什么时候用SCROLLVIEW: https://www.cnblogs.com/android-deli/p/10095876.html
摆放无顺序，无规律，并会超出屏幕的高度，就可以用ScrollView
(2) RecyclerView
其官方定义是：A flexible view for providing a limited window into a large data set
能够灵活的实现大数据集的展示，视图的复用管理比ListView更好，能够显示列表，网格，瀑布流等形式，且不同的ViewHolder能够实现item多元化的功能

4 自定义WebView
weex解决scrollView嵌套webview高度问题，安卓自定义weex组件webview: https://blog.csdn.net/m0_38058826/article/details/95211513 