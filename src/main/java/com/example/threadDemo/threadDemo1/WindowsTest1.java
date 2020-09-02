package com.example.threadDemo.threadDemo1;

/**
 * Author:qlke
 * Email:qlke@evistek.com
 * Created on 2020/9/1
 * describe:创建多个线程售票
 */
public class WindowsTest1 {

    public static void main(String[] args) {
        Windows1 w = new Windows1();
        new Thread(w, "售票口1").start();
        new Thread(w, "售票口2").start();
        new Thread(w, "售票口3").start();
    }
}
