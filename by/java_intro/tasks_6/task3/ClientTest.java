package by.java_intro.tasks_6.task3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

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

public class ClientTest {
    public static void main(String[] args) {
        System.out.println("Client started");
        try(Socket socket = new Socket("localhost", 1488);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream()) ) {
            
            Scanner scanner = new Scanner(System.in);

            while(true) {
                if (!in.ready()) {
                    System.out.println("Connection closed");
                    break;
                }
                while(in.ready()) {
                    System.out.println(in.readLine());
                }
                String s = scanner.nextLine();
                if (s.equals("exit")) {
                    break;
                }
                out.println(s);
                out.flush();
                Thread.sleep(200);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}