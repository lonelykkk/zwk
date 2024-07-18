package com.kkk.socket;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient1 {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 1024);

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            System.out.println("请输入内容");

            new Thread(() -> {
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    try {
                        printWriter.println(input);
                        printWriter.flush();
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }

                }
            }).start();

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            new Thread(() -> {
                while (true) {
                    try {
                        String readData = bufferedReader.readLine();
                        System.out.println("收到服务端消息" + readData);
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
