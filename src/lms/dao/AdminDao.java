package lms.dao;

import lms.models.Admin;
import lms.models.Instructor;
import lms.models.Student;

public interface AdminDao {
    boolean addAdmin(String name, String email, String password, String phoneNumber);
    Admin getAdminByEmail(String email);
//    void updateAdminByEmail(String email, String newName, String newPassword, String newPhoneNumber);
//    void deleteAdminByEmail(String email);
  Admin checkAdminInDatabase(String email, String password);
  void addStudentsToGroup(Student student, String groupName);
  void addInstructorToGroup(Instructor instructor, String groupName);
}
