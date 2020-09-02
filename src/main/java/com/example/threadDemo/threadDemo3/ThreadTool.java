package com.example.threadDemo.threadDemo3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:qlke
 * Email:qlke@evistek.com
 * Created on 2020/9/2
 */
public class ThreadTool {
    public static void main(String[] args) {
        //提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new NumberThread1());
        service.execute(new NumberThread2());
        service.shutdown();
    }
}

class NumberThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NumberThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}