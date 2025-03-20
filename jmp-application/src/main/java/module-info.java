module jmp.application {
    uses edu.nure.mjt.api.Bank;// Використання інтерфейсу Bank
    uses edu.nure.mjt.serv.api.Service;// Використанння інтерфейсу Service
    requires jmp.cloud.bank.impl; //Потрібен модуль jmp.cloud.bank.impl з класом, що реалізує Bank
    requires jmp.cloud.service.impl;//Потрібен модуль jmp.cloud.service.impl з класом, що реалізує Service
    requires jmp.dto;// Потребуємо класи User, BankCard, Subscription
}
