import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String args[]) {

        // задание 1: переставить элементы в массиве
        rearrangeElements();
        // задание 2: преобразование массива в ArrayList
        convertingArrayToArrayList();
        // задание 3: задача про яблоки и апельсины




    }

    public static void rearrangeElements() {

        Integer[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Double[] array2 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};

       try {
            rearrangeTwoElements(array1, 3, 4);
            rearrangeTwoElements(array2, 3, 4);
                 } catch (WrongPosition e) {
            e.printStackTrace();
        }
        System.out.println("Результат перестановки целочисленного массива: " + Arrays.toString(array1));
        System.out.println("Результат перестановки массива с плавающей точкой: " + Arrays.toString(array2));
    }

    private static void rearrangeTwoElements(Object[] array, int firstPosition, int secondPosition) throws WrongPosition {
        if (firstPosition < 0 || firstPosition > array.length ||
                secondPosition < 0 || secondPosition > array.length || firstPosition == secondPosition) {
            throw new WrongPosition("Не верно указаны номера элементов для перестановки");
        }

        Object elementForChange = array[firstPosition];
        array[firstPosition] = array[secondPosition];
        array[secondPosition] = elementForChange;
    }

    public static void convertingArrayToArrayList() {

        Integer[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Double[] array2 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};

        arrayToArrayList(array1);
        arrayToArrayList(array2);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));

    }

    private static <a> ArrayList arrayToArrayList(a[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
