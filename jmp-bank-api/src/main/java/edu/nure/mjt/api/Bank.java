package edu.nure.mjt.api;

import edu.nure.mjt.User;
import edu.nure.mjt.BankCard;
import edu.nure.mjt.BankCardType;

import java.time.LocalDate;
import java.time.Period;//Імпорт класу для обчислення часового інтервалу між 2 датами
import java.util.function.Predicate;//Імпорт типу, що дозволяє перевіряти умову

//"Правило", яке вказує, що треба створити банківську картку типу bankCardType користувачу user
public interface Bank {
    BankCard createBankCard(User user, BankCardType bankCardType);


}
