package edu.nure.mjt;

import java.time.LocalDateTime;

public class Subscription
{
    private String bankcard;//приватна текстова змінна з номером картки
    private LocalDateTime startDate; //приватна змінна типу дати з датою відкриття запису

    //Конструктор - як створити об'экт класу Subscription (опис даних картки з номером bankcard)
    public Subscription(String bankcard, LocalDateTime startDate) {
        this.bankcard = bankcard;
        this.startDate = startDate;
    }

    //Геттери - методи, що дозволяють дізнатися значення змінних номеру картки чи дати відкриття ,банк. картки з даними Subscription
    public String getBankcard() {
        return bankcard;
    }
    public LocalDateTime getStartDate() {
        return startDate;
    }

    //Сеттери - методи, що дозволяють змінити значення змінних номеру картки чи дати відкриття картки з описом Subscription
    //на вказані у дужках
    public void setBankcard(String bankcard) { this.bankcard = bankcard; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }
}
