module jmp.bank.api {
    requires jmp.dto;//Модуль jmp.bank.api залежить від модуля jmp.dto
    exports edu.nure.mjt.api;//Експорт пакета edu.nure.mjt.api з інтерфейсом Bank,
    //щоб його могли "побачити" класи з іншого пакету
}