package lms.dao;

import lms.models.Group;
import lms.models.Instructor;

public interface GroupDao {
    boolean addGroup(String name);
    Group getGroupByName(String name);
//    Group getGroupById(Long id);
    void updateGroupByName(String name, String newName);
    void deleteGroupByName(String name);

    Group getGroupByNameForInstructor(String groupName, Instructor instructor);
}
