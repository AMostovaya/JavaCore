import java.util.HashMap;

public class Lesson3 {

    /*
    1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
    Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    Посчитать, сколько раз встречается каждое слово.
     */

    public static void main(String[] args) {

        String[] wordsList = {
                "apple",
                "avocado",
                "apricot",
                "banana",
                "fig",
                "grapefruit",
                "mango",
                "apple",
                "melon",
                "nectarine",
                "orange",
                "papaya",
                "persimmon",
                "orange",
                "persimmon",
                "tangerine",
                "plum",
                "watermelon"};

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String word: wordsList) {

            Integer result = hashMap.get(word);
            hashMap.put(word, result == null ? 1 : result + 1);
        }

        System.out.println(hashMap);
        /*
    2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
    В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона
    по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
    тогда при запросе такой фамилии должны выводиться все телефоны
     */

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Сергеев", "+77051120011");
        phoneBook.add("Петренко", "+77775201212");
        phoneBook.add("Петренко ", "+77714520100");
        phoneBook.add("Альбатросов", "+77714520102");
        phoneBook.add("Степаненко", "+77714520132");

        phoneBook.info();

        String fio_search = "Петренко";

        System.out.println(" Номер телефона " + fio_search + ": " + phoneBook.get(fio_search));

    }

}
