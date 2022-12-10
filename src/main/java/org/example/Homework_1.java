package org.example;

import java.util.Scanner;

public class Homework_1 {
    public static void main(String[] args) {
        //printTriangleNumber();
        //printFactorial();
        //printPrimeNumbers();
        //calculate();
    }
/**
 * Вычислить n-ое треугольного числа (сумма чисел от 1 до n)
 */
    public static void printTriangleNumber() {
        System.out.println("Enter n: ");
        Scanner enterNumber = new Scanner(System.in);
        int number = enterNumber.nextInt();
        int trNumber = number * (number + 1)/2;
        System.out.printf("Triangle number of %d = %d", number, trNumber);
        }

    /**
     * Вычислить n! (произведение чисел от 1 до n)
     */
    public static void printFactorial() {
        System.out.println("Enter n: ");
        Scanner enterNumber = new Scanner(System.in);
        int number = enterNumber.nextInt();
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.printf("Factorial of %d = %d", number, factorial);
    }

    /**
     * Вывести все простые числа от 1 до 1000
     */
    public static void printPrimeNumbers() {
        for(int i = 2; i < 1000; ++i){
            int count = 0;
            for(int j = 2; j <= i && count < 2; ++j){
                if(i % j==0){
                    ++count;
                }
            }
            if(count<2)
                System.out.print(i + " ");
        }
    }

    /**
     * Реализовать простой калькулятор
     */
    private static void calculate() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first value: ");
        int firstValue = in.nextInt();
        System.out.print("Enter second value: ");
        int secondValue = in.nextInt();
        System.out.print("Enter operation: ");
        String operator = in.next();
        in.close();

        switch (operator) {
            case "/" -> {
                if (secondValue != 0) {
                    System.out.println(firstValue / secondValue);
                } else {
                    System.out.println("Сan not be divided by zero");
                }
            }
            case "*" -> System.out.println(firstValue * secondValue);
            case "-" -> System.out.println(firstValue - secondValue);
            case "+" -> System.out.println(firstValue + secondValue);
            default -> System.out.println("Enter valid operator");
        }
    }
}