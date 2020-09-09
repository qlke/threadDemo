package com.example.threadDemo.ChatRoom;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:qlke
 * Email:qlke@evistek.com
 * Created on 2020/9/2
 */
public class Server {
    private ServerSocket server;
    private Socket socket;
    /*
     * 保存所有客户端的输出流
     * 用到的特点是:内部类可以访问外部内的属性,因此这些属性可以作为内部类的公共区域
     */
    private PrintWriter[] allOut = {};

    public Server() {
        try {
            System.out.println("正在启动服务器...");
            server = new ServerSocket(8888);
            System.out.println("服务器启动完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            while (true) {
                System.out.println("等待客户端连接...");
                Socket socket = server.accept();
                ClientHandler C = new ClientHandler(socket);
                Thread T = new Thread(C);
                T.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server s = new Server();
        s.start();
    }


    class ClientHandler implements Runnable {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(isr);

                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out);
                BufferedWriter bw = new BufferedWriter(osw);
                PrintWriter pw = new PrintWriter(bw, true);
                /*
                 * 将当前客户端的输出流存入共享数组allOut中
                 */
                //1:对allOut数组扩容
                allOut = Arrays.copyOf(allOut, allOut.length + 1);
                //2:将输出流存入数组中
                allOut[allOut.length - 1] = pw;
                System.out.println("当前在线人数:" + allOut.length);
                /*
                 * 这里需要使用下面的方式来读取客户端发送过来的内容
                 * brd.readLine()这个方法在不同系统下运行时会有不同的反应
                 * windows系统,客户端断开会发生异常
                 * Linux系统客户端的断开返回空,当返回null时保证循环能够结束
                 */
                Scanner scan = new Scanner(System.in);
                System.out.println("输入内容：");
                String content = scan.next();
                pw.println(content);
                String str = null;
                while ((str = br.readLine()) != null) {
                    System.out.println("客户端说:" + str);
                    for (int i = 0; i < allOut.length; i++) {
                        if (allOut[i] == pw) {
                            continue;
                        }
                        allOut[i].println("服务端说:" + str);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //处理客户端断开后的操作
                //1:将当前客户端的输出流从数组中删除
                //2:关闭sokcet释放资源
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
