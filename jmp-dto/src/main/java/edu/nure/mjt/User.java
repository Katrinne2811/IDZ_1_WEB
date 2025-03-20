package edu.nure.mjt;

import java.time.LocalDate; // Імпорт календаря

public class User { // Утворюємо публічний (відкритий для використання) клас користувача (User) (шаблон, за яким створюється об'єкт)
    private String name; // Текстова змінна з іменем користувача, яка доступна лише цьому класу (її не можна змінити)
    private String surname; // Текстова змінна з призвищем користувача, яка доступна лише цьому класу
    private LocalDate birthday; // Змінна типу дати для Дня народження, яка доступна лише цьому класу

    // Конструктор - як зробити нового користувача User
    public User(String name, String surname, LocalDate birthday) {
        this.name = name; // "this.name" — змінній імені в класі User присвоюється name з констурктора
        this.surname = surname; //"this.surname" — змінній прізвища в класі User присвоюється surname з конструктора
        this.birthday = birthday; //"this.birthday" — змінній Дня народження в класі User присвоюється birthday з конструктора
    }

    // Геттери — методи у коді, що повертають значення приватних змінних:
    // імені, прізвища, Дня народження користувача (тобто, їх можна подивитися)
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public LocalDate getBirthday() {
        return birthday;
    }

    // Сеттери — методи у коді, що нічого не повертають (Void), а змінюють значення змінних:
    // імені, прізвища, Дня народження користувача на ті, що зазначено в дужках метода
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