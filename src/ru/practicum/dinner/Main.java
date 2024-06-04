package ru.practicum.dinner;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static HashMap <String, ArrayList<String>> allDishes = new HashMap<>();

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        if(allDishes.containsKey(dishType)){
            allDishes.get(dishType).add(dishName);
        } else {
            ArrayList<String> newDishList = new ArrayList<>();
            newDishList.add(dishName);
            allDishes.put(dishType, newDishList);
        }
        // добавьте новое блюдо
        System.out.println("Успешно!");
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        //реализуйте ввод типов блюд
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = new ArrayList<>();
            while (!nextItem.isEmpty()) {
                if (allDishes.containsKey(nextItem)) {
                    combo.add(dc.generate(allDishes.get(nextItem)));
                } else {
                    System.out.println("Такой категории блюд нет.");
                }
                    nextItem = scanner.nextLine();
                }
            System.out.println("Комбо номер" + (i+1) + ":");
            System.out.println(combo);
            }
        }
        // сгенерируйте комбинации блюд и выведите на экран

    }
