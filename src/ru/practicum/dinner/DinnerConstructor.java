package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    Random rndm = new Random();
    String generate(ArrayList<String> addDishes){
        int number = rndm.nextInt(addDishes.size());
        return addDishes.get(number);

    }

}
