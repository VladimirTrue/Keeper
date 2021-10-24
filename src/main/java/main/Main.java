package main;

import DBService.DBException;
import dao.DAO;
import dao.UserDao;
import entity.Period;
import entity.User;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.Scanner;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) throws DBException {

        SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            DAO<User, Long> dao = new UserDao(factory);

            log.isTraceEnabled();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введи логин");
            String login = scanner.nextLine();
            System.out.println("Введи email");
            String email = scanner.nextLine();
            System.out.println("Введи пароль");
            String pass = scanner.nextLine();

            User user = new User(login, pass, email);
            dao.create(user);
            System.out.println("Пользователь добавлен: " + user.toString());
            System.out.println("read: " + dao.read(user.getId()));
            user.setEmail("NEW EMAIL");
            dao.update(user);
            System.out.println("Пользователь обновлен: " + dao.read(user.getId()).toString());
            System.out.println("Удаление...");
            dao.delete(user);
            System.out.println(dao.read(user.getId()));
        } finally {
            if (factory != null) {
                factory.close();
            }
        }


    }

}
