package edu.nure.mjt;

public class DebitBankCard extends BankCard {


    private double balance; // Приватна змінна - число з крапкою - баланс на картці

    //Конструктор - формує об'єкт класу - дебетову банківську картку
    public DebitBankCard(String number, User user, double balance) {
        super(number, user, BankCardType.DEBIT); // Викликаємо конструктор батьківського класу BankCard, від якого
        //дочірній клас DebitBankCard успадковує номер та користувача.
        //До батьківського класу BankCard передається тип картки Debit
        this.balance = balance; // додаємо нову змінну, якої нема в батьківської картки:
        // "this.balance" — змінній балансу дебетової картки в класі DebitBankCard присвоюється значення balance з дужок конструктора
        }

    //Геттер - метод, який дозволяє дізнатися баланс дебетової картки
    public double getBalance() {
            return balance;
        }

    //Сеттер - метод, що дозволяє змінити значення балансу картки класу DebitBankCard
    // на значення balance з дужок
    public void setBalance(double balance) {
            this.balance = balance;
        }
    }

