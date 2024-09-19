package lms.service;

import lms.models.Group;
import lms.models.Instructor;



public interface GroupService {
    void addGroup(String name);
    Group getGroupByName(String name);
    void updateGroupByName(String oldName, String newName);
    void deleteGroupByName(String name);
    Group getGroupByNameForInstructor(String groupName, Instructor instructor);
//    List<Group> getAllGroups();
}
