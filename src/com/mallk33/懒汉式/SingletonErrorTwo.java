package com.mallk33.懒汉式;

/**
 * Created by m33
 * Date 2023/4/20 15:31
 * Description 第二种错误的懒汉式单例模式（线程安全但是性能太差了）
 */
public class SingletonErrorTwo {
    private static SingletonErrorTwo INSTANCE;

    private SingletonErrorTwo() {
    }

    // 第二种错误的懒汉式单例模式，虽然线程安全了但是性能太差了，已经退化为单线程，而且整个实例方法都被阻塞了
    // 如果该实例方法中存在其他耗时的代码，将会大大降低接口性能，这时候我们可以降低锁粒度，只锁定部分代码
    public static synchronized SingletonErrorTwo getInstance() {
        try {
            // 耗时代码
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (INSTANCE == null) {
            System.out.println(Thread.currentThread().getName() + "：开始生成新实例");
            INSTANCE = new SingletonErrorTwo();
        }
        return INSTANCE;
    }
}
