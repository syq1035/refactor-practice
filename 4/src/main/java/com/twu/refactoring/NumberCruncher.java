package com.twu.refactoring;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return judgeEvenOrOdd(0);
    }

    public int countOdd() {
        return judgeEvenOrOdd(1);
    }

    private int judgeEvenOrOdd(int i) {
        int count = 0;
        for (int number : numbers) {
            if (number % 2 == i) count++;
        }
        return count;
    }

    public int countPositive() {
        return judgePositiveOrNegative("positive");
    }

    public int countNegative() {
        return judgePositiveOrNegative("negative");
    }
    private int judgePositiveOrNegative(String str) {
        int countPositive = 0;
        int countNegative = 0;
        for (int number : numbers) {
            if (number < 0) {
                countNegative++;
            }else {
                countPositive++;
            }
        }
        if(str.equals("positive")){
            return countPositive;
        } else {
            return countNegative;
        }
    }
}
