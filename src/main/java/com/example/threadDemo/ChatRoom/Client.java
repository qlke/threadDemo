package com.example.threadDemo.ChatRoom;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author:qlke
 * Email:qlke@evistek.com
 * Created on 2020/9/2
 */
public class Client {

    Socket socket;
    String serverIp = "localhost";
    int port = 8888;

    public Client() {
        try {
            System.out.println("开始连接...");
            socket = new Socket(serverIp, port);
            System.out.println("连接成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            ServerHandler s = new ServerHandler();
            Thread t = new Thread(s);
            t.start();
            OutputStream ops = socket.getOutputStream();
            OutputStreamWriter bos = new OutputStreamWriter(ops);
            BufferedWriter bw = new BufferedWriter(bos);
            PrintWriter pw = new PrintWriter(bw, true);
            Scanner scan = new Scanner(System.in);
            while (true) {
                System.out.print("请输入内容：");
                String str = scan.next();
                pw.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    /**
     * 该线程负责循环读取服务端发送过来的信息
     *
     * @author shuye
     */
    class ServerHandler implements Runnable {
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String str = null;
                while ((str = br.readLine()) != null) {
                    System.out.println(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
