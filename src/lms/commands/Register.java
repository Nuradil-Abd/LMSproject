package lms.commands;

import lms.models.Admin;
import lms.models.Instructor;
import lms.models.Student;
import lms.service.AdminService;
import lms.service.InstructorService;
import lms.service.StudentService;

import java.util.Scanner;

public class Register {

    private final AdminService adminService;
    private final InstructorService instructorService;
    private final StudentService studentService;
    private final Validator validator;

    public Register(AdminService adminService, InstructorService instructorService, StudentService studentService) {
        this.adminService = adminService;
        this.instructorService = instructorService;
        this.studentService = studentService;
        this.validator = new Validator();
    }

    public void execute(Scanner scanner) {

        String userType = validator.valInput(scanner, "Введите тип пользователя (admin/instructor/student): ", validator::validateUserType);
        if (userType == null) return;

        switch (userType.toLowerCase()) {
            case "admin":
                registerAdmin(scanner);
                break;
            case "instructor":
                registerInstructor(scanner);
                break;
            case "student":
                registerStudent(scanner);
                break;
            default:
                System.out.println("Неверный тип пользователя.");
                break;
        }
    }

    public Admin registerAdmin(Scanner scan) {

        String name = validator.valInput(scan, "Введите имя: ", validator::validateName);
        if (name == null) return null;

        String email = validator.valInput(scan, "Введите email: ", validator::validateEmail);
        if (email == null) return null;

        String password = validator.valInput(scan, "Введите пароль: ", validator::validatePassword);
        if (password == null) return null;

        String phoneNumber = validator.valInput(scan, "Введите номер телефона (+996): ", input -> input.length() == 13 && input.startsWith("+"));
        if (phoneNumber == null) return null;

        adminService.addAdmin(name, email, password, phoneNumber);
        System.out.println("Администратор зарегистрирован.");
        return adminService.getAdminByEmail(email);
    }

    public Instructor registerInstructor(Scanner scanner) {

        String name = validator.valInput(scanner, "Введите имя: ", validator::validateName);
        if (name == null) return null;

        String email = validator.valInput(scanner, "Введите email: ", validator::validateEmail);
        if (email == null) return null;

        String password = validator.valInput(scanner, "Введите пароль: ", validator::validatePassword);
        if (password == null) return null;

        String phoneNumber = validator.valInput(scanner, "Введите номер телефона (+996): ", input -> input.length() == 13 && input.startsWith("+"));
        if (phoneNumber == null) return null;

        instructorService.addInstructor(name, email, password, phoneNumber);
        System.out.println("Инструктор зарегистрирован.");
        return instructorService.getInstructorByEmail(email);
    }

    private void registerStudent(Scanner scanner) {

        if (isAuthenticatedInstructorOrAdmin(scanner)) {
            String name = validator.valInput(scanner, "Введите имя: ", validator::validateName);
            if (name == null) return;

            String email = validator.valInput(scanner, "Введите email: ", validator::validateEmail);
            if (email == null) return;

            String password = validator.valInput(scanner, "Введите пароль: ", validator::validatePassword);
            if (password == null) return;

            String phoneNumber = validator.valInput(scanner, "Введите номер телефона (+996): ", input -> input.length() == 13 && input.startsWith("+"));
            if (phoneNumber == null) return;

            studentService.addNewStudent(name, email, password, phoneNumber);
            System.out.println("Студент зарегистрирован.");
        } else {
            System.out.println("Вы должны войти как инструктор или администратор, чтобы зарегистрировать студента.");
        }
    }

    private boolean isAuthenticatedInstructorOrAdmin(Scanner scanner) {
        System.out.println("Для регистрации студента вам нужно войти как инструктор или администратор.");
        String email = validator.valInput(scanner, "Введите ваш email: ", validator::validateEmail);
        if (email == null) return false;

        String password = validator.valInput(scanner, "Введите ваш пароль: ", validator::validatePassword);
        if (password == null) return false;

        return isAdmin(email, password) || isInstructor(email, password);
    }

    private boolean isInstructor(String email, String password) {
        Instructor instructor = instructorService.getInstructorByEmail(email);
        return instructor != null && instructor.getPassword().equals(password);
    }

    private boolean isAdmin(String email, String password) {
        Admin admin = adminService.getAdminByEmail(email);
        return admin != null && admin.getPassword().equals(password);
    }

    public Student registerStudentWithoutCheck(Scanner scanner) {


        String name = validator.valInput(scanner, "Введите имя: ", validator::validateName);
        if (name == null) return null;

        String email = validator.valInput(scanner, "Введите email: ", validator::validateEmail);
        if (email == null) return null;

        String password = validator.valInput(scanner, "Введите пароль: ", validator::validatePassword);
        if (password == null) return null;

        String phoneNumber = validator.valInput(scanner, "Введите номер телефона (+996): ", input -> input.length() == 13 && input.startsWith("+"));
        if (phoneNumber == null) return null;

        studentService.addNewStudent(name, email, password, phoneNumber);
        System.out.println("Студент зарегистрирован.");
        return studentService.getStudentByEmail(email);
    }
}
