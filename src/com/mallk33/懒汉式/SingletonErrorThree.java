package com.mallk33.懒汉式;

/**
 * Created by m33
 * Date 2023/4/20 15:31
 * Description 第三种错误的懒汉式单例模式
 */
public class SingletonErrorThree {
    private static SingletonErrorThree INSTANCE;

    private SingletonErrorThree() {
    }

    // 这种方式虽然降低了锁粒度，但是会出现多实例的情况，所以在多线程下也是不可用的
    public static SingletonErrorThree getInstance() {
        try {
            // 耗时代码
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (INSTANCE == null) {
            synchronized (SingletonErrorThree.class) {
                System.out.println(Thread.currentThread().getName() + "：开始生成新实例");
                INSTANCE = new SingletonErrorThree();
            }
        }
        return INSTANCE;
    }
}
