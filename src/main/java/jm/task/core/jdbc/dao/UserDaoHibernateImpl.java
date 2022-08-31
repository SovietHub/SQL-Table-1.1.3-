package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;

// 1)UserHibernateDaoImpl должен реализовывать интерефейс UserDao
// 2)В класс Util должна быть добавлена конфигурация для Hibernate ( рядом с JDBC), без использования xml.
// 3)Service на этот раз использует реализацию dao через Hibernate
// 4)Методы создания и удаления таблицы пользователей в классе UserHibernateDaoImpl
// должны быть реализованы с помощью SQL

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
