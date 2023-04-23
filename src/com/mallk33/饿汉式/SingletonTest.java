package com.mallk33.饿汉式;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by m33
 * Date 2023/4/20 14:31
 * Description 单例测试类
 */
public class SingletonTest {

    /**
     * 参考文章：https://www.jianshu.com/p/e22ca93024f3
     * Singleton 单例类不加 final 的时候可以通过反射方式修改实例对象，加上 final 则会抛出异常
     */
    private static void testNotFinal() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton firstInstance = Singleton.getInstance();
        System.out.println("第一次拿到单例模式创建的对象：" + firstInstance);
        // 1.获得 Singleton 类
        Class<Singleton> clazz = Singleton.class;
        // 2.获得 Singleton 类的私有无参构造方法，并通过 setAccessible(true) 允许我们通过反射的方式调用该私有构造方法
        Constructor<Singleton> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        // 3.创建新的实例对象
        Singleton clazzSingleton = constructor.newInstance();
        System.out.println("反射创建出来的对象: " + clazzSingleton);
        // 4.获取 Singleton 类中所有声明的字段，即包括public、private和 protected，但是不包括父类的字段，目前只有 INSTANCE
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // 设置 true：允许通过反射访问该字段
            field.setAccessible(true);
            // 向 Singleton 对象(firstInstance)的这个 Field 属性(即：INSTANCE)设置新值 clazzSingleton
            field.set(firstInstance, clazzSingleton);
            Singleton secondInstance = Singleton.getInstance();
            System.out.println("第二次拿到单例模式创建的对象: " + secondInstance);
        }
    }

    /**
     * 简单测试通过单例类（静态变量方式）获取的是否是同个对象
     */
    public static void testSingleton() {
        Singleton singletonOne = Singleton.getInstance();
        Singleton singletonTwo = Singleton.getInstance();
        // 输出结果： true
        System.out.println("两次获取的都是同一个对象：" + (singletonOne == singletonTwo));
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        // 测试 Singleton 获取的是否是同个对象
        // testSingleton();

        // 测试不加 final 是否能成功修改 Singleton 类的实例对象
        // testNotFinal();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
        oos.writeObject(Singleton.getInstance());
        File file = new File("tempFile");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Singleton Singleton = (Singleton) ois.readObject();
        System.out.println(Singleton);
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance() == Singleton);
    }

}
