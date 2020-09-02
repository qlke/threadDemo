package com.example.threadDemo.threadDemo;

/**
 * Author:qlke
 * Email:qlke@evistek.com
 * Created on 2020/9/1
 */
public class MyThreadDemo extends Thread {

    @Override
    public void run() {
        System.out.println("继承thread类，重写thread类的run方法创建线程。");
    }

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println("使用匿名内部类创建线程的方法1。");
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("使用匿名内部类创建线程的方法2。");
            }
        });
    }
}



