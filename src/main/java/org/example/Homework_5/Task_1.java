package Homeworks.Homework_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
 * что 1 человек может иметь несколько телефонов.
 */


//Класс Phonebook реализует базу данных «Телефонный справочник»
//БД постоена на основе контейнера HashMap<String, String>
//класс включает в себя метод main который запускает работу с БД
//также включены методы
//add - добавляет запись по заданным фамилии и номеру телефона
//del - удаляет номер телефона по заданной фамилии
//printPhonebook - выводит на екран все записи БД
//find - производит поиск номеров телефона по фамилии

public class Task_1 {
    public static void main(String[] args) {
        Phonebook pb = new Phonebook();
        pb.add("Иванов", "8-812-432-32-12");
        pb.add("Матвеев", "8-812-532-12-10, 8-905-122-33-22");
        pb.add("Петров", "8-812-342-23-21");
        pb.add("Сидоров", "8-812-111-23-11, 8-910-232-22-21");
        pb.add("Сергеев", "8-812-412-31-62");

        System.out.println(pb.find("Матвеев"));

        pb.add("Иванов", "8-905-322-23-22");
        pb.printPhonebook();
        pb.add("Матвеев", "22232");
        pb.printPhonebook();

        pb.del("Матвеев", "22232");
        pb.printPhonebook();
    }
}
