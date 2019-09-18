import java.io.IOException;

public class Main {

    public static void main(String [] args)
    {
        /*
        1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
        при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
        2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
        Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
        должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.
        3. В методе main() вызвать полученный метод,
        обработать возможные исключения MySizeArrayException и MyArrayDataException и вывести результат расчета.
       */

        String[][] array = new String[][]{{"1","2","3","4"},{"4","5","3","1"},{"6","6","3","5"},{"7","5","4","j"}};

        try {
            int result = get_sum(array);
            System.out.println(result);
        }
        catch (MySizeArrayException e) {
            System.out.println(e.getMessage());
        }
        catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }



    public static int get_sum(String[][]array)  throws MySizeArrayException, MyArrayDataException {

        int sum = 0;
        if (array.length != 4) {
            throw new MySizeArrayException();
        }
        for (int i = 0; i<array.length; i++) {
            if (array[i].length != 4) {
                throw new MySizeArrayException();
            }
            for (int j = 0; j<array[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return sum;

    }


}
