package lms.models;

import lms.utils.IdGenerator;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Group {
    private Long id;
    private String name;
    private Set<Student> groupsStudents;
    private Set<Instructor> groupsInstructors;
    private Set<Lesson> groupsLessons;



    public Group( String name) {
        this.id = IdGenerator.genGroupId();
        this.name = name;
        this.groupsStudents = new HashSet<>();
        this.groupsInstructors = new HashSet<>();
        this.groupsLessons = new HashSet<>();

    }

    public Set<Lesson> getGroupsLessons() {
        return groupsLessons;
    }

    public void setGroupsLessons(Set<Lesson> groupsLessons) {
        this.groupsLessons = groupsLessons;
    }

    public Set<Instructor> getGroupsInstructors() {
        return groupsInstructors;
    }

    public void setGroupsInstructors(Set<Instructor> groupsInstructors) {
        this.groupsInstructors = groupsInstructors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getGroupsStudents() {
        return groupsStudents;
    }

    public void setGroupsStudents(Set<Student> groupsStudents) {
        this.groupsStudents = groupsStudents;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(id, group.id) &&
                Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentCount=" + (groupsStudents != null ? groupsStudents.size() : 0) +
                ", instructorCount=" + (groupsInstructors != null ? groupsInstructors.size() : 0) +
                ", lessonsCount=" + (groupsLessons != null ? groupsLessons.size() : 0) +
                '}';
    }

}
