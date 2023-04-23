package com.mallk33.饿汉式;

import java.io.Serializable;

/**
 * 饿汉式单例模式 - 静态变量方式
 */
public class Singleton implements Serializable {

    private final static Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    public Object readResolve() {
        return getInstance();
    }

}
