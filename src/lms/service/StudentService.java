package lms.service;

import lms.models.Instructor;
import lms.models.Lesson;
import lms.models.Student;

import java.util.List;
import java.util.Set;

public interface StudentService {
    void addNewStudent(String name, String email, String password, String phoneNumber);
    Student getStudentByEmail(String email);
    Set<Student> getAllStudentsByGroupName(String groupName);
    Set<Lesson> getAllStudentLessons(String email);
    void updateStudentByEmail(String email, String newName, String newPassword, String newPhoneNumber);
    void deleteStudentByEmail(String email);

    Student getStudentByEmailForInstructor(String email, Instructor instructor);
}
