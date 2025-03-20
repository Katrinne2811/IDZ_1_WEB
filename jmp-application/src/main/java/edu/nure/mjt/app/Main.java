package edu.nure.mjt.app;

import edu.nure.mjt.*;
import edu.nure.mjt.api.Bank;
import edu.nure.mjt.cloud.serv.CloudService;
import edu.nure.mjt.impl.CloudBank;
import edu.nure.mjt.serv.api.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//Створення користувача Kate Smith, що народилася 2 квітня 2002 року
        User Kate = new User("Kate", "Smith", LocalDate.of(2002, 2, 4));
        System.out.println("Name of user is: " + Kate.getName());
        System.out.println("Surname of user is: " + Kate.getSurname());
        System.out.println("The birthday of user is on the: " + Kate.getBirthday());

        //Зміна прізвища користувача
        Kate.setSurname("Perry");
        System.out.println("The new surname of " + Kate.getName() + " is " + Kate.getSurname());

        //Створення подарункової банк. картки з вказаним номером та датою відкриття
        Subscription subscript1 = new Subscription("4902847999030456", LocalDateTime.now());
        System.out.println("The subscription has number " + subscript1.getBankcard());
        System.out.println("The subscription starts from date " + subscript1.getStartDate());

        //Створення кредитної картки
        CreditBankCard creditCard = new CreditBankCard("1234567898763402", Kate, 5000.0);
        System.out.println("The user of credit bankcard with number " + creditCard.getNumber() + " is " + creditCard.getUser().getName());
        System.out.println("The card's credit limit is equal " + creditCard.getCreditLimit());

        //Створення дебетової картки користувача Mike
        User Mike = new User("Mike", "Kelly", LocalDate.of(2001, 6, 19));
        DebitBankCard debitCard = new DebitBankCard("9876543246871456", Mike, 10000.0);
        System.out.println("The user of debit bankcard with number " + debitCard.getNumber() + " is " + debitCard.getUser().getName());
        System.out.println("The card's balance is equal " + debitCard.getBalance());

        //Створення дебетової картки користувача Jane
        User Jane = new User("Jane", "Kelly", LocalDate.of(2003, 8, 14));
        DebitBankCard debitCard2 = new DebitBankCard("9876549044371021", Jane, 6700.0);
        System.out.println("The user " + debitCard2.getUser().getName() + " has " + debitCard2.getType() + " card.");
        System.out.println("The number of debit bankcard is " + debitCard2.getNumber());
        System.out.println("The Jane's card's balance is equal " + debitCard2.getBalance());

        //Зміна кредитного ліміту картки користувача Kate
        creditCard.setCreditLimit(8000.0);
        System.out.println("The new credit limit of Kate's credit card is equal " + creditCard.getCreditLimit());

        //Створено банк: за допомогою класу CloudBank буде реалізовано інтерфейс Bank
        Bank bank = new CloudBank();
        //Новий користувач, для якого створюємо карту
        User Sam = new User("Sam", "Bard", LocalDate.of(1995, 11, 7));
        //Створення кредитної картки для користувачв Sam
        BankCard bankCard = bank.createBankCard(Sam, BankCardType.CREDIT);
        System.out.println("It was created the bankcard for Sam with the number " + bankCard.getNumber());

        //Створення нового користувача (також без прямого вказання типу, хоч це об'єкт класу User)
        var John = new User("John", "Doe", LocalDate.of(1992, 5, 27));

        //Створення дебетової картки у створеному банку для користувача John
        BankCard card = bank.createBankCard(John, BankCardType.DEBIT);

        //Створення сервісу: через клас CloudService реалізовано інтерфейс Service
        Service service = new CloudService();

        //Створення запису про отримання картки Джоном
        service.subscribe(card);

        //Перевірка наявності запису про картку Джона в картотеці (об'єкт не конкретно визначеного типу)
        var subscription = service.getSubscriptionByBankCardNumber(card.getNumber());
        //Якщо отримано не порожній контейнер з записом, то виводиться номер картки та дата створення запису
        subscription.ifPresent(sub -> System.out.println("Subscription found for card: " + sub.getBankcard() + "and its start date is : " + sub.getStartDate()));

        //Створення банк. карток для повнолітнього та неповнолітнього користувачів та створення записів відповідних
        User Ivan = new User("Ivan", "Tomenko", LocalDate.of(1984, 3, 1)); // 25 років
        User Mary = new User("Mary", "Semenec", LocalDate.of(2010, 1, 1)); // 15 років
        BankCard card1 = bank.createBankCard(Ivan, BankCardType.DEBIT);
        BankCard card2 = bank.createBankCard(Mary, BankCardType.DEBIT);
        service.subscribe(card1);
        service.subscribe(card2);

        //Перевірка, чи є нові користувачі банку повнолітніми особами
        boolean isAdult1 = Service.isPavableUser(Ivan);
        boolean isAdult2 = Service.isPavableUser(Mary);
        System.out.println("Is Ivan is adult? The answer: " + isAdult1);
        System.out.println("Is Ivan is adult? The answer: " + isAdult2);

        //Отримання списку користувачів банку
        List<User> allUsers = service.getAllUsers();
        allUsers.forEach(user -> System.out.println("User: " + user.getName() + " " + user.getSurname()));

        //Обчислення середнього віку всіх користувачів, що є у списку
        double avgAge = service.getAverageUsersAge();
        System.out.println("The average age of users in the list is equal " + avgAge);

    }


}