package lms.service.impl;

import lms.dao.GroupDao;
import lms.dao.impl.GroupDaoImpl;
import lms.models.Group;
import lms.models.Instructor;
import lms.service.GroupService;



public class GroupServiceImpl implements GroupService {

    private final GroupDao groupDao = new GroupDaoImpl();

    @Override
    public void addGroup(String name) {
        groupDao.addGroup(name);
    }

    @Override
    public Group getGroupByName(String name) {
        return groupDao.getGroupByName(name);
    }

    @Override
    public void updateGroupByName(String oldName, String newName) {

            groupDao.updateGroupByName(oldName, newName);
    }

    @Override
    public void deleteGroupByName(String name) {

            groupDao.deleteGroupByName(name);

    }

    @Override
    public Group getGroupByNameForInstructor(String groupName, Instructor instructor) {

        return groupDao.getGroupByNameForInstructor(groupName,instructor);
    }
//
//    @Override
//    public List<Group> getAllGroups() {
//        return groupDao.getAllGroups();
//    }
}
