package lms.dao;

import lms.models.Instructor;
import lms.models.Lesson;
import lms.models.Student;

import java.util.Set;

public interface InstructorDao {
    boolean addInstructor(String name, String email, String password, String phoneNumber);
    Instructor getInstructorByEmail(String email);
    void updateInstructorByEmail(String email, String newName, String newPassword, String newPhoneNumber);
//    void deleteInstructorByEmail(String email);
    Instructor checkInstructorInDatabase (String email, String password);

    Set<Student> getAllStudentsByInstructorEmail(String email);

    Set<Instructor> getAllInstructorsByGroupName(String groupName);

    void addLessonToGroup(String groupName, Lesson lesson);
}
