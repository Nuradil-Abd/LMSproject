package lms.dao.impl;

import lms.dao.AdminDao;
import lms.dao.GroupDao;
import lms.database.Database;
import lms.models.Admin;
import lms.models.Group;
import lms.models.Instructor;
import lms.models.Student;

public class AdminDaoImpl implements AdminDao {
    GroupDao groupDao = new GroupDaoImpl();

    @Override
    public Admin checkAdminInDatabase(String email, String password) {
        for (Admin admin : Database.admins) {
            if(admin.getEmail().contains(email) && admin.getPassword().contains(password)){
                return admin;
            }
        }
        return null;
    }

    @Override
    public void addStudentsToGroup(Student student, String groupName) {
        Group group = groupDao.getGroupByName(groupName);
        if( group!= null){
            group.getGroupsStudents().add(student);
            student.setGroupId(group.getId());
            System.out.println("Студент успешно добавлен в группу: " +  groupName);
        }else{

        System.out.println("Не удалось добавить студента в группу!");
        }

    }

   @Override
    public void addInstructorToGroup(Instructor instructor, String groupName) {
        Group group = groupDao.getGroupByName(groupName);
        if (group != null) {
            group.getGroupsInstructors().add(instructor);
            instructor.getGroupsName().add(group);
            System.out.println("Инструктор успешно добавлен в группу: " + group.getName());
        } else {
            System.out.println("Не удалось добавить инструктора в группу! Группа не найдена.");
        }
    }


    @Override
    public boolean addAdmin(String name, String email, String password, String phoneNumber) {

        for (Admin admin : Database.admins) {
            if (admin.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Админ с таким email уже зарегестрирован.");
                return false;
            }
        }
        Admin newAdmin = new Admin( name, email, password, phoneNumber);
        Database.admins.add(newAdmin);
        System.out.println("Admin добавлен: " + newAdmin);
        return true;
    }

    @Override
    public Admin getAdminByEmail(String email) {
        for (Admin admin : Database.admins) {
            if (admin.getEmail().equalsIgnoreCase(email)) {
                return admin;
            }
        }
        System.out.println("Admin с email " + email + " не найден.");
        return null;
    }
//
//    @Override
//    public void updateAdminByEmail(String email, String newName, String newPassword, String newPhoneNumber) {
//        Admin admin = getAdminByEmail(email);
//        if (admin != null) {
//            admin.setName(newName);
//            admin.setPassword(newPassword);
//            admin.setPhoneNumber(newPhoneNumber);
//            System.out.println("Admin information updated: " + admin);
//        } else {
//            System.out.println("Admin with this email not found.");
//        }
//    }
//
//    @Override
//    public void deleteAdminByEmail(String email) {
//        Admin admin = getAdminByEmail(email);
//        if (admin != null) {
//            Database.instructors.remove(admin);
//            System.out.println("Admin with email " + email + " deleted.");
//        } else {
//            System.out.println("Admin with this email not found.");
//        }
//    }
}
