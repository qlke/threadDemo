package com.example.threadDemo.threadDemo;

/**
 * Author:qlke
 * Email:qlke@evistek.com
 * Created on 2020/9/2
 * Describe:使用两个线程交替打印0~100
 */
public class Number implements Runnable {

    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                    this.notify();
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
