package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

public class DeliveryCostTest {

    @Test
    void standartCost() {
        StandardParcel standart = new StandardParcel("Дерево", 5 , "Казань", 2);
        Assertions.assertEquals(10, standart.calculateDeliveryCost());
    }

    @Test
    void fragileCost() {
        FragileParcel fragile = new FragileParcel("Стекло", 5, "Елабуга", 5);
        Assertions.assertEquals(20, fragile.calculateDeliveryCost());
    }

    @Test
    void perishableCost() {
        PerishableParcel perishavle = new PerishableParcel("Еда", 2, "Альметьевск", 4 , 3);
        Assertions.assertEquals(6, perishavle.calculateDeliveryCost());
    }
}
