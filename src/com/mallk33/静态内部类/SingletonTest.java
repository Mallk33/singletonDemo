package com.mallk33.静态内部类;

import com.mallk33.懒汉式.Singleton;
import com.mallk33.懒汉式.SingletonErrorOne;

/**
 * Created by m33
 * Date 2023/4/20 15:21
 * Description 单例模式测试类
 */
public class SingletonTest {

    public static void main(String[] args) {
        // 通过模拟多线程环境，我们可以看到每次获取的都是同个实例
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton.getInstance().hashCode());
            }).start();
        }
    }
}
