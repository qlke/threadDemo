package com.example.threadDemo.threadDemo;

/**
 * Author:qlke
 * Email:qlke@evistek.com
 * Created on 2020/9/2
 * describe:实现两个储户向一个账户轮流存钱
 */
public class DepositorTest {
    public static void main(String[] args) {
        Depositor depositor = new Depositor();
        Thread depositor1 = new Thread(depositor, "储户1");
        Thread depositor2 = new Thread(depositor, "储户2");
        depositor1.start();
        depositor2.start();
    }
}
