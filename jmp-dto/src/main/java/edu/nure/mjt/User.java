package edu.nure.mjt;

import java.time.LocalDate; // Імпорт календаря

// Оголошення класу користувача банківської картки
public class User { 
    private String name; // Ім'я користувача
    private String surname; // Прізвище користувача
    private LocalDate birthday; // Дня народження користувача

    // Створення користувача - об'єкта класу 
    public User(String name, String surname, LocalDate birthday) {
        this.name = name; //Присвоєння змінній імені заданого у дужках значення
        this.surname = surname; //Присвоєння змінній прізвища заданого у дужках значення
        this.birthday = birthday; //Присвоєння змінній дати народження заданого у дужках значення
    }

    // Методи що повертають значення імені, прізвища, Дня народження користувача
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public LocalDate getBirthday() {
        return birthday;
    }

    //Методи, що змінюють значення імені, прізвища, Дня народження користувача
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
