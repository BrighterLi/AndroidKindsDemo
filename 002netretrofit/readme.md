getRetrofit是一个Http请求库，和其它Http库最大区别在于通过大范围使用注解简化Http请求。目前Retrofit 2.0底层是依赖OkHttp实现的，
也就是说Retrofit本质上就是对OkHttp的更进一步封装。

请求步骤：

1，定义接口（封装URL地址和数据请求）
2，实例化Retrofit
3，通过Retrofit实例创建接口服务对象
4，接口服务对象调用接口中的方法，获取Call对象
5，Call对象执行请求（异步、同步请求）

Get
Post
文件上传
文件下载
开启日志拦截
与RxJava结合使用
https://blog.csdn.net/qq_38998213/article/details/82352104

baseUrl添加的是地址的主域名,@GET 包含的是请求地址，是主域名之后的地址。举个例子，
请求的全地址：http://plus31.366ec.net/Route.axd?method=vast.Store.manager.list，
主域名为：http://plus31.366ec.net/
@GET包含的地址为：/Route.axd?method=vast.Store.manager.list