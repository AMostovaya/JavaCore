

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        /*
        Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
        Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
        идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо
        выбросить RuntimeException.
        Написать набор тестов для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
         */

        int[] array1 = {1,2,3,4,5,2,3,0,3,0};
        int[] array2 = {1,4,0,0,0,0,0,0,0,1};
        int[] array3 = {8,4,3,7,5,2,5,3,3,1};
        int[] array4 = {1,4,4,1,4};

        int[] newArray1 = createNewArrayAfterFour(array1);
        int[] newArray2 = createNewArrayAfterFour(array2);
        int[] newArray3 = createNewArrayAfterFour(array3);

        System.out.println("Начальный массив: "+Arrays.toString(array1));
        System.out.println("Полученный массив: " + Arrays.toString(newArray1));
        System.out.println("Начальный массив: "+Arrays.toString(array2));
        System.out.println("Полученный массив: " + Arrays.toString(newArray2));
        System.out.println("Начальный массив: "+Arrays.toString(array3));
        System.out.println("Полученный массив: " + Arrays.toString(newArray3));


        /*
        Написать метод, который проверяет состав массива из чисел 1 и 4.
        Если в нем нет хоть одной четверки или единицы, то метод вернет false;
        Написать набор тестов для этого метода (по 3-4 варианта входных данных).
         */

        boolean result;
        result = checkArrayForNumber(array4);
        System.out.println("Проверка массива:" + result);

    }

    private static boolean checkArrayForNumber(int[] array) {

        Set<Integer> num = new HashSet<>(Arrays.asList(1,4));
        boolean res = true;
        for (int i: array) {
            res = num.contains(i);
            if (!res) {
                break;
            }
        }
        return res;

    }

    static int[] createNewArrayAfterFour(int[] array) {

        int number = 4;
        int postitionOfNumber;

        for (postitionOfNumber = array.length-1; postitionOfNumber>=0; postitionOfNumber--) {
            if (array[postitionOfNumber]== number)
                break;
        }

        if (postitionOfNumber == -1) {
            throw new RuntimeException("В массиве нет ни одной " + number);

        }
        int [] newArray = new int[array.length-postitionOfNumber-1];

        for (int i = array.length-1,  j = newArray.length-1; i > postitionOfNumber; i--, j--) {
            newArray[j] = array[i];
        }
        return newArray;
    }
}
