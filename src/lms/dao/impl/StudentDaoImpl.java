package lms.dao.impl;

import lms.dao.StudentDao;
import lms.database.Database;
import lms.models.Instructor;
import lms.models.Student;
import lms.models.Group;
import java.util.Set;


public class StudentDaoImpl implements StudentDao {

    @Override
    public boolean addNewStudent(String name, String email, String password, String phoneNumber) {

        for (Student student : Database.students) {
            if (student.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Student c таким email уже зарегестрирован.");
                return false;
            }
        }
        Student newStudent = new Student(name, email, password, phoneNumber);
        Database.students.add(newStudent);
        System.out.println("Student добавлен: " + newStudent);
        return true;
    }

    @Override
    public Student getStudentByEmail(String email) {
        for (Student student : Database.students) {
            if (student.getEmail().equalsIgnoreCase(email)) {
                return student;
            }
        }
        System.out.println("Student c email " + email + " не найден.");
        return null;
    }

    @Override
    public void updateStudentByEmail(String email, String newName, String newPassword, String newPhoneNumber) {
        Student student = getStudentByEmail(email);
        if (student != null) {
            student.setName(newName);
            student.setPassword(newPassword);
            student.setPhoneNumber(newPhoneNumber);
            System.out.println("Студент успешно обновлен: " + student);
        } else {
            System.out.println("Student c email " + email + " не найден.");
        }
    }

    @Override
    public void deleteStudentByEmail(String email) {
        Student student = getStudentByEmail(email);
        if (student != null) {
            Database.students.remove(student);
            for (Group group : Database.groups) {
                for (Student groupsStudent : group.getGroupsStudents()) {
                    if (groupsStudent.getEmail().equals(email)) {
                        group.getGroupsStudents().remove(groupsStudent);
                        System.out.println("Студент удален из группы: " + group.getName());
                    }

                }
            }
            System.out.println("Student c email " + email + " удален.");

        } else {
            System.out.println("Student c email " + email + " не найден.");
        }
    }

    @Override
    public Set<Student> getAllStudentsByGroupName(String groupName) {
        Group group = Database.getGroupByName(groupName);
        return group.getGroupsStudents();
    }

    @Override
    public Student getStudentByEmailForInstructor(String email, Instructor instructor) {
        Student student = getStudentByEmail(email);
        if(student == null){
            System.out.println("Студент не найден");
            return null;
        }
        for (Group group : instructor.getGroupsName()) {
            if(group.getId().equals(student.getGroupId())){
                return student;
            }
        }


        System.out.println("Этот студент не относится к кинструктору " + instructor.getName());
        return null;
    }
}
