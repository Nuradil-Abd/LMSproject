package lms.service.impl;

import lms.dao.StudentDao;
import lms.dao.GroupDao;
import lms.dao.impl.StudentDaoImpl;
import lms.dao.impl.GroupDaoImpl;
import lms.models.Instructor;
import lms.models.Student;
import lms.models.Group;
import lms.models.Lesson;
import lms.service.LessonService;
import lms.service.StudentService;

import java.util.List;
import java.util.Set;

public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao = new StudentDaoImpl();
    private final GroupDao groupDao = new GroupDaoImpl();

    //
    @Override
    public void addNewStudent(String name, String email, String password, String phoneNumber) {
        studentDao.addNewStudent(name, email, password, phoneNumber);
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentDao.getStudentByEmail(email);
    }

    @Override
    public Set<Student> getAllStudentsByGroupName(String groupName) {
        return studentDao.getAllStudentsByGroupName(groupName);
    }

    @Override
    public Set<Lesson> getAllStudentLessons(String email) {

        Student student = studentDao.getStudentByEmail(email);
        if (student != null) {
            return  student.getStudentLessons();
        }
        return null;
    }

    @Override
    public void updateStudentByEmail(String email, String newName, String newPassword, String newPhoneNumber) {
            studentDao.updateStudentByEmail(email, newName, newPassword, newPhoneNumber);
        }

    @Override
    public void deleteStudentByEmail(String email) {
        studentDao.deleteStudentByEmail(email);
    }

    @Override
    public Student getStudentByEmailForInstructor(String email, Instructor instructor) {
        return studentDao.getStudentByEmailForInstructor(email, instructor);
    }

}