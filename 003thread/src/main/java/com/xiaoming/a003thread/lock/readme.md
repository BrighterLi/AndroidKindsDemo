1锁
Synchronized同步静态方法和非静态方法总结：https://blog.csdn.net/u010842515/article/details/65443084
(1)对象锁vs类锁
Synchronized修饰非静态方法，实际上是对调用该方法的对象加锁，俗称“对象锁”。
情况1：同一个对象在两个线程中分别访问该对象的两个同步方法
结果：会产生互斥。
解释：因为锁针对的是对象，当对象调用一个synchronized方法时，其他同步方法需要等待其执行结束并释放锁后才能执行。

情况2：不同对象在两个线程中调用同一个同步方法
结果：不会产生互斥。
解释：因为是两个对象，锁针对的是对象，并不是方法，所以可以并发执行，不会互斥。形象的来说就是因为我们每个线程在调用方法的时候都是new 一个对象，那么就会出现两个空间，两把钥匙，

Synchronized修饰静态方法，实际上是对该类对象加锁，俗称“类锁”。
情况1：用类直接在两个线程中调用两个不同的同步方法
结果：会产生互斥。
解释：因为对静态对象加锁实际上对类（.class）加锁，类对象只有一个，可以理解为任何时候都只有一个空间，里面有N个房间，一把锁，因此房间（同步方法）之间一定是互斥的。
注：上述情况和用单例模式声明一个对象来调用非静态方法的情况是一样的，因为永远就只有这一个对象。所以访问同步方法之间一定是互斥的。

情况2：用一个类的静态对象在两个线程中调用静态方法或非静态方法
结果：会产生互斥。
解释：因为是一个对象调用，同上。

情况3：一个对象在两个线程中分别调用一个静态同步方法和一个非静态同步方法
结果：不会产生互斥。
解释：因为虽然是一个对象调用，但是两个方法的锁类型不同，调用的静态方法实际上是类对象在调用，即这两个方法产生的并不是同一个对象锁，因此不会互斥，会并发执行。

总结：
    1.对象锁钥匙只能有一把才能互斥，才能保证共享变量的唯一性
    2.在静态方法上的锁，和 实例方法上的锁，默认不是同样的，如果同步需要制定两把锁一样。
    3.关于同一个类的方法上的锁，来自于调用该方法的对象，如果调用该方法的对象是相同的，那么锁必然相同，否则就不相同。比如 new A().x() 和 new A().x(),对象不同，锁不同，如果A的单利的，就能互斥。
    4.静态方法加锁，能和所有其他静态方法加锁的 进行互斥
    5.静态方法加锁，和xx.class 锁效果一样，直接属于类的
    
2 synchronized
(1)三种应用方式
1.作用于实例方法，当前实例加锁，进入同步代码前要获得当前实例的锁;
2.作用于静态方法，当前类加锁，进去同步代码前要获得当前类对象的锁;
3.作用于代码块，这需要指定加锁的对象，对所给的指定对象加锁，进入同步代码前要获得指定对象的锁。
在某些情况下，我们编写的方法体可能比较大，同时存在一些比较耗时的操作，而需要同步的代码又只有一小部分，如果直接对整个方法进行同步操作，可能会得不偿失，此时我们可以使用同步代码块的方式对需要同步的代码进行包裹，这样就无需对整个方法进行同步操作了。
修饰代码块:
其中普通代码块 如Synchronized(obj) 这里的obj 可以为类中的一个属性、也可以是当前的对象，它的同步效果和修饰普通方法一样;
Synchronized方法 (obj.class)静态代码块它的同步效果和修饰静态方法类似。