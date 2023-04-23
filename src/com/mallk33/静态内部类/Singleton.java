package com.mallk33.静态内部类;

/**
 * 单例模式 - 静态内部类方式
 */
public class Singleton {

    private Singleton() {
    }

    private static class SingletonInstance {
        private final static Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
