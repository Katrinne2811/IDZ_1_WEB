module jmp.cloud.bank.impl {
    requires transitive jmp.bank.api; // Необхідний зв'язок з модулем jmp.bank.api, де знаходиться інтерфейс Bank,
    //причому всі модулі, що пов'язані з jmp-cloud-bank-impl зможуть використовувати інтерфейс Bank
    requires jmp.dto;// Необхідний зв'язок з модулем jmp.dto, де знаходяться класи User, Bankcard
    exports edu.nure.mjt.impl;// Експорт пакету для відкриття доступу для нього іншим модулям.
    //Реалізація інтерфейсу Bank також доступна, бо саме в цьому пакеті зберігається клас CloudBank, що його реалізує
    }
