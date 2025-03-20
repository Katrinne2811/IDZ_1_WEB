package edu.nure.mjt;

public class BankCard {
        private String number;//номер картки - приватна текстова змінна (доступна лише класу), захищена від прямих змін
        private User user;//користувач картки - приватна змінна класу User (доступна лише класу), захищена від прямих змін
        private BankCardType type;//приватна змінна перерахування - один з типів картки: кредитна чи дебетова

    //Конструктор, що "утворює" банківську картку з номером Number користувача user
    public BankCard(String number, User user, BankCardType type) {
            this.number = number;// "this.number" — змінній номера картки в класі BankCard присвоюється number з конструктора
            this.user = user;// "this.user" — змінній користувача картки в класі BankCard присвоюється user з конструктора
            this.type = type;// "this.type" — змінній типу картки в класі BankCard присвоюється type з дужок конструктора
        }

        //Геттери - методи, що дозволяють дізнатися значення змінних номеру картки чи користувача картки BankCard
       //чи тип банкывськоъ картки
        public String getNumber() { return number;}
        public User getUser() { return user;}
        public BankCardType getType() { return type;}

        //Сеттери - методи, що дозволяють змінити значення змінних типу картки, номеру картки чи користувача картки BankCard
        //на вказані у дужках
        public void setNumber(String number) { this.number = number; }
        public void setUser(User user) { this.user = user; }
        public void getType(BankCardType type) { this.type = type; }
    }

