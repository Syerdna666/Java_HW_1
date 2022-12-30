package Homeworks.Homework_6;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * 1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
 *  2. Создать множество ноутбуков.
 *  3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
 *  отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
 *  “Введите цифру, соответствующую необходимому критерию:
 *  1 - ОЗУ
 *  2 - Объем ЖД
 *  3 - Операционная система
 *  4 - Цвет …
 *   1. Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
 *   2. Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */
public class Main {
    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();

        notebooks.add(new Notebook("Xiaomi Notebook pro", 256, "Windows 11", "Black"));

        notebooks.add(new Notebook("MSI Prestige", 128, "Windows 7", "White"));

        notebooks.add(new Notebook("Acer Travelmate", 256, "Windows 11", "Black"));

        notebooks.add(new Notebook("HP 250", 512, "Linux OS", "Black"));

        notebooks.add(new Notebook("Asus ZenBook Flip", 256, "Linux OS", "White"));

     System.out.println(" - First Filter - ");
    Map<Object, Set<Notebook>> filteredNotebooks = Notebook.filterByProperty(notebooks);
    print(filteredNotebooks);

    System.out.println(" - Second Filter - ");
    Map<Object, Set<Notebook>> filteredNotebooks2 = Notebook.filterByMinValue(notebooks);
    print(filteredNotebooks2);
}
    private static void print(Map<Object, Set<Notebook>> map) {
        for (Map.Entry<Object, Set<Notebook>> entry : map.entrySet()) {
            System.out.println(entry);
            System.out.println();
        }
    }
}
