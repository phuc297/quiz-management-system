package UTILS;

import java.util.Random;

public class Number {

    public static int getEven(int n) {
        Random random = new Random();
        int evenNumber = random.nextInt((n + 2) / 2) * 2;
        return evenNumber;
    }

}
