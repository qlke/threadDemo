package com.example.threadDemo.threadDemo1;

/**
 * Author:qlke
 * Email:qlke@evistek.com
 * Created on 2020/9/1
 * describe:创建三个窗口，同时去售票会出现数据错误的情况
 * 因为上一个线程还没执行完成，后面的线程已经开始执行啦
 */
public class WindowsTest {
    public static void main(String[] args) {
        Windows w = new Windows();
        new Thread(w, "窗口1").start();
        new Thread(w, "窗口2").start();
        new Thread(w, "窗口3").start();
    }
}
