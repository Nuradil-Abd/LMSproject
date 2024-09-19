package lms.dao;

import lms.models.Instructor;
import lms.models.Student;


import java.util.Set;

public interface StudentDao {
    boolean addNewStudent(String name, String email, String password, String phoneNumber);
    Student getStudentByEmail(String email);
    void updateStudentByEmail(String email, String newName, String newPassword, String newPhoneNumber);
    void deleteStudentByEmail(String email);
    Set<Student> getAllStudentsByGroupName(String groupName);

    Student getStudentByEmailForInstructor(String email, Instructor instructor);
}
