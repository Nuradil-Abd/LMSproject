package lms.dao.impl;

import lms.dao.LessonDao;
import lms.database.Database;
import lms.models.Group;
import lms.models.Instructor;
import lms.models.Lesson;
import lms.models.Student;
import lms.utils.IdGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LessonDaoImpl implements LessonDao {
//
//    @Override
//    public boolean addLesson(String title, String description, Long groupId, Long instructorId) {
//        // Check for duplicates
//        for (Lesson lesson : Database.lessons) {
//            if (lesson.getTitle().equalsIgnoreCase(title)) {
//                System.out.println("Lesson with this title already exists.");
//                return false;
//            }
//        }
//        Lesson newLesson = new Lesson(IdGenerator.genLessonId(), title, description, groupId, instructorId);
//        Database.lessons.add(newLesson);
//        System.out.println("Lesson added: " + newLesson);
//        return true;
//    }
//
    @Override
    public Lesson getLessonById(Long id) {
        for (Lesson lesson : Database.lessons) {
            if (lesson.getId().equals(id)) {
                return lesson;
            }
        }
        System.out.println("Урок с id " + id + " не найден.");
        return null;
    }

    @Override
    public Lesson getLessonByTitle(String title) {
        for (Lesson lesson : Database.lessons) {
            if (lesson.getTitle().equalsIgnoreCase(title)) {
                return lesson;
            }
        }
        System.out.println("Урок с именем " + title + " не найден.");
        return null;
    }
//
    @Override
    public void deleteLessonByTitle(String title, Long instructorId) {
        Lesson lesson = getLessonByTitle(title);
        if (lesson != null) {
            if(lesson.getInstructorId().equals(instructorId)){
            Database.lessons.remove(lesson);
            System.out.println("Lesson with title " + title + " deleted.");
            }
        } else {
            System.out.println("Lesson with this title not found.");
        }
    }
//
@Override
public Set<Lesson> getAllLessonsByGroupName(String groupName) {
    Group group = Database.getGroupByName(groupName);
    if (group != null) {
        Set<Lesson> lessons = new HashSet<>();
        for (Student student : group.getGroupsStudents()) {
            lessons.addAll(student.getStudentLessons());
        }
        return lessons;
    }

    System.out.println("Группа с названием " + groupName + " не найдена.");
    return new HashSet<>();
}

    @Override
    public Lesson getLessonByIdForInstructor(Long lessonId, Instructor instructor) {
        Lesson curLesson = getLessonById(lessonId);
        if(curLesson == null){
            System.out.println("Урок с таким id  не найден");
        return null;
        }
        if(curLesson.getInstructorId().equals(instructor.getId())){
            return curLesson;
        }
        System.out.println("Урок с таким id не относится к данному инструктору" + instructor.getName());
        return null;
    }

}
