package lms.commands;


import lms.models.Admin;
import lms.models.Instructor;
import lms.service.AdminService;
import lms.service.GroupService;
import lms.service.InstructorService;
import lms.service.StudentService;
import lms.service.impl.AdminServiceImpl;
import lms.service.impl.GroupServiceImpl;
import lms.service.impl.InstructorServiceImpl;
import lms.service.impl.StudentServiceImpl;

import java.util.Scanner;

public class Runner {

    public static void run(Scanner scan){
        AdminService adminService = new AdminServiceImpl();
        InstructorService instructorService = new InstructorServiceImpl();
        StudentService studentService = new StudentServiceImpl();
        Show show = new Show();
        while (true){
            show.show();
            System.out.print("Выберите команду: " );
            int choice = scan.nextInt();
            switch (choice){
                case 1 -> {
//                    System.out.println("1/2");
//                    int choice1 = scan.nextInt();
//                    if(choice1 == 1){
                    signIn(scan);
//                    Commands.commandsForAdmin(scan,new Admin(
//                            "Nuradil", "admin@gmail.com","Admin123!", "+996 502 63 70 33 "
//                    )); return;}else{
//                    Commands.commandsForInstructor(scan,new Instructor("Islam","islam@gmail.com","ASDqwe123&","+996 300 200 102"));
//                return;}
                }
                case 2 -> {
                    Register register = new Register(adminService,instructorService,studentService);
                    scan.nextLine();
                    register.execute(scan);

                }
            }
        }
    }
    private static void signIn(Scanner scan) {
        System.out.print("Введите email: ");
        String email = scan.nextLine();
        scan.nextLine();


        System.out.print("Введите пароль: ");
        String password = scan.nextLine();

        Sign.sign(email,password,scan);
    }

}
