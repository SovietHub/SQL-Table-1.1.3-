package jm.task.core.jdbc;
/*
 В методе main необходимо:

 1)Создание таблицы User(ов)
 2)Добавление 4 User(ов) в таблицу с данными на свой выбор.
 3)После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
 4)Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
 5)Очистка таблицы User(ов)
 6)Удаление таблицы

 */

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.service.UserService;
import jm.task.core.jdbc.util.service.UserServiceImpl;

public class Main {
    private static final UserService userService = new UserServiceImpl(); // new static поля для работы в main c не static
    private static User firstPerson = new User( "Иван", "Петров", (byte) 18);
    private static User secondPerson = new User("Павел", "Корчагин", (byte) 30);
    private static User thirdPerson = new User ("Юрий", "Гагарин", (byte) 27);
    private static User fourthPerson = new User ("Павлик", "Морозов", (byte) 13);

    public static void main(String[] args) {
        userService.createUsersTable (); // создаю таблицу

                                        //---Занесение в таблицу людей---//
        userService.saveUser(firstPerson.getName(),firstPerson.getLastName(),firstPerson.getAge());
        userService.saveUser(secondPerson.getName(),secondPerson.getLastName(),secondPerson.getAge());
        userService.saveUser(thirdPerson.getName(),thirdPerson.getLastName(),thirdPerson.getAge());
        userService.saveUser(fourthPerson.getName(),fourthPerson.getLastName(),fourthPerson.getAge());

        userService.getAllUsers();//Получение всех User из базы и вывод в консоль

        userService.cleanUsersTable(); //Очистка таблицы User(ов)

        userService.dropUsersTable(); // удаление таблицы
    }
}
