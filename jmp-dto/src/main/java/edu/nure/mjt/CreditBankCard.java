package edu.nure.mjt;

public class CreditBankCard extends BankCard {

    private double creditLimit; // приватна числова змінна з крапкою -  сума ліміту кредитної картки

    //Конструктор "картки" - вказує, як створити об'єкт класу  CreditBankCard - кредитну картку
    public CreditBankCard(String number, User user, double creditLimit) {
        super(number, user, BankCardType.CREDIT); // Викликаємо конструктор батьківського класу BankCard, від якого
        //дочірній клас CreditBankCard успадковує номер та користувача.
        //До батьківського класу BankCard передається тип картки Credit
        this.creditLimit = creditLimit; // додаємо нову змінну, якої нема в батьківської картки:
        // "this.creditLimit" — змінній ліміту крединої картки в класі CreditBankCard присвоюється creditLimit з конструктора
    }

    //Геттер - метод, який дозволяє дізнатися кредитний ліміт картки
    public double getCreditLimit() { return creditLimit;}

    //Сеттер - метод, що дозволяє змінити кредитний ліміт картки CreditBankCard на creditLimit з дужок
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
}
