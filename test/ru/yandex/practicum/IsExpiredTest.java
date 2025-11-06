package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

public class IsExpiredTest {

    @Test
    void notExpired() {
        PerishableParcel parcel = new PerishableParcel("Мясо", 5, "Казань", 3, 3);
        Assertions.assertFalse(parcel.isExpired(5));
    }

    @Test
    void expired() {
        PerishableParcel parcel = new PerishableParcel("Мясо", 5, "Казань", 3, 3);
        Assertions.assertTrue(parcel.isExpired(7));
    }

    @Test
    void almostExpired() {
        PerishableParcel parcel = new PerishableParcel("Мясо", 5, "Казань", 3, 3);
        Assertions.assertFalse(parcel.isExpired(6));
    }
}
