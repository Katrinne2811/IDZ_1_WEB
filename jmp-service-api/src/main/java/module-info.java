module jmp.service.api {
    requires jmp.dto;//Потрібен модуль з класами User, BankCard
    exports edu.nure.mjt.serv.api;//Експортуємо пакет з модуля jmp-service-api для його видимості іншими модулями
    //в тому числі і реалізація інтерфейсу Service з пакету
}