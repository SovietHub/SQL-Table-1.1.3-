package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // поля для установки соединения с базой данных//
    private static final String url = "jdbc:mysql://localhost:3306/pre-project_1.1.3";
    private static final String user = "root";
    private static final String password = "soviet_union98";

    private static Connection connection;

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // статический инициализатор драйвера JDBC
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }

        try { // соединение с базой данных
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Установлено соединение c базой данных");
            connection.isClosed();
            if (connection.isClosed()) {
                System.out.println("Соединение закрыто");
            } else {
                System.out.println("Неудалось закрыть соединение");
            }
        } catch (SQLException exception) {
            System.out.println("Неудачное подключение к базе данных");

        }
        return connection;
    }
    // реализуйте настройку соеденения с БД
}
