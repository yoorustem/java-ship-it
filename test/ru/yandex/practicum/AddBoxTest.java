package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.Parcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

public class AddBoxTest {
    @Test
    void underLimit() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(10);
        StandardParcel parcel1 = new StandardParcel("Железо", 3, "Омск", 2);
        box.addParcel(parcel1);
        Assertions.assertEquals(1, box.getAllParcels().size());
    }

    @Test
    void boundary() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(2);
        StandardParcel parcel1 = new StandardParcel("Пластик", 2, "Казань", 2);
        box.addParcel(parcel1);
        Assertions.assertEquals(1, box.getAllParcels().size());
    }

    @Test
    void overLimit() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(4);

        StandardParcel parcel1 = new StandardParcel("Железо", 3, "Омск", 2);
        StandardParcel parcel2 = new StandardParcel("Вата", 2, "Омск", 2);

        box.addParcel(parcel1);
        box.addParcel(parcel2);

        Assertions.assertEquals(1, box.getAllParcels().size());
    }
}
