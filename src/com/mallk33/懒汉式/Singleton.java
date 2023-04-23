package com.mallk33.懒汉式;

/**
 * Created by m33
 * Date 2023/4/20 15:21
 * Description 懒汉式单例模式：双重校验锁（DCL，double-checked locking）
 */
public class Singleton {

    private static volatile Singleton INSTANCE;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

}
