package com.example.threadDemo.threadDemo2;

/**
 * Author:qlke
 * Email:qlke@evistek.com
 * Created on 2020/9/1
 * describe:模拟餐厅点餐的情况
 */
public class ControlTest {
    public static void main(String[] args) {
        //因为操作的数据对象时餐厅，所以使用餐厅作为锁对象，用锁对象在线程间通信
        Restaurant res = new Restaurant();
        //顾客点餐线程
        Customers cus = new Customers(res);
        //老板收钱线程
        Boss boss = new Boss(res);
        //开启顾客线程
        cus.start();
        //开启老板线程
        boss.start();
    }
}
