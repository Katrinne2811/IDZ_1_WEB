package edu.nure.mjt.serv.api;

import edu.nure.mjt.BankCard;
import edu.nure.mjt.Subscription;
import edu.nure.mjt.User;
import java.util.List;//Пакет для створення списку
import java.util.Optional;//Контейнер для певного значення
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public interface Service {
    //Метод для формування запису про створення банківської картки
    void subscribe(BankCard bankCard);

    //Метод, що виводить середній вік користувачів зі списку всіх користувачів банку. Якщо список користувачів порожній, то виводиться 0
    default double getAverageUsersAge() {
        return getAllUsers().stream().mapToLong(user -> ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now()))
                .average()
                .orElse(0.0);
    }

    //Метод, що перевіряє, чи є користувачеві банку 18 років.
    static boolean isPavableUser(User user) {
        return ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now()) >= 18;
    }

    //Метод пошуку запису про створену банк. картку за вказаним у дужках номером картки
    Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber);

    //Створення списку з усіма користувачами банку
    List<User> getAllUsers();
}
