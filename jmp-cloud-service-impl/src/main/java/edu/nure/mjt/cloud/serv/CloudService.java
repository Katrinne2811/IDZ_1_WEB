package edu.nure.mjt.cloud.serv;

import edu.nure.mjt.serv.api.Service;
import edu.nure.mjt.BankCard;
import edu.nure.mjt.Subscription;
import edu.nure.mjt.User;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;//Клас, що визначає структури даних, у які збираються дані з потоку

//Створення класу, що реалізує інтерфейс Service
public class CloudService implements Service {
    //Сховище даних із записами про банківські картки з ключем - номером картки
    private final Map<String, Subscription> subscriptions = new HashMap<>();
    //Сховище даних зі збереженими створеними банківськими картками з ключем - номером картки
    private final Map<String, BankCard> cards = new HashMap<>();


    //Тіло методу для створення запису про картку з інтерфейсу Service
    @Override
    public void subscribe(BankCard bankCard) {
        //Номер банк. картки
        String cardNumber = bankCard.getNumber();
        //Істинність наявності запису про картку з вказаним номером
        var alreadySubscribed = subscriptions.keySet().stream().anyMatch(number -> number.equals(cardNumber));

        //Якщо запису ще нема, то він створюється та зберігається в сховищах записів та створених банк. карток
        if (!alreadySubscribed) {
            var subscription = new Subscription(cardNumber, LocalDateTime.now());
            subscriptions.put(cardNumber, subscription);
            cards.put(cardNumber, bankCard);
        }
    }

    //Тіло методу отримання запису за ключем з інтерфейсу Service
    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber) {
        //Отримання запису про картку в банку за її номером
        Subscription subscription = subscriptions.get(bankCardNumber);
        //Якщо запис існує, то повертаємо контейнер з записом,
        //якщо ні, то повертаємо порожній контейнер
        return Optional.ofNullable(subscription);
    }

    //Тіло методу для отримання списку користувачів банку
    @Override
    public List<User> getAllUsers() {
        //Список користувачів карток (без повторень) перетворюється на потік для обробки, і з цього потоку оброблені дані збираються у список знов
        return cards.values().stream().map(BankCard::getUser).distinct().collect(Collectors.toUnmodifiableList());
    }
}
