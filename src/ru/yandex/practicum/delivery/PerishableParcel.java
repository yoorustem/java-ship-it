package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private int timeToLive;
    private static final int PERISHABLE_COST = 3;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return currentDay > (sendDay + timeToLive);
    }

    @Override
    public int calculateDeliveryCost() {
        return weight * PERISHABLE_COST;
    }
}
