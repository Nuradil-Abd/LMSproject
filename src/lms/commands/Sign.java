package lms.commands;

import lms.enums.UserType;
import lms.models.Admin;
import lms.models.Instructor;
import lms.service.AdminService;
import lms.service.InstructorService;
import lms.service.impl.AdminServiceImpl;
import lms.service.impl.InstructorServiceImpl;

import java.util.Scanner;

public class Sign {

    private static final AdminService adminService = new AdminServiceImpl();
    private static final InstructorService instructorService = new InstructorServiceImpl();


    public static void sign(String email, String password, Scanner scanner) {
       Admin admin = adminService.checkAdminInDatabase(email, password);
       Instructor instructor = instructorService.checkInstructorInDatabase(email, password);


        if (admin != null && admin.getPositions() != null && admin.getPositions() == UserType.ADMIN) {
            Commands.commandsForAdmin(scanner,admin);
        } else if (instructor != null && instructor.getPositions() != null && instructor.getPositions() == UserType.INSTRUCTOR) {
            Commands.commandsForInstructor(scanner, instructor);
        } else {
            System.out.println("Пользователь с таким email и паролем не найден.");
        }
    }

}
