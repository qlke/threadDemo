package com.example.threadDemo.threadDemo1;

/**
 * Author:qlke
 * Email:qlke@evistek.com
 * Created on 2020/9/1
 * describe:模拟3个窗口共享一个资源
 */
public class Windows implements Runnable {
    //100张火车票
    int ticket = 100;

    @Override
    public void run() {
        while (true) {
            try {
                //为了看的更清楚，每个线程执行的时候都阻塞一会儿
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "正在售票，还剩" + ticket + "张。");
                ticket--;
            } else {
                System.out.println("所有车票已出售完毕。");
                break;
            }
        }
    }
}
