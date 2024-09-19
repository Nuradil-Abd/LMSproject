package lms.service;

import lms.models.Instructor;
import lms.models.Lesson;

import java.util.List;
import java.util.Set;

public interface LessonService {
//    void addLessonToGroup(String lessonTitle, Long groupId, String instructorEmail);
    Lesson getLessonByTitle(String title);
    Lesson getLessonById(Long id);
    Set<Lesson> getAllLessonsByGroupName(String groupName);

    Lesson getLessonByIdForInstructor(Long lessonId, Instructor instructor);
//    void updateLessonTitle(Long lessonId, String newTitle);
    void deleteLessonByName(String name, Long instructorId);
}
