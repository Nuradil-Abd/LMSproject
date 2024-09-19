package lms.commands;

public class Show {

    public void show() {
        System.out.println("""
                ~~~~~WELCOME~~~~~
                select command
                1 -> Вход
                2 -> Регистрация
                0 -> Выйти""");
    }


    public void showForAdmin() {
        System.out.println("~~~~~ КОМАНДЫ АДМИНИСТРАТОРА ~~~~~");
        System.out.println("1 -> Добавить новую группу");
        System.out.println("2 -> Добавить нового студента в группу");
        System.out.println("3 -> Добавить нового инструктора в группу");
        System.out.println("4 -> Получить все группы");
        System.out.println("5 -> Получить группу по имени");
        System.out.println("6 -> Получить студента по email");
        System.out.println("7 -> Получить всех студентов по имени группы");
        System.out.println("8 -> Получить все уроки студента");
        System.out.println("9 -> Получить все уроки по имени группы");
        System.out.println("10 -> Получить инструктора по email");
        System.out.println("11 -> Получить всех студентов инструктора");
        System.out.println("12 -> Получить всех инструкторов по имени группы");
        System.out.println("13 -> Обновить студента по email");
        System.out.println("14 -> Обновить инструктора по email");
        System.out.println("15 -> Обновить группу по имени");
        System.out.println("16 -> Удалить группу по имени");
        System.out.println("17 -> Удалить студента по email");
        System.out.println("0 -> Выйти");
        System.out.println();
    }

    public void showForInstructor() {
        System.out.println("~~~~~ КОМАНДЫ ИНСТРУКТОРА ~~~~~");
        System.out.println("1 -> Добавить новый урок в группу");
        System.out.println("2 -> Получить группу по имени");
        System.out.println("3 -> Получить урок по имени");
        System.out.println("4 -> Получить студента по email");
        System.out.println("5 -> Получить всех студентов по имени группы");
        System.out.println("6 -> Получить урок по id");
        System.out.println("7 -> Получить все уроки по имени группы");
        System.out.println("8 -> Получить всех студентов инструктора");
        System.out.println("9 -> Удалить урок по имени");
        System.out.println("0 -> Выйти");
        System.out.println();
    }


}
