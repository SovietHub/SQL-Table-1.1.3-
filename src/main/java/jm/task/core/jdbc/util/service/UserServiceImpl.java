package jm.task.core.jdbc.util.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;
//доработать//
public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl userDaoJDBCImpl = new UserDaoJDBCImpl();
    public void createUsersTable() {
        userDaoJDBCImpl.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoJDBCImpl.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoJDBCImpl.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDaoJDBCImpl.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoJDBCImpl.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoJDBCImpl.cleanUsersTable();
    }
}
