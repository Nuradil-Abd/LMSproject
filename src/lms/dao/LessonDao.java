package lms.dao;

import lms.models.Instructor;
import lms.models.Lesson;


import java.util.Set;

public interface LessonDao {
//    boolean addLesson(String title);
    Lesson getLessonById(Long id);
    Lesson getLessonByTitle(String title);
    void deleteLessonByTitle(String title, Long instructorId);
    Set<Lesson> getAllLessonsByGroupName(String groupName);

    Lesson getLessonByIdForInstructor(Long lessonId, Instructor instructor);
}
