package com.mallk33.饿汉式;

/**
 * 饿汉式单例模式 - 静态代码块方式
 */
public class Singleton1 {

    private final static Singleton1 INSTANCE;

    static {
        INSTANCE = new Singleton1();
    }

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

}
