package lms.dao.impl;

import lms.dao.GroupDao;
import lms.dao.InstructorDao;
import lms.database.Database;
import lms.models.Group;
import lms.models.Instructor;
import lms.models.Lesson;
import lms.models.Student;

import java.util.HashSet;
import java.util.Set;

public class InstructorDaoImpl implements InstructorDao {

    GroupDao groupDao = new GroupDaoImpl();
    @Override
    public Instructor checkInstructorInDatabase(String email, String password) {
        for (Instructor instructor : Database.instructors) {

            if(instructor.getEmail().contains(email) && instructor.getPassword().contains(password)){
                return instructor;
            }

        }
        return null;
    }

    @Override
    public Set<Student> getAllStudentsByInstructorEmail(String email) {
        Instructor instructor = getInstructorByEmail(email);
        Set<Student> allStudents = new HashSet<>();
        if(instructor != null){
            for (Group group : instructor.getGroupsName()) {
                allStudents.addAll(group.getGroupsStudents());
            }
        }
        return allStudents;
    }

    @Override
    public Set<Instructor> getAllInstructorsByGroupName(String groupName) {

        return Database.getGroupByName(groupName).getGroupsInstructors();
    }

    @Override
    public void addLessonToGroup(String groupName, Lesson lesson) {
       Group group =  groupDao.getGroupByName(groupName);
       if(group != null){
           group.getGroupsLessons().add(lesson);
           System.out.println(lesson + " урок добавлен в группу " + groupName);
       }else System.out.println("Группа не найдена");
    }


    @Override
    public boolean addInstructor(String name, String email, String password, String phoneNumber) {

        for (Instructor instructor : Database.instructors) {
            if (instructor.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Instructor с таким email уже зарегестрирован.");
                return false;
            }
        }
        Instructor newInstructor = new Instructor( name, email, password, phoneNumber);
        Database.instructors.add(newInstructor);
        System.out.println("Instructor добавлен: " + newInstructor);
        return true;
    }

    @Override
    public Instructor getInstructorByEmail(String email) {
        for (Instructor instructor : Database.instructors) {
            if (instructor.getEmail().equalsIgnoreCase(email)) {
                return instructor;
            }
        }
        System.out.println("Instructor c email " + email + " не найден.");
        return null;
    }

    @Override
    public void updateInstructorByEmail(String email, String newName, String newPassword, String newPhoneNumber) {
        Instructor instructor = getInstructorByEmail(email);
        if (instructor != null) {
            instructor.setName(newName);
            instructor.setPassword(newPassword);
            instructor.setPhoneNumber(newPhoneNumber);
            System.out.println("Информация об инструкторе: " + instructor + " обновлена");
        } else {
            System.out.println("Instructor c email " + email + " не найден.");
        }
    }
//
//    @Override
//    public void deleteInstructorByEmail(String email) {
//        Instructor instructor = getInstructorByEmail(email);
//        if (instructor != null) {
//            Database.instructors.remove(instructor);
//            System.out.println("Instructor with email " + email + " deleted.");
//        } else {
//            System.out.println("Instructor with this email not found.");
//        }
//    }
}
