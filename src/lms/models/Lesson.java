package lms.models;

import lms.utils.IdGenerator;

import java.util.Set;

public class Lesson {

    private Long id;
    private String title;
    private Set<Long> studentsId;
    private Long instructorId = 0L;

    public Lesson(String name, Long instructorId) {
        this.id = IdGenerator.genLessonId();
        this.title = name;
        this.instructorId = instructorId;

    }

    public Lesson(String title) {
        this.title = title;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public Set<Long> getStudentsId() {
        return studentsId;
    }

    public void setStudentsId(Set<Long> studentsId) {
        this.studentsId = studentsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                ", id=" + id +
                "name='" + title + '\'' +
                '}';
    }
}
