package main;

import DBService.DBService;
import DBService.DBException;
import entity.User;
import org.apache.log4j.Logger;


import java.util.Scanner;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) throws DBException {
        log.isTraceEnabled();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введи логин");
        String login = scanner.nextLine();
        System.out.println("Введи email");
        String email = scanner.nextLine();
        System.out.println("Введи пароль");
        String pass = scanner.nextLine();

        User user = new User(login, pass, email);
        DBService dbService = new DBService();
        dbService.printConnectInfo();
        long userId = dbService.addUser(user);
        System.out.println(userId);
        System.out.println(dbService.getUser(userId));


    }


}
