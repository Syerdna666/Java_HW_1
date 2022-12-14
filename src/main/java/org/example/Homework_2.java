package Homeworks;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Logger;
import org.json.simple.JSONValue;
import org.json.simple.JSONObject;


public class Homework_2 {

    private static Logger logger = Logger.getLogger(Homework_2.class.getName());
    public static void main(String[] args) {
        String str1 = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        int arr[] = {4, 8 , 15, 16, 23, 42, 2, 9, 12};
        String str2 = "{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}, {\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}, {\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}";
        String[] json = str2.split(", ");

        //System.out.println(getRequest(str));
        //bubbleLogger(arr);
        parseJson(json);
    }
    /**
     * Дана строка sql-запроса "select * from students where ".
     * Сформируйте часть WHERE этого запроса, используя StringBuilder.
     * Данные для фильтрации приведены ниже в виде json строки.
     * Если значение null, то параметр не должен попадать в запрос.
     *
     * Параметры для фильтрации:
     * {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
     */
    private static String getRequest(String request) {
        request = request.substring(1, request.length() - 1);
        System.out.println(request);

        String[] attributes = request.split(", ");

        StringBuilder SQLreq = new StringBuilder("SELECT * FROM students WHERE");

        for (int i = 0; i < attributes.length; i++) {
            String[] pair = attributes[i].split(":");
            String value = pair[1];

            if (!value.equals("\"null\"")) {
                String key = pair[0].substring(1, pair[0].length() - 1);

                if (i != 0) {
                    SQLreq.append(" AND");
                }
                SQLreq.append(" ").append(key).append(" = ").append(value);
            }

        }
        return SQLreq.toString();
    }

    /**
     * Реализуйте алгоритм сортировки пузырьком числового массива,
     * результат после каждой итерации запишите в лог-файл.
     */

    public static void bubbleLogger(int[] arr) {
        try (PrintWriter out = new PrintWriter("bubbleLog.txt")) {
            int n = arr.length;
            int temp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n-i; j++) {
                    if (arr[j-1] > arr[j]){
                        temp = arr[j-1];
                        arr[j-1] = arr[j];
                        arr[j] = temp;
                    }
                }
                out.println(Arrays.toString(arr));
            }

            logger.info("Логирование алгоритма пузырьковой сортировки записано в файл bubbleLog.txt");
        } catch (FileNotFoundException e) {
            logger.info(e.getMessage());
        }

    }
    /**
     * Дана json строка (можно сохранить в файл и читать из файла)
     * (Коллеги, если сложно будет распарсить .json -> можно работать как со строкой обычной)
     *
     * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
     *
     * Написать метод(ы), который распарсит json и, используя StringBuilder,
     * создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
     *
     * Пример вывода:
     *
     * Студент Иванов получил 5 по предмету Математика.
     *
     * Студент Петрова получил 4 по предмету Информатика.
     *
     * Студент Краснов получил 5 по предмету Физика.
     */
    public static void parseJson(String[] json) {
        for (int i = 0; i < json.length; i++) {
            Object obj = JSONValue.parse(json[i]);
            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("фамилия");
            String grade = (String) jsonObject.get("оценка");
            String subject = (String) jsonObject.get("предмет");

            System.out.printf("Студент %s получил %s по предмету %s\n", name, grade, subject);
        }

    }
    /**
     *  К калькулятору из предыдущего дз добавить логирование.
     */



}
