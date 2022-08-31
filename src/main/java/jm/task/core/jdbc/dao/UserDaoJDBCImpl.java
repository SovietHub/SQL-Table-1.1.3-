package jm.task.core.jdbc.dao;

import com.mysql.cj.conf.ConnectionPropertiesTransform;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Connection connection = Util.getConnection(); // установка соединения с БД

    //Класс dao должен иметь конструктор пустой/по умолчанию
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() { // Создание таблицы для User(ов) – не должно приводить к исключению, если такая таблица уже существует
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Persons` (\n"
                    + " `id` INT NOT NULL AUTO_INCREMENT,\n"
                    + " `name` VARCHAR(50) NOT NULL,\n"
                    + " `lastName` VARCHAR(50) NOT NULL,\n"
                    + " `age` INT NOT NULL,\n"
                    + " PRIMARY KEY (`id`),\n"
                    + " UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);");

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        System.out.println("Успех! Таблица создана.");
    } // done and works

    public void dropUsersTable() { // Удаление таблицы User(ов) – не должно приводить к исключению, если таблицы не существует
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS `Persons`");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    } // done and works

    public void saveUser(String name, String lastName, byte age) { // Добавление User в таблицу
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `Persons`"
                    + "(name, lastName, age) VALUES (?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println(new StringBuilder().append("User с именем – ").append(name).append(" добавлен в базу данных"));
        } catch (SQLException | NullPointerException exception) {
            exception.printStackTrace();
        }
    } // done and works

    public void removeUserById(long id) { // Удаление User из таблицы ( по id )
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `Persons`  WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    } // done and works

    public List<User> getAllUsers() { //  Получение всех User(ов) из таблицы
        List<User> listUser = new ArrayList<>();
        User user = new User();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `Persons`");

            while (resultSet.next()) {

                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                listUser.add(user);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return listUser;
    } // done and works

    public void cleanUsersTable() { // Очистка содержания таблицы
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE TABLE `Persons`");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    } // done and works
}
