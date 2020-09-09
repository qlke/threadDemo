package com.example.threadDemo.ChatRoom;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Author:qlke
 * Email:qlke@evistek.com
 * Created on 2020/9/2
 */
public class TestClient {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        InetAddress serverIp = null;
        OutputStream outputStream = null;

        try {
            serverIp = InetAddress.getByName("localhost");
            int port = 9999;
            System.out.println("开始连接服务器...");
            socket = new Socket(serverIp, port);
            System.out.println("连接成功。");
            outputStream = socket.getOutputStream();
            System.out.println("");
            outputStream.write("你好，我发送消息过来了！！！".getBytes());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
    }
}
