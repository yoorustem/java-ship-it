package ru.yandex.practicum.delivery;

public abstract class Parcel {
    String description;
    int weight;
    String deliveryAddress;
    int sendDay;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> упакована");
    }

    public void deliver() {
        System.out.println("Посылка <<" + description + ">> доставлена");
    }

    public abstract int calculateDeliveryCost();

}
