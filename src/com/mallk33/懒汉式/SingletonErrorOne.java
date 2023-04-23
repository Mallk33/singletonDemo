package com.mallk33.懒汉式;

/**
 * Created by m33
 * Date 2023/4/20 15:31
 * Description 第一种错误的懒汉式单例模式
 */
public class SingletonErrorOne {
    private static SingletonErrorOne INSTANCE;

    private SingletonErrorOne() {
    }

    // 第一种错误的懒汉式单例模式，多线程下线程不安全，会产生多个实例
    public static SingletonErrorOne getInstance() {
        if (INSTANCE == null) {
            System.out.println(Thread.currentThread().getName() + "：开始生成新实例");
            INSTANCE = new SingletonErrorOne();
        }
        return INSTANCE;
    }
}
