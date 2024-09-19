package lms.service.impl;

import lms.dao.AdminDao;
import lms.dao.impl.AdminDaoImpl;
import lms.models.Admin;
import lms.models.Instructor;
import lms.models.Student;
import lms.service.AdminService;

public class AdminServiceImpl implements AdminService {
    private final AdminDao adminDao = new AdminDaoImpl();

    @Override
    public Admin checkAdminInDatabase(String email, String password) {
        return adminDao.checkAdminInDatabase(email, password);
    }
//
    @Override
    public boolean addAdmin(String name, String email, String password, String phoneNumber) {
        return adminDao.addAdmin(name, email, password, phoneNumber);
    }

    @Override
    public Admin getAdminByEmail(String email) {
        return adminDao.getAdminByEmail(email);
    }

    @Override
    public void addStudentsToGroup(Student student, String groupName) {
        adminDao.addStudentsToGroup(student, groupName);
    }

    @Override
    public void addInstructorToGroup(Instructor instructor, String groupName) {
        adminDao.addInstructorToGroup(instructor, groupName);
    }
//
//    @Override
//    public void updateAdminByEmail(String email, String newName, String newPassword, String newPhoneNumber) {
//        adminDao.updateAdminByEmail(email, newName, newPassword, newPhoneNumber);
//    }
//
//    @Override
//    public void deleteAdminByEmail(String email) {
//        adminDao.deleteAdminByEmail(email);
//    }
}
