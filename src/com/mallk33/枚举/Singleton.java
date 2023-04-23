package com.mallk33.枚举;

/**
 * Created by m33
 * Date 2023/4/20 11:16
 * Description 单例模式 - 枚举
 */
public enum Singleton {
    INSTANCE;

    public void add(int x, int y) {
        System.out.println(x + y);
    }
}
