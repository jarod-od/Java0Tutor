package by.java_intro.tasks_6.task3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import by.java_intro.tasks_6.task3.controller.Menu;

/**
 * Задание 3: создайте клиент-серверное приложение “Архив”.     
 * Общие требования к заданию:    
 * •   В архиве хранятся Дела (например, студентов). Архив находится на сервере.  
 * •   Клиент, в зависимости от прав, может запросить дело на просмотр, внести в  него изменения, или создать новое дело.         
 * 
 * Требования к коду лабораторной работы:  
 * •   Для реализации сетевого соединения используйте сокеты.  
 * •   Формат хранения данных на сервере – xml-файлы. 
 */

public class ServerTest {
    public static void main(String[] args) {
        System.out.println("Server started");
        try(ServerSocket serverSocket = new ServerSocket(1488);
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream()) ) {
            
            //init
            boolean isAdmin = false;
            System.out.println("Client connected");
            while(true) {
                out.println("Input access level (admin, user)");
                out.flush();
                System.out.println("ask client for access level");
                String s = in.readLine();
                if (s.equals("admin")) {
                    isAdmin = true;
                    break;
                } else if (s.equals("user")) {
                    isAdmin = false;
                    break;
                }
            }

            System.out.println("is admin: " + isAdmin);

            Menu menu = new Menu(isAdmin, in, out);
            menu.runMainMenu();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}