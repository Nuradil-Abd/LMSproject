package lms.models;

import lms.enums.UserType;
import lms.utils.IdGenerator;

import java.util.HashSet;
import java.util.Set;

public class Instructor extends User {
    private final UserType positions;
    private Set<Group> groupsName;
    private Set<Long> lessonsId;
    private Set<Long> studentId;

    public Instructor( String name, String email, String password, String phoneNumber) {
        super(IdGenerator.genInstructorId(),name, email, password, phoneNumber);
        this.groupsName = new HashSet<>();
        this.positions = UserType.INSTRUCTOR;
    }

    public Set<Long> getStudentId() {
        return studentId;
    }

    public void setStudentId(Set<Long> studentId) {
        this.studentId = studentId;
    }

    public UserType getPositions() {
        return positions;
    }

    public Set<Group> getGroupsName() {
        return groupsName;
    }

    public void setGroupsName(Set<Group> groupsName) {
        this.groupsName = groupsName;
    }

    public Set<Long> getLessonsId() {
        return lessonsId;
    }

    public void setLessonsId(Set<Long> lessonsId) {
        this.lessonsId = lessonsId;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + getId()+
                ", name='" + getName() + '\'' +
                ", groupCount=" + (groupsName != null ? groupsName.size() : 0) +
                '}';
    }

}
