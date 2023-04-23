package com.mallk33.枚举;

/**
 * Created by m33
 * Date 2023/4/21 20:11
 * Description
 */
public class SingletonTest {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton.INSTANCE.hashCode());
            }).start();
        }
    }
}
