module jmp.cloud.service.impl {
    requires transitive jmp.service.api; //Потрібен модуль, де знаходиться інтерфейс Service
    requires jmp.cloud.bank.impl;//Потрібен модуль, де знаходиться клас відкриття банку
    requires jmp.dto;// Потрібен модуль, де знаходяться класи BankCard, Subscription, User
    exports edu.nure.mjt.cloud.serv; //Експорт пакету, де знаходиться CloudService,
    //що реалізує інтерфейс Service, для видимості іншими модулями
}