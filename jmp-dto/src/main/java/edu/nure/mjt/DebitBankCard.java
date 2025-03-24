package edu.nure.mjt;

//Оголошення класу для створення дебетової банківської картки
public class DebitBankCard extends BankCard {

    private double balance; // Баланс на картці

    //Конструктор, що формує об'єкт класу - дебетову банківську картку
    public DebitBankCard(String number, User user, double balance) {
        super(number, user, BankCardType.DEBIT); // Викликаємо конструктор батьківського класу BankCard, від якого
        //дочірній клас DebitBankCard успадковує номер та користувача + до батьківського класу BankCard передається тип картки Debit
        this.balance = balance; // додаємо змінну типу картки, якої нема в батьківському класі
        }

    //Метод, який дозволяє дізнатися баланс дебетової картки
    public double getBalance() {
            return balance;
        }

    //Метод, що дозволяє змінити значення балансу картки 
    public void setBalance(double balance) {
            this.balance = balance;
        }
    }

