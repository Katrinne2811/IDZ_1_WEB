package edu.nure.mjt.cloud.serv;

import edu.nure.mjt.serv.api.Service;
import edu.nure.mjt.BankCard;
import edu.nure.mjt.Subscription;
import edu.nure.mjt.User;
import java.time.LocalDateTime;
import java.util.HashMap;//Клас, об'єкти якого зберігають пари "значення-ключ"
import java.util.List;
import java.util.Map;//Клас, об'єкти якого зберігають певні значення
import java.util.Optional;
import java.util.stream.Collectors;//Клас, що визначає структури даних, у які збираються дані з потоку

//Створення класу, що реалізує інтерфейс Service
public class CloudService implements Service {
    //Незмінне сховище даних зі збереженими про банківські картки записами за ключем - номером картки
    private final Map<String, Subscription> subscriptions = new HashMap<>();
    //Незмінне сховище даних зі збереженими банківськими картками з ключем - номером картки
    private final Map<String, BankCard> cards = new HashMap<>();


    //Пропишемо тіло методу subscribe з інтерфейсу Service
    @Override
    public void subscribe(BankCard bankCard) {
        //Змінна номеру банк. картки
        String cardNumber = bankCard.getNumber();
        //Булева змінна - повертає істинність наявності запису про картку з вказаним номером
        var alreadySubscribed = subscriptions.keySet().stream().anyMatch(number -> number.equals(cardNumber));

        //Якщо запису ще нема, то він створюється та зберігається в БД записів та карток
        if (!alreadySubscribed) {
            var subscription = new Subscription(cardNumber, LocalDateTime.now());
            subscriptions.put(cardNumber, subscription);
            cards.put(cardNumber, bankCard);
        }
    }

    //Пропишемо тіло методу отримання запису getSubscriptionByBankCardNumber за ключем з інтерфейсу Service
    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber) {
        //Отримання запису про картку в банку за її номером
        Subscription subscription = subscriptions.get(bankCardNumber);
        //Якщо запис існує, то повертаємо контейнер з ним,
        //якщо ні, то повертаємо порожній контейнер
        return Optional.ofNullable(subscription);
    }

    //Пропишемо тіло методу для отримання списку користувачів банку
    @Override
    public List<User> getAllUsers() {
        //Список користувачів перетворюється на потік для обробки, і з цього потоку
        //оброблені дані збираються у список знов
        return cards.values().stream().map(BankCard::getUser).distinct().collect(Collectors.toUnmodifiableList());
    }
}
