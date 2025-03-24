package edu.nure.mjt;

public class CreditBankCard extends BankCard {

    private double creditLimit; //Сума ліміту кредитної картки

    //Конструктор "картки" - вказує, як створити об'єкт класу  CreditBankCard - кредитну картку
    public CreditBankCard(String number, User user, double creditLimit) {
        super(number, user, BankCardType.CREDIT); // Викликаємо конструктор батьківського класу BankCard, від якого 
        //дочірній клас CreditBankCard успадковує номер та користувача. До батьківського класу BankCard передається тип картки Credit
        this.creditLimit = creditLimit; // додаємо змінну типу картки, якої нема в батьківському класі
    }

    //Метод, який дозволяє дізнатися кредитний ліміт картки
    public double getCreditLimit() { return creditLimit;}

    //Метод, що дозволяє змінити кредитний ліміт картки
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
}
