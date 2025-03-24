//Пакет, у якому лежить цей клас CloudBank
package edu.nure.mjt.impl;
import edu.nure.mjt.api.Bank;//Імпорт інтерфейса Bank із модуля jmp-bank-api
// для його реалізації за допомогою класу CloudBank
import edu.nure.mjt.User;// Імпорт класу User із модуля jmp-dto для роботи
// з користувачами - об'єтами класу User.
import edu.nure.mjt.BankCard;//Імпорт класу BankCard із jmp-dto,
//який є базовим для карток будь-якого типу
import edu.nure.mjt.CreditBankCard;//Імпорт класу CreditBankCard із jmp-dto для реалізації кредитної картки
import edu.nure.mjt.DebitBankCard;//Імпорт класу CreditBankCard із jmp-dto для реалізації дебетової картки
import edu.nure.mjt.BankCardType;//Імпорт переліку enum BankCardType із jmp-dto, який визначає
//тип створеної картки (CREDIT, DEBIT).
import java.util.concurrent.ThreadLocalRandom;//Модуль для генерації випадкових чисел

//Оголошення публічного класу CloudBank, який буде реалізовувати інтерфейс Bank, тобто шаблон створення банківської картки
public class CloudBank implements Bank {

    //Беремо метод createBankCard із інтерфейсу Bank, який приймає користувача (user)
    //і тип картки (type), а повертає об’єкт BankCard - банківську картку, та його змінюємо
    @Override
    public BankCard createBankCard(User user, BankCardType type) {

        String cardNumber = generateCardNumber();//Текстова змінна з номером картки,
        //який рандомно генерується методом generateCardNumber()

        //Перевірка: який тип картки передано (CREDIT чи DEBIT).
        switch (type) {
            //Якщо тип CREDIT (кредитна картка), то метод повертає кредит. картку з лімітом 1000 грош. од.
            case CREDIT:
                return new CreditBankCard(cardNumber, user, 1000.0);

            // Якщо тип DEBIT (дебетова картка), то повертається дебет. картка з порожнім балансом
            case DEBIT:
                return new DebitBankCard(cardNumber, user, 0.0);

            // Якщо тип не CREDIT і не DEBIT, то повертаємо виняток із повідомленням, що тип картки не підтримується
            default:
                throw new IllegalArgumentException("Невідомий тип картки: " + type);
        }
    }

    //Метод, який генерує номер створеної картки
    private String generateCardNumber() {
        long min = 1000000000000000L; // Найменше 16-значне число
        long max = 9999999999999999L; // Найбільше 16-значне число
        long randomNumber = ThreadLocalRandom.current().nextLong(min, max + 1); //Генерація випадкового числа - номера картки - в зазначених межах
        return String.valueOf(randomNumber); //Повертається конвертоване в рядок число
    }

}
