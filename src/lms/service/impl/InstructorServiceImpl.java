package lms.service.impl;

import lms.dao.InstructorDao;
import lms.dao.StudentDao;
import lms.dao.impl.InstructorDaoImpl;
import lms.dao.impl.StudentDaoImpl;
import lms.models.Instructor;
import lms.models.Lesson;
import lms.models.Student;
import lms.service.InstructorService;

import java.util.List;
import java.util.Set;

public class InstructorServiceImpl implements InstructorService {

    private final InstructorDao instructorDao = new InstructorDaoImpl();
    private final StudentDao studentDao = new StudentDaoImpl();

    @Override
    public Instructor checkInstructorInDatabase(String email, String password) {
        return instructorDao.checkInstructorInDatabase(email, password);
    }

    @Override
    public void addLessonToGroup(String groupName, Lesson lesson) {
        instructorDao.addLessonToGroup(groupName, lesson);

    }

    //
    @Override
    public void addInstructor(String name, String email, String password, String phoneNumber) {

        instructorDao.addInstructor(name, email, password, phoneNumber);
    }

    @Override
    public Instructor getInstructorByEmail(String email) {
        return instructorDao.getInstructorByEmail(email);
    }

    @Override
    public Set<Instructor> getAllInstructorsByGroupName(String groupName) {
        return instructorDao.getAllInstructorsByGroupName(groupName);
    }

    @Override
    public void updateInstructorByEmail(String email, String newName, String newPassword, String newPhoneNumber) {

        instructorDao.updateInstructorByEmail(email, newName, newPassword, newPhoneNumber);

    }

    //
//    @Override
//    public void deleteInstructorByEmail(String email) {
//        instructorDao.deleteInstructor(email);
//    }
//
    @Override
    public Set<Student> getAllStudentsByInstructorEmail(String email) {
        return instructorDao.getAllStudentsByInstructorEmail(email);
    }
}
