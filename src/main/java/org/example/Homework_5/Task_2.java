package Homeworks.Homework_5;


import java.util.*;


/**
 *  Пусть дан список сотрудников:
 * Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
 * Отсортировать по убыванию популярности.
 *
 * Иван Иванов
 * Светлана Петрова
 * Кристина Белова
 * Анна Мусина
 * Анна Крутова
 * Иван Юрин
 * Петр Лыков
 * Павел Чернов
 * Петр Чернышов
 * Мария Федорова
 * Марина Светлова
 * Мария Савина
 * Мария Рыкова
 * Марина Лугова
 * Анна Владимирова
 * Иван Мечников
 * Петр Петин
 * Иван Ежов
 */
public class Task_2 {
    public static void main(String[] args) {
        List<String> listOfEmployees = new ArrayList<>();

        addEmployeeNames(listOfEmployees, new String[] {
                "Алёна", "Алёна", "Алёна", "Алёна",
                "Иван", "Иван", "Иван", "Светлана",
                "Пётр", "Пётр", "Кристина", "Анна",
                "Антон", "Анна", "Павел", "Мария",
                "Мария", "Мария","Марина","Марина"
        });

        System.out.println(howManyNames(listOfEmployees));



    }
    static TreeMap<String, Integer> howManyNames(List<String> names) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String name : names) {
            if (result.containsKey(name)) {
                result.replace(name, result.get(name) + 1);
            } else {
                result.put(name, 1);
            }
        }
        TreeMap<String, Integer> sorted = new TreeMap<>(result);
        result.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(entry -> sorted.put(entry.getKey(), entry.getValue()));
        return sorted;
    }



    static void addEmployeeNames(List<String> listOfEmployees, String[] newEmployeeNames) {
        Collections.addAll(listOfEmployees, newEmployeeNames);
    }





}
