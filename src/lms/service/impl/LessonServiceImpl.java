package lms.service.impl;

import lms.dao.LessonDao;
import lms.dao.impl.LessonDaoImpl;
import lms.models.Instructor;
import lms.models.Lesson;
import lms.service.LessonService;

import java.util.List;
import java.util.Set;

public class LessonServiceImpl implements LessonService {

    private final LessonDao lessonDao = new LessonDaoImpl();
//
//    @Override
//    public void addLessonToGroup(String lessonTitle, Long groupId, String instructorEmail) {
//        Lesson lesson = new Lesson(lessonTitle, groupId);
//        lessonDao.addLesson(lesson);
//    }
//
    @Override
    public Lesson getLessonByTitle(String title) {
        return lessonDao.getLessonByTitle(title);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonDao.getLessonById(id);
    }

    @Override
    public Set<Lesson> getAllLessonsByGroupName(String groupName) {
        return lessonDao.getAllLessonsByGroupName(groupName);
    }

    @Override
    public Lesson getLessonByIdForInstructor(Long lessonId, Instructor instructor) {
        return lessonDao.getLessonByIdForInstructor(lessonId,instructor);
    }

//    @Override
//    public void updateLessonTitle(Long lessonId, String newTitle) {
//        Lesson lesson = lessonDao.getLessonById(lessonId);
//        if (lesson != null) {
//            lesson.setName(newTitle);
//            lessonDao.updateLesson(lesson);
//        }
//    }
//
    @Override
    public void deleteLessonByName(String name, Long instructorID) {
        lessonDao.deleteLessonByTitle(name, instructorID);
    }
}
