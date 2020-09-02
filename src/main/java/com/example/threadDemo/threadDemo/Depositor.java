package com.example.threadDemo.threadDemo;

/**
 * Author:qlke
 * Email:qlke@evistek.com
 * Created on 2020/9/2
 */
public class Depositor implements Runnable {

    int account;

    @Override
    public void run() {
        while (account < 3000) {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "：存入1000元。");
                account += 1000;
                System.out.println("账户余额：" + account);
                this.notify();
                try {
                    this.wait();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        System.out.println("账户总额：" + account);
    }
}
