package edu.nure.mjt;

//Клас, що описує об'єкт "банківська картка"
public class BankCard {
        private String number;//номер картки 
        private User user;//користувач картки
        private BankCardType type;//тип картки - кредитна чи дебетова

    //Конструктор, що "утворює" банківську картку з номером Number користувача user
    public BankCard(String number, User user, BankCardType type) {
            this.number = number;// "this.number" — змінній номера картки в класі BankCard присвоюється number з конструктора
            this.user = user;// "this.user" — змінній користувача картки в класі BankCard присвоюється user з конструктора
            this.type = type;// "this.type" — змінній типу картки в класі BankCard присвоюється type з дужок конструктора
        }

        //Методи, що дозволяють дізнатися значення змінних номеру картки, її користувача чи тип
        public String getNumber() { return number;}
        public User getUser() { return user;}
        public BankCardType getType() { return type;}

        //Методи, що дозволяють змінити значення змінних типу картки, номеру картки чи користувача картки 
        public void setNumber(String number) { this.number = number; }
        public void setUser(User user) { this.user = user; }
        public void setType(BankCardType type) { this.type = type; }
    }

