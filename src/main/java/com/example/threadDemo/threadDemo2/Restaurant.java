package com.example.threadDemo.threadDemo2;

/**
 * Author:qlke
 * Email:qlke@evistek.com
 * Created on 2020/9/1
 */
public class Restaurant {
    //总共有50条鱼，做一个菜消耗掉一条鱼
    int fish = 50;
    //菜单
    String[] foodName = {"红烧鱼", "清蒸鱼", "水煮鱼", "鱼头火锅", "肉香肉丝"};
    //菜品价格
    int[] foodPrice = {25, 30, 18, 45, 20};
    //每道菜使用的烹饪时间
    int[] time = {15, 20, 20, 25, 10};
    //菜品是否完成
    boolean finish;
    //收入总额
    int totalAmount;
    //菜品编号
    int foodNum;
    //顾客编号
    int cusNum;
}
