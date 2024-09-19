package lms.commands;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    private String lastValidatedInput;


    public String valInput(Scanner scanner, String prompt, ValidatorFI validator) {
        int attempts = 0;
        String input;
        while (attempts < 3) {
            System.out.print(prompt);
            input = scanner.nextLine().trim().replace(" ","");

            if (validator.validate(input)) {
                lastValidatedInput = input;
                return input;
            } else {
                attempts++;
                System.out.println("Неверный ввод. Попытка " + attempts + " из 3.");
            }
        }
        System.out.println("Достигнуто максимальное количество попыток. Выход.");
        return null;
    }


    public boolean validateName(String name) {
        if (name.length() < 3) {
            System.out.println("Имя должно содержать минимум 3 символа.");
            return false;
        }
        if (!Character.isUpperCase(name.charAt(0))) {
            System.out.println("Имя должно начинаться с заглавной буквы.");
            return false;
        }
        return true;
    }

    public boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (!Pattern.matches(emailRegex, email)) {
            System.out.println("Неправильный формат email. Допустимый формат: user@example.com");
            return false;
        }
        return true;
    }


    public boolean validatePassword(String password) {
        if (password.length() < 8) {
            System.out.println("Пароль должен содержать минимум 8 символов.");
            return false;
        }
        if (!containsUpperCase(password)) {
            System.out.println("Пароль должен содержать минимум одну заглавную букву.");
            return false;
        }
        if (!containsDigit(password)) {
            System.out.println("Пароль должен содержать минимум одну цифру.");
            return false;
        }
        if (!containsSpecialCharacter(password)) {
            System.out.println("Пароль должен содержать минимум один специальный символ.");
            return false;
        }
        return true;
    }


    public boolean validateUserType(String userType) {
        if (userType == null || !(userType.equalsIgnoreCase("admin")
                || userType.equalsIgnoreCase("instructor")
                || userType.equalsIgnoreCase("student"))) {
            System.out.println("Недопустимый тип пользователя. Введите: admin, instructor или student.");
            return false;
        }
        return true;
    }


    private boolean containsUpperCase(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }


    private boolean containsDigit(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }


    private boolean containsSpecialCharacter(String str) {
        String specialChars = "!@#$%^&*()-+";
        for (char c : str.toCharArray()) {
            if (specialChars.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }


    public String getLastValidatedInput() {
        return lastValidatedInput;
    }


    @FunctionalInterface
    public interface ValidatorFI {
        boolean validate(String input);
    }
}
