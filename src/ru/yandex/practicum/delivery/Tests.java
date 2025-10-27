package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {
    @Test
    public void testDeliveryCost() {
        StandardParcel standart = new StandardParcel("Дерево", 4 , "Казань", 2);
        Assertions.assertEquals(10, standart.calculateDeliveryCost());

        FragileParcel fragile = new FragileParcel("Стекло", 5, "Елабуга", 5);
        Assertions.assertEquals(7, fragile.calculateDeliveryCost());

        PerishableParcel perishavle = new PerishableParcel("Еда", 2, "Альметьевск", 4 , 3);
        Assertions.assertEquals(6, perishavle.calculateDeliveryCost());
    }

    @Test
    public void testIsExpired() {
        PerishableParcel parcel = new PerishableParcel("Мясо", 5, "Казань", 3, 3);
        Assertions.assertFalse(parcel.isExpired(3));
        Assertions.assertTrue(parcel.isExpired(7));
    }

    @Test
    public void tesAddParceBox() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(7);
        StandardParcel parcel1 = new StandardParcel("Железо", 3, "Омск", 2);
        StandardParcel parcel2 = new StandardParcel("Вата", 2, "Омск", 2);

        box.addParcel(parcel1);
        box.addParcel(parcel2);
        Assertions.assertEquals(1, box.getAllParcels().size());
    }
}
