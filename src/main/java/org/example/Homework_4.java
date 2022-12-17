package Homeworks;

import java.util.LinkedList;
import java.util.Scanner;

public class Homework_4 {
    public static void main(String[] args) {
        LinkedList<String> linkedli = new LinkedList<>();
        linkedli.add("Java");
        linkedli.add("Make");
        linkedli.add("Me");
        linkedli.add("Mad");

        System.out.print("Elements before reversing: " + linkedli);
        linkedli = reverseLinkedList(linkedli);
        System.out.print("\nElements after reversing: " + linkedli);


//        enqueue(linkedli, "Mostly");
//        System.out.println(linkedli);
//
//        System.out.println(dequeue(linkedli));
//        System.out.println(linkedli);
//
//        System.out.println(first(linkedli));
//        System.out.println(linkedli);
//
//        LinkedList<Integer> operations = new LinkedList<>();
//
//        System.out.println("calculator");
//        calculate(operations);


    }
    /**
     * Пусть дан LinkedList с несколькими элементами.
     * Реализуйте метод, который вернет “перевернутый” список.
     */
    private static LinkedList<String> reverseLinkedList(LinkedList<String> llist){
        LinkedList<String> revLinkedList = new LinkedList<>();
        for (int i = llist.size() - 1; i >= 0 ; i--) {
            revLinkedList.add(llist.get(i));
        }
        return revLinkedList;
    }

    /**
     * Реализуйте очередь с помощью LinkedList со следующими методами:
     * enqueue() - помещает элемент в конец очереди,
     * dequeue() - возвращает первый элемент из очереди и удаляет его,
     * first() - возвращает первый элемент из очереди, не удаляя.
     */

    private static void enqueue(LinkedList<String> list, String str){
        list.addLast(str);
    }

    private static String dequeue(LinkedList<String> list){
        String s = null;
        s = list.get(0);
        list.remove(0);
        return s;
    }

    private static String first(LinkedList<String> list) {
        String s = null;
        s = list.get(0);
        return s;
    }

    /**
     * В калькулятор добавьте возможность отменить последнюю операцию.
     */

    private static void calculate(LinkedList<Integer> operations) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter first value: ");
        int firstValue = in.nextInt();
        System.out.print("Enter second value: ");
        int secondValue = in.nextInt();
        System.out.print("Enter operation: ");
        String operator = in.next();

        in.close();

        StringBuilder result = new StringBuilder();
        int answer = 0;
        switch (operator) {
            case "/" -> {
                if (secondValue != 0) {
                    answer = firstValue / secondValue;
                    result.append(firstValue).append(operator).append(secondValue).append("=").append(answer);
                } else {
                    result.append("Can not divide by zero");
                }
            }
            case "*" -> {
                answer = firstValue * secondValue;
                result.append(firstValue).append(operator).append(secondValue).append("=").append(answer);
            }
            case "-" -> {
                answer = firstValue - secondValue;
                result.append(firstValue).append(operator).append(secondValue).append("=").append(answer);
            }
            case "+" -> {
                answer = firstValue + secondValue;
                result.append(firstValue).append(operator).append(secondValue).append("=").append(answer);
            }
            case "undo" -> {
                operations.removeLast();
            }
            default -> result.append("can not count");
        }
        operations.add(answer);
        System.out.printf("%d %s %d = %d", firstValue, operator, secondValue, answer);
    }
}
