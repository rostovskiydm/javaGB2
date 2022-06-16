package ru.gb.rostovskiy.javaGB2.homework6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private DataInputStream in;
    private DataOutputStream out;

    public static void main(String[] args) {
        new Server().start();
    }

    private void start() {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Ждем подключения клиента...");
            final Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            receiveMessage();
            Scanner scanner = new Scanner(System.in);
            String phrase;
            do {
                phrase = scanner.nextLine();

                sendMessage(phrase);
            } while (!"/end".equalsIgnoreCase(phrase));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        try {
            if ("/end".equalsIgnoreCase(message)){
                closeConnection();
            }
            out.writeUTF(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void receiveMessage() {
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    String message = in.readUTF();
                    if ("/end".equalsIgnoreCase(message)) {
                        break;
                    }
                    System.out.println("Сообщение от клиента: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeConnection();

            }

        });
        thread.setDaemon(true);
        thread.start();
    }

    private void closeConnection() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


