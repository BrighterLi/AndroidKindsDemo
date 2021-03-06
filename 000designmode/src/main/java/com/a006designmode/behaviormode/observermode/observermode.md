1 观察者模式
设计模式（五）观察者模式: https://blog.csdn.net/itachi85/article/details/50773358
1)观察者模式（又被称为发布-订阅（Publish/Subscribe）模式
它定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象在状态变化时，会通知所有的观察者对象，使他们能够自动更新自己。
2)在观察者模式中有如下角色：
Subject：抽象主题（抽象被观察者），抽象主题角色把所有观察者对象保存在一个集合里，每个主题都可以有任意数量的观察者，抽象主题提供一个接口，可以增加和删除观察者对象。
ConcreteSubject：具体主题（具体被观察者），该角色将有关状态存入具体观察者对象，在具体主题的内部状态发生改变时，给所有注册过的观察者发送通知。
Observer：抽象观察者，是观察者者的抽象类，它定义了一个更新接口，使得在得到主题更改通知时更新自己。
ConcrereObserver：具体观察者，实现抽象观察者定义的更新接口，以便在得到主题更改通知时更新自身的状态。
3)使用场景
关联行为场景，需要注意的是，关联行为是可拆分的，而不是“组合”关系。
事件多级触发场景。
跨系统的消息交换场景，如消息队列、事件总线的处理机制。
4)优缺点
优点
解除耦合，让耦合的双方都依赖于抽象，从而使得各自的变换都不会影响另一边的变换。
缺点
在应用观察者模式时需要考虑一下开发效率和运行效率的问题，程序中包括一个被观察者、
多个观察者，开发、调试等内容会比较复杂，而且在Java中消息的通知一般是顺序执行，
那么一个观察者卡顿，会影响整体的执行效率，在这种情况下，一般会采用异步实现。
5)Android中的观察者模式
android源码中也有很多使用了观察者模式，比如OnClickListener、ContentObserver、android.database.Observable等；还有组件通讯库RxJava、RxAndroid、EventBus；在这里将拿我们最常用的Adapter的notifyDataSetChanged()方法来举例：
当我们用ListView的时候，数据发生变化的时候我们都会调用Adapter的notifyDataSetChanged()方法，这个方法定义在BaseAdaper中
6)理解重点
观察者模式核心就一个点，记住这个点你就能理解并记忆。要点：用一个list把观察者保存起来，并提供add和remove观察者，在被观察者变化的时候就遍历并调用list里观察者的方法。核心就是一个list遍历
