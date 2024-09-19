package lms.commands;


import lms.database.Database;
import lms.models.*;
import lms.service.AdminService;
import lms.service.GroupService;
import lms.service.InstructorService;
import lms.service.LessonService;
import lms.service.StudentService;
import lms.service.impl.AdminServiceImpl;
import lms.service.impl.GroupServiceImpl;
import lms.service.impl.InstructorServiceImpl;
import lms.service.impl.LessonServiceImpl;
import lms.service.impl.StudentServiceImpl;


import java.util.Scanner;
import java.util.Set;

public class Commands {

    public static void commandsForAdmin(Scanner scan,Admin admin) {
        AdminService adminService = new AdminServiceImpl();
        GroupService groupService = new GroupServiceImpl();
        InstructorService instructorService = new InstructorServiceImpl();
        LessonService lessonService = new LessonServiceImpl();
        StudentService studentService = new StudentServiceImpl();
        Register register = new Register(adminService,instructorService,studentService);
        Show show = new Show();

        while (true) {
            show.showForAdmin();
            System.out.print("Выберите команду: ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Название группы: ");
                    groupService.addGroup(scan.nextLine());
                }
                case 2 -> {
                   Student newStudent = register.registerStudentWithoutCheck(scan);
                    System.out.print("Название группы: ");
                    adminService.addStudentsToGroup(newStudent,scan.nextLine());
                }
                case 3 -> {
                    Instructor newInstructor = register.registerInstructor(scan);
                    System.out.print("Название группы: ");
                    adminService.addInstructorToGroup(newInstructor,scan.nextLine());
                }
                case 4 -> {
                    for (Group group : Database.groups) {
                        System.out.println(group);
                    }
                }
                case 5 -> {
                    System.out.print("Название группы: ");
                    String groupName = scan.nextLine();
                    Group group = groupService.getGroupByName(groupName);
                    System.out.println(group);
                }
                case 6 -> {
                    System.out.print("Email студента: ");
                    String email = scan.nextLine();
                    Student student = studentService.getStudentByEmail(email);
                    System.out.println(student);
                }
                case 7 -> {
                    System.out.print("Название группы: ");
                    String groupName = scan.nextLine();
                    System.out.println(studentService.getAllStudentsByGroupName(groupName));

                }
                case 8 -> {
                    System.out.print("Email студента: ");
                    String studentEmail = scan.nextLine();
                    System.out.println(studentService.getAllStudentLessons(studentEmail));


                }
                case 9 -> {
                    System.out.print("Название группы: ");
                    String groupName = scan.nextLine();
                    System.out.println(lessonService.getAllLessonsByGroupName(groupName));


                }
                case 10 -> {
                    System.out.print("Email инструктора: ");
                    String email = scan.nextLine();
                    Instructor instructor = instructorService.getInstructorByEmail(email);
                    System.out.println(instructor);
                }
                case 11 -> {
                    System.out.print("Email инструктора: ");
                    String instructorEmail = scan.nextLine();

                    System.out.println(instructorService.getAllStudentsByInstructorEmail(instructorEmail));

                }
                case 12 -> {
                    System.out.print("Название группы: ");
                    String groupName = scan.nextLine();

                    System.out.println(instructorService.getAllInstructorsByGroupName(groupName));

                }
                case 13 -> {
                    System.out.print("Email студента: ");
                    String email = scan.nextLine();
                    System.out.print("Новое имя: ");
                    String newName = scan.nextLine();
                    System.out.print("Новый пароль: ");
                    String newPassword = scan.nextLine();
                    System.out.print("Новый номер телефона: ");
                    String newPhoneNumber = scan.nextLine();
                    studentService.updateStudentByEmail(email, newName, newPassword, newPhoneNumber);
                }
                case 14 -> {
                    System.out.print("Email инструктора: ");
                    String email = scan.nextLine();
                    System.out.print("Новое имя: ");
                    String newName = scan.nextLine();
                    System.out.print("Новый пароль: ");
                    String newPassword = scan.nextLine();
                    System.out.print("Новый номер телефона: ");
                    String newPhoneNumber = scan.nextLine();
                    instructorService.updateInstructorByEmail(email, newName, newPassword, newPhoneNumber);
                }
                case 15 -> {
                    System.out.print("Название группы: ");
                    String groupName = scan.nextLine();
                    System.out.print("Новое название группы: ");
                    String newGroupName = scan.nextLine();
                    groupService.updateGroupByName(groupName, newGroupName);
                }
                case 16 -> {
                    System.out.print("Название группы: ");
                    String groupName = scan.nextLine();
                    groupService.deleteGroupByName(groupName);
                }
                case 17 -> {
                    System.out.print("Email студента: ");
                    String email = scan.nextLine();
                    studentService.deleteStudentByEmail(email);
                }
                case 0 -> {
                    System.out.println("Выход в главное менью.");
                    Runner.run(scan);
                }
                default -> System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    public static void commandsForInstructor(Scanner scan, Instructor instructor) {
        InstructorService instructorService = new InstructorServiceImpl();
        GroupService groupService = new GroupServiceImpl();
        LessonService lessonService = new LessonServiceImpl();
        StudentService studentService = new StudentServiceImpl();
        Show show = new Show();

        while (true) {
            show.showForInstructor();
            System.out.print("Выберите команду: ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Название урока: ");
                    String title = scan.nextLine();
                    System.out.print("Название группы: ");
                    String groupName = scan.nextLine();
                    Database.lessons.add(new Lesson(title,instructor.getId()));
                    Group group = groupService.getGroupByName(groupName);
                    if (group != null) {
                      instructorService.addLessonToGroup(groupName, new Lesson(title,instructor.getId()));
                    }
                }
                case 2 -> {
                    System.out.print("Название группы: ");
                    String groupName = scan.nextLine();
                    Group group = groupService.getGroupByNameForInstructor(groupName,instructor);
                    System.out.println(group);
                }
                case 3 -> {
                    System.out.print("Название урока: ");
                    String title = scan.nextLine();
                    Lesson lesson = lessonService.getLessonByTitle(title);
                    System.out.println(lesson);
                }
                case 4 -> {
                    System.out.print("Email студента: ");
                    String email = scan.nextLine();
                    Student student = studentService.getStudentByEmailForInstructor(email,instructor);
                    System.out.println(student);
                }
                case 5 -> {
                    System.out.print("Название группы: ");
                    String groupName = scan.nextLine();
                    Set<Student> students = groupService.getGroupByNameForInstructor(groupName,instructor).getGroupsStudents();
                    for (Student student : students) {
                        System.out.println(student);
                    }
                }
                case 6 -> {
                    System.out.print("ID урока: ");
                    Long lessonId = scan.nextLong();
                    Lesson lesson = lessonService.getLessonByIdForInstructor(lessonId, instructor);
                    System.out.println(lesson);
                }
                case 7 -> {
                    System.out.print("Название группы: ");
                    String groupName = scan.nextLine();
                    Set<Lesson> lessons = groupService.getGroupByNameForInstructor(groupName,instructor).getGroupsLessons();
                    for (Lesson lesson : lessons) {
                        System.out.println(lesson);
                    }
                }
                case 8 -> {

                    Set<Student> students = instructorService.getAllStudentsByInstructorEmail(instructor.getEmail());
                    for (Student student : students) {
                        System.out.println(student);
                    }
                }
                case 9 -> {
                    System.out.print("Название урока: ");
                    String title = scan.nextLine();
                    lessonService.deleteLessonByName(title,instructor.getId());
                }
                case 0 -> {
                    System.out.println("Выход в главное менью.");
                    Runner.run(scan);
                }
                default -> System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }
}
