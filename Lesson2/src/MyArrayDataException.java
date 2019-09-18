public class MyArrayDataException extends Exception {

    public MyArrayDataException(int i, int j){

        System.out.println("Ошибка в ячейке: " + i + "X" + j);
    }
}
