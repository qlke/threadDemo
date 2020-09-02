package com.example.threadDemo.threadDemo;

/**
 * Author:qlke
 * Email:qlke@evistek.com
 * Created on 2020/9/2
 * Describe:创建两个线程去打印数字1~100
 */
public class NumberTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread thread1 = new Thread(number, "线程1");
        Thread thread2 = new Thread(number, "线程2");
        thread1.start();
        thread2.start();
    }
}
