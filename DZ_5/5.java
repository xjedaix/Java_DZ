// Организовать вводи и хранение данных пользователей. ФИО возраст и пол
// вывод в формате Фамилия И.О. возраст пол
// добавить возможность выхода или вывода списка отсортированного по возрасту!)
// *реализовать сортировку по возрасту с использованием индексов
// *реализовать сортировку по возрасту и полу с использованием индексов


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class User {
    private String fullName;
    private int age;
    private String gender;

    public User(String fullName, int age, String gender) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return fullName + " " + age + " " + gender;
    }
}

class UserCollection {
    private List<User> users;

    public UserCollection() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void printUsers() {
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    public void printUsersSortedByAge() {
        List<User> sortedUsers = new ArrayList<>(users);
        Collections.sort(sortedUsers, Comparator.comparingInt(User::getAge));
        for (User user : sortedUsers) {
            System.out.println(user.toString());
        }
    }

    public void printUsersSortedByAgeAndGender() {
        List<User> sortedUsers = new ArrayList<>(users);
        Collections.sort(sortedUsers, Comparator.comparingInt(User::getAge).thenComparing(User::getGender));
        for (User user : sortedUsers) {
            System.out.println(user.toString());
        }
    }
}

public class UserManagement {
    public static void main(String[] args) {
        UserCollection userCollection = new UserCollection();

        userCollection.addUser(new User("Ivanov Ivan Ivanovich", 30, "Male"));
        userCollection.addUser(new User("Petrov Petr Petrovich", 25, "Male"));
        userCollection.addUser(new User("Sidorova Anna Sergeevna", 35, "Female"));
        userCollection.addUser(new User("Smirnov Sergey Ivanovich", 28, "Male"));

        System.out.println("All Users:");
        userCollection.printUsers();

        System.out.println("Users Sorted by Age:");
        userCollection.printUsersSortedByAge();

        System.out.println("Users Sorted by Age and Gender:");
        userCollection.printUsersSortedByAgeAndGender();
    }
}