package lms.database;

import lms.exceptions.NotFoundException;

import lms.models.Admin;
import lms.models.Group;
import lms.models.Instructor;
import lms.models.Student;
import lms.models.Lesson;

import java.util.*;

public class Database {
    public static final List<Admin> admins = new ArrayList<>(Set.of( new Admin(
            "Nuradil", "admin@gmail.com","Admin123!", "+996 502 63 70 33 "
    )));
    public static List<Instructor> instructors = new ArrayList<>(Set.of(
            new Instructor("Islam","islam@gmail.com","ASDqwe123&","+996 300 200 102")));
    public static List<Student> students = new ArrayList<>(Set.of(
            new Student("Atai","atai@gmail.com", "Qwerty123!", "+996 700 300 200"),
            new Student("Kayrat","kayrat@gmail.com", "Qwerty321!", "+996 700 300 200"),
            new Student("Alina","Alina@gmail.com", "Qwerty312!", "+996 700 300 200"),
            new Student("Ilim","ilim@gmail.com", "Qwerty678!", "+996 700 300 200"),
            new Student("Baysal","BAY@gmail.com", "Asdf123!", "+996 700 300 200"),
            new Student("Ekaterina","Kate@gmail.com", "ASdf123!", "+996 700 300 200"),
            new Student("Daria","dasha@gmail.com", "ASDf123!", "+996 700 300 200"),
            new Student("Uluk","ulukmanapo@gmail.com", "ASDF123!", "+996 700 300 200"),
            new Student("Erlan","Erjanio@gmail.com", "QWErt123!", "+996 700 300 200"),
            new Student("Karim","Benzema@gmail.com", "QWErtY123!", "+996 700 300 200"),
            new Student("Manuel","neuer@gmail.com", "QWERty123!", "+996 700 300 200")
    ));
    public static Set<Group> groups = new HashSet<>(Set.of(new Group("Java"),new Group("JS")));
    public static List<Lesson> lessons = new ArrayList<>();


    public static Group getGroupByName(String groupName) {
        for (Group group : Database.groups) {
            if(group.getName().equalsIgnoreCase(groupName)){
                return group;
            }
        }throw new NotFoundException("Группа не найдена");
    }
}
