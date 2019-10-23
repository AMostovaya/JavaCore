import Annotations.AfterSuite;
import Annotations.BeforeSuite;
import Annotations.MyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/*
    Создать класс, который может выполнять «тесты».
    В качестве тестов выступают классы с наборами методов, снабженных аннотациями @Test.
    Класс, запускающий тесты, должен иметь статический метод start(Class testClass),
    которому в качестве аргумента передается объект типа Class.
    Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite, если он присутствует.
    Далее запускаются методы с аннотациями @Test, а по завершении всех тестов – метод с аннотацией @AfterSuite.
    К каждому тесту необходимо добавить приоритеты (int-числа от 1 до 10),
    в соответствии с которыми будет выбираться порядок их выполнения.
    Если приоритет одинаковый, то порядок не имеет значения.
    Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре. Если это не так – необходимо бросить RuntimeException при запуске «тестирования».
    P.S. Это практическое задание – проект, который пишется «с нуля». Данная задача не связана напрямую с темой тестирования через JUnit
*/

public class Main {

    public static void main(String[] args)  {

        try {
            startTest();
        } catch (InvocationTargetException e) {
            e.printStackTrace();

        } catch (IllegalAccessException e) {
            e.printStackTrace();

        } catch (InstantiationException e) {
            e.printStackTrace();

        }
    }

    private static void startTest() throws IllegalAccessException, InstantiationException, InvocationTargetException {

        Class myTest1Class = MyTest1.class;
        MyTest1 mytest1 = (MyTest1) myTest1Class.newInstance();
        Method beforeSuiteMethod = null;
        Method afterSuiteMethod = null;

        boolean isBeforeSuiteMeetsOnce = true;
        boolean isAfterSuiteMeetsOnce = true;

        Method[] methods = MyTest1.class.getDeclaredMethods();
        Method[] onlyTestMethods = new Method[methods.length - 2];
        int count = 0;
        for (Method k : methods) {
            if(k.getAnnotation(BeforeSuite.class) != null) {
                if (isBeforeSuiteMeetsOnce){
                    beforeSuiteMethod = k;
                    isBeforeSuiteMeetsOnce = false;
                } else {
                    throw new RuntimeException("Метод с анотацией @BeforeSuite должен быть только один!");
                }
            }
            if(k.getAnnotation(MyTest.class) != null) {
                onlyTestMethods[count] = k;
                count ++;
            }
            if(k.getAnnotation(AfterSuite.class) != null) {
                if (isAfterSuiteMeetsOnce){
                    afterSuiteMethod = k;
                    isAfterSuiteMeetsOnce = false;
                } else {
                    throw new RuntimeException("Метод с анотацией @AfterSuite должен быть только один!");
                }

            }
        }

        beforeSuiteMethod.invoke(mytest1);
        onlyTestMethods = mySortingArr(onlyTestMethods);
        for (int i = 0; i < onlyTestMethods.length; i++) {
            onlyTestMethods[i].invoke(mytest1);
        }
        afterSuiteMethod.invoke(mytest1);


    }

    private static Method[] mySortingArr(Method[] onlyTestMethods) {

        Method[] sortedArray = new Method[onlyTestMethods.length];
        ArrayList<Method> list = new ArrayList<Method>();

        for (Method method : onlyTestMethods){
            list.add(method);
        }
        int j = 0;
        while (list.size() > 0) {
            int max = list.get(0).getAnnotation(MyTest.class).priority();
            int index = 0;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).getAnnotation(MyTest.class).priority() > max){
                    max = list.get(i).getAnnotation(MyTest.class).priority();
                    index = i;
                }
            }
            sortedArray[j] = list.remove(index);
            j++;
        }
        return sortedArray;
    }



}
