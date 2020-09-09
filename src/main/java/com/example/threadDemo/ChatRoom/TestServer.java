package com.example.threadDemo.ChatRoom;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:qlke
 * Email:qlke@evistek.com
 * Created on 2020/9/2
 */
public class TestServer {
    //ctrl+alt+l 格式化代码
    //alt+enter补全/提示

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            System.out.println("正在启动服务器...");
            serverSocket = new ServerSocket(9999);
            System.out.println("服务器启动完毕。");
            System.out.println("等待客户端连接...");
            accept = serverSocket.accept();
            inputStream = accept.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }
            System.out.println("读取来自客户端发送的消息：");
            System.out.println(byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (accept != null) {
                    accept.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
