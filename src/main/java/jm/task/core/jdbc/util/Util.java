package jm.task.core.jdbc.util;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    private static final String HOST = "jdbc:mysql://localhost:3306/new_schema";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "Asl6580Rushan!";

    private static final Connection connection;
    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .addAnnotatedClass(User.class)
                .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/new_schema")
                .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                .setProperty("hibernate.connection.username", "root")
                .setProperty("hibernate.connection.password", "Asl6580Rushan!")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                .setProperty("show_sql", "true")
                .setProperty("format_sql", "true")
                .setProperty("hibernate.hbm2ddl.auto", "none")
                .buildSessionFactory();

        try {
            connection = DriverManager.getConnection(HOST, LOGIN, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}