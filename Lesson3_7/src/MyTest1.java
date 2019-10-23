import Annotations.AfterSuite;
import Annotations.BeforeSuite;
import Annotations.MyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTest1 {

    @BeforeSuite
    public void firstOfAll(){
        System.out.println("Отработал метод с аннотацией @BeforeSuite");
    }

    @AfterSuite
    public void afterAll(){
        System.out.println("Отработал метод с аннотацией @AfterSuite");
        System.out.println("Тестирование завершено!");
    }
    /**
     * Метод тестирует метод "plus", который складывает 2 числа
     */
    @MyTest(priority = 2)
    public void myTest1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        TestClass example = new TestClass();
        Class exampleClass = example.getClass();
        Class[] paramTypes = new Class[] { int.class, int.class };
        Method method = exampleClass.getDeclaredMethod("plus", paramTypes);
        System.out.println("Тестирование метода : \"" + method.getName() + "\"");
        int a;
        int b;
        float result;
        for (int i = 0; i < 10; i++) {
            a = (int) Math.random() * 100;
            b = (int) Math.random() * 100;
            result = a + b;
            float d = (Float) method.invoke(example, a, b);
            if (Math.abs(d - result) < 0.000000001){

                System.out.println("MyTest1 passed!");
            } else {

                System.err.println("MyTest1 failed!");
            }
        }
    }


}
