//Пакет, у якому лежить клас CloudBank
package edu.nure.mjt.impl;
import edu.nure.mjt.api.Bank;
import edu.nure.mjt.User;и
import edu.nure.mjt.BankCard;
import edu.nure.mjt.CreditBankCard;
import edu.nure.mjt.DebitBankCard;
import edu.nure.mjt.BankCardType;
import java.util.concurrent.ThreadLocalRandom;

//Оголошення публічного класу CloudBank, який буде реалізовувати інтерфейс Bank
public class CloudBank implements Bank {

    //Створення тіла методу createBankCard, що повертає нову банк. картку із інтерфейсу Bank
    @Override
    public BankCard createBankCard(User user, BankCardType type) {

        String cardNumber = generateCardNumber();//Номер нової банк. картки

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
