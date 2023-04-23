package com.mallk33.懒汉式;

/**
 * Created by m33
 * Date 2023/4/20 15:21
 * Description 懒汉式单例模式测试类
 */
public class SingletonTest {
    /**
     * 测试第一种错误的单例模式
     */
    private static void testSingletonErrorOne() {
        // 通过模拟多线程环境，我们可以看到有多个线程在生成新实例
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(SingletonErrorOne.getInstance().hashCode());
            }).start();
        }
    }

    /**
     * 测试第二种错误的单例模式
     */
    private static void testSingletonErrorTwo() {
        // 通过模拟多线程环境，我们可以看到获取的都是同一个实例，但是已经变成同步操作了，效率非常的低下
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(SingletonErrorOne.getInstance().hashCode());
            }).start();
        }
    }

    /**
     * 测试第三种错误的单例模式
     */
    private static void testSingletonErrorThree() {
        // 通过模拟多线程环境，我们可以看到有多个线程在生成新实例
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(SingletonErrorOne.getInstance().hashCode());
            }).start();
        }
    }

    /**
     * 测试单例模式（DCL）
     */
    private static void testSingleton() {
        // 通过模拟多线程环境，我们可以看到每次获取的都是同个实例
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton.getInstance().hashCode());
            }).start();
        }
    }

    public static void main(String[] args) {
        // testSingletonErrorOne();
        // testSingletonErrorTwo();
        // testSingletonErrorThree();
        testSingleton();
    }
}
