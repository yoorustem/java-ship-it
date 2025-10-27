package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 0:
                    System.out.println("Выход из программы");
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("0 — Завершить");
        System.out.println();
    }

    // реализуйте методы ниже

    private static void addParcel() {
        System.out.println("Введите тип посылки: 1 стандартная, 2 хрупкая, 3 скоропортящаяся");
        int type = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите описание:");
        String description = scanner.nextLine();

        System.out.println("Введите вес:");
        int weight = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите адрес доставки:");
        String address = scanner.nextLine();

        System.out.println("Введите день отправки:");
        int sendDay = Integer.parseInt(scanner.nextLine());

        Parcel parcel = null;

        if (type == 1) {
            parcel = new StandardParcel(description, weight, address, sendDay);
        } else if (type == 2) {
            parcel = new FragileParcel(description, weight, address, sendDay);
        } else if (type == 3) {
            System.out.println("Введите срок хранения:");
            int timeToLive = Integer.parseInt(scanner.nextLine());
            parcel = new PerishableParcel(description, weight, address, sendDay, timeToLive);
        } else {
            System.out.println("Неверыный тип посылки");
            System.out.println();
            return;
        }

        allParcels.add(parcel);
        System.out.println("Посылка добавлена");
        System.out.println();
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
            System.out.println("Посылки отправлены");
        }
        // Пройти по allParcels, вызвать packageItem() и deliver()
    }

    private static void calculateCosts() {
        int total = 0;
        for (Parcel parcel : allParcels) {
            total += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость:" + total);
        // Посчитать общую стоимость всех доставок и вывести на экран
    }

}

