package com.example.threadDemo.threadDemo2;

import java.util.Random;

/**
 * Author:qlke
 * Email:qlke@evistek.com
 * Created on 2020/9/1
 * describe:顾客点餐线程
 */
public class Customers extends Thread {
    private Restaurant res;

    public Customers(Restaurant res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (res.fish > 0) {
            synchronized (res) {
                //顾客下单
                res.cusNum++;
                Random r = new Random();
                res.foodNum = r.nextInt(5);
                System.out.println(res.cusNum + "号顾客：来一份" + res.foodName[res.foodNum]);
                if (!res.finish) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("支付" + res.foodPrice[res.foodNum] + "元。");
                System.out.println("---------------欢迎下次光临----------------");
                res.finish = false;
                res.totalAmount += res.foodPrice[res.foodNum];
                res.notify();
            }
        }
    }
}
