package Homeworks.Homework_6;

import java.util.*;
import java.util.stream.Collectors;

public class Notebook {
    private String name;
    private int hardDrive;
    private String operatingSystem;
    private String color;

    public Notebook(String name,int hardDrive, String operatingSystem, String color) {
        this.name = name;
        this.hardDrive = hardDrive;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }
    public String getName() {
        return this.name;
    }
    public int getHardDrive() {
        return this.hardDrive;
    }
    public String getOperatingSystem() {
        return this.operatingSystem;
    }

    public String getColor(){
        return this.color;
    }

    @Override
    public String toString() {
        return "NOTEBOOK NAME:" + this.name + ", HARDDRIVE:" + this.hardDrive + ", OS:" + this.operatingSystem + ", COLOR:" + this.color;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.name == null) ? 0 : name.hashCode());
        result = prime * result + this.hardDrive;
        result = prime * result + ((this.operatingSystem == null) ? 0 : this.operatingSystem.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Notebook other = (Notebook) obj;
        if (this.name == null) {
            if (other.name != null)
                return false;
        } else if (!this.name.equals(other.name))
            return false;
        if (this.hardDrive != other.hardDrive)
            return false;
        if (this.operatingSystem == null) {
            if (other.operatingSystem != null)
                return false;
        } else if (!this.operatingSystem.equals(other.operatingSystem))
            return false;
        return true;
    }

    public static Map<Object, Set<Notebook>> filterByProperty(Set<Notebook> notebooks) {
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - объём жёсткого диска");
        System.out.println("2 - операционная система");
        System.out.println("3 - цвет");

        String code = sc.nextLine();
        System.out.println();

        Map<Object, Set<Notebook>> result = new TreeMap<>();

        if (code.equals("1")) {
            for (Notebook notebook : notebooks) {
                if (result.containsKey(notebook.hardDrive)) {
                    result.get(notebook.hardDrive).add(notebook);
                } else {
                    Object key = (Object) notebook.hardDrive;
                    result.put(key, new HashSet<Notebook>());
                    result.get(notebook.hardDrive).add(notebook);
                }
            }
        } else if (code.equals("2")) {
            for (Notebook notebook : notebooks) {
                if (result.containsKey(notebook.operatingSystem)) {
                    result.get(notebook.operatingSystem).add(notebook);
                } else {
                    Object key = (Object) notebook.operatingSystem;
                    result.put(key, new HashSet<Notebook>());
                    result.get(notebook.operatingSystem).add(notebook);
                }
            }
        } else if (code.equals("3")) {
            for (Notebook notebook : notebooks) {
                if (result.containsKey(notebook.color)) {
                    result.get(notebook.color).add(notebook);
                } else {
                    Object key = (Object) notebook.color;
                    result.put(key, new HashSet<Notebook>());
                    result.get(notebook.color).add(notebook);
                }
            }
        } else {
            System.out.println("Ошибка ввода!");
        }

        return result;
    }

    public static Map<Object, Set<Notebook>> filterByMinValue(Set<Notebook> notebooks) {
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - объём жёсткого диска");

        String code = sc.nextLine();
        System.out.println();

        Map<Object, Set<Notebook>> result = new TreeMap<>();

        if (code.equals("1")) {
            for (Notebook notebook : notebooks) {
                if (result.containsKey(notebook.hardDrive)) {
                    result.get(notebook.hardDrive).add(notebook);
                } else {
                    Object key = (Object) notebook.hardDrive;
                    result.put(key, new HashSet<Notebook>());
                    result.get(notebook.hardDrive).add(notebook);
                }
            }
        } else {
            System.out.println("Ошибка ввода!");
            return result;
        }
        return result;
    }

    private static Map<Object, Set<Notebook>> getMinValueFloat(Map<Object, Set<Notebook>> result) {
        System.out.println("Введите минимальное значение (дробная часть при наличии должна быть отделена запятой):");

        final Float minValue;
        try {
            minValue = sc.nextFloat();
            System.out.println();
        } catch (InputMismatchException ime) {
            System.out.println();
            System.out.println("Ошибка ввода!");
            return result;
        }

        result = result.entrySet().stream()
                .filter(map -> (Float) map.getKey() >= minValue)
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

        return result;
    }

    private static Map<Object, Set<Notebook>> getMinValueInteger(Map<Object, Set<Notebook>> result) {
        System.out.println("Введите минимальное значение (целое число):");

        final Integer minValue;
        try {
            minValue = sc.nextInt();
            System.out.println();
        } catch (InputMismatchException ime) {
            System.out.println();
            System.out.println("Ошибка ввода!");
            return result;
        }

        result = result.entrySet().stream()
                .filter(map -> (Integer) map.getKey() >= minValue)
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

        return result;
    }



    private static Scanner sc = new Scanner(System.in);
}
