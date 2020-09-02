package com.example.threadDemo.threadDemo1;

/**
 * Author:qlke
 * Email:qlke@evistek.com
 * Created on 2020/9/1
 * describe:相较于windows类，这里加了同步锁
 * 使用了当前类对象this作为锁对象，保证当前类数据完整性
 */
public class Windows1 implements Runnable {

    int ticket = 100;

    @Override
    public void run() {

        while (true) {
            synchronized (this) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在售票，还剩" + ticket + "张。");
                    ticket--;
                } else {
                    System.out.println("全部售完。");
                    break;
                }
            }
        }
    }
}
