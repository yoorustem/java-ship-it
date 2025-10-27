package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends  Parcel> {
    int maxWeight;
    ArrayList<T> parcels = new ArrayList<>();
    int currentWeight = 0;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        if (currentWeight + parcel.weight > maxWeight) {
            System.out.println("Превышен максимальный вес  Посылка не добавлена");
        } else {
            parcels.add(parcel);
            currentWeight += parcel.weight;
            System.out.println("Посылка добавлена в коробку");
        }
    }

    public ArrayList<T> getAllParcels() {
        return parcels;
    }

    public void printContens() {
        System.out.println("Содержимое коробки: ");
        for (T p : parcels) {
            System.out.println(p.description + ". Вес: " + p.weight + "кг");
        }
    }
}
