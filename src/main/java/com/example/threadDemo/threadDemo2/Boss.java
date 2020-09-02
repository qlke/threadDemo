package com.example.threadDemo.threadDemo2;

/**
 * Author:qlke
 * Email:qlke@evistek.com
 * Created on 2020/9/1
 * describe: 老板负责收钱的线程
 */
public class Boss extends Thread {
    //使用餐厅作为同步锁对象
    private Restaurant res;

    public Boss(Restaurant res) {
        this.res = res;
    }

    @Override
    public void run() {
        //存在食材的情况
        while (res.fish > 0) {
            synchronized (res) {
                if (res.finish) {
                    try {
                        res.wait();//如果已经完成了菜品，则进入等待...
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("boss:好的，请稍等...");
                int time = res.time[res.foodNum];
                try {
                    Thread.sleep(time * 100);
                    System.out.println(time + "分钟后......");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("bass:" + res.cusNum + "号顾客，你的"
                        + res.foodName[res.foodNum] + "已做好，价格为" + res.foodPrice[res.foodNum] + "元。");
                res.fish--;
                res.finish = true;
                //唤醒当前锁对象的另一个线程
                res.notify();
            }
        }
        System.out.println("打烊，今天收入总额为" + res.totalAmount + "元。");
    }
}
