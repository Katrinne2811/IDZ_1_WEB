package edu.nure.mjt;

import java.time.LocalDateTime;

//Оголошення класу для створення запису про створення банк. картки
public class Subscription
{
    private String bankcard;//Номер стовреної карти
    private LocalDateTime startDate; //Дата відкриття картки

    //Конструктор для створення запису про оформлення кбанк. картки
    public Subscription(String bankcard, LocalDateTime startDate) {
        this.bankcard = bankcard;
        this.startDate = startDate;
    }

    //Методи, що дозволяють дізнатися номер картки чи дату відкриття
    public String getBankcard() {
        return bankcard;
    }
    public LocalDateTime getStartDate() {
        return startDate;
    }

    //Методи, що дозволяють змінити номер картки чи дату відкриття
    public void setBankcard(String bankcard) { this.bankcard = bankcard; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }
}
