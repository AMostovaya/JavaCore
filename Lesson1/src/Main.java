package Task1_1;

public class Main {
    public static void main(String[] args)
    {
       /* 1. Разобраться с имеющимся кодом;
        2. Добавить класс Team, который будет содержать название команды,
        массив из четырех участников (в конструкторе можно сразу указыватьвсех участников ),
        метод для вывода информации о членах команды, прошедших дистанцию, метод вывода информации обо всех членах команды.
        3. Добавить класс Course (полоса препятствий), в котором будут находиться массив препятствий и метод,
         который будет просить команду пройти всю полосу; */

        Participants[] participants = {new Human("John"), new Human("Jack"), new Human("Robert"), new Human("Stiven")};
        Obstacle[] obstacles = {new Run(1000), new Bicycle(2500), new Swimming(750)};

        Team team = new Team("Bulls", participants);

        System.out.println("-------New team:---------");
        System.out.println(team.getName());

        System.out.println("-------Members:----------");
        team.showResults();

        Course course = new Course(obstacles);

        System.out.println("-------Team takes the course----------");
        course.doIt(team);

        System.out.println("-------Results-------");
        team.showResults();


    }

    }

