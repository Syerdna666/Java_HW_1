package Homeworks.Homework_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private static HashMap<String, ArrayList<String>> phonebook = new HashMap<>();

    public void add(String name, String number) {
        if (phonebook.containsKey(name)) {
            phonebook.get(name).add(number);
        } else {
            ArrayList<String> values = new ArrayList<>();
            values.add(number);
            phonebook.put(name, values);
        }
    }

    public static ArrayList<String> find(String number) {
        ArrayList<String> res = phonebook.get(number);
        return res;
    }

    public void del(String name, String number) {
        if (phonebook.containsKey(name)) {
            phonebook.get(name).remove(number);
        }

    }

    public static void printPhonebook() {
        System.out.println("Телефонный справочник: ");
        for (Map.Entry<String, ArrayList<String>> k : phonebook.entrySet()) {
            System.out.println(k.getValue() + ": " + k.getKey());
        }
    }
}

