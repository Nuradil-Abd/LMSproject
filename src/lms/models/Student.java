package lms.models;

import lms.enums.UserType;
import lms.utils.IdGenerator;

import java.util.HashSet;
import java.util.Set;

public class Student extends User {
    private final UserType positions;
   private Set<Lesson> studentLessons ;
   private Long groupId = 0L;

    public Student(String name, String email, String password, String phoneNumber) {
        super(IdGenerator.genStudentId(), name, email, password, phoneNumber);
        this.studentLessons = new HashSet<>();
        this.positions = UserType.STUDENT;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public UserType getPositions() {
        return positions;
    }

    public Set<Lesson> getStudentLessons() {
        return studentLessons;
    }

    public void setStudentLessons(Set<Lesson> studentLessons) {
        this.studentLessons = studentLessons;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentLessons=" + studentLessons +
                "} " + super.toString();
    }
}
