package lms.dao.impl;

import lms.dao.GroupDao;
import lms.database.Database;
import lms.exceptions.NotFoundException;
import lms.models.Group;
import lms.models.Instructor;
import lms.utils.IdGenerator;

import java.sql.SQLOutput;

public class GroupDaoImpl implements GroupDao {

    @Override
    public boolean addGroup(String name) {

        for (Group group : Database.groups) {
            if (group.getName().equalsIgnoreCase(name)) {
                System.out.println("Group with this name already exists.");
                return false;
            }
        }
        Group newGroup = new Group(name);
        Database.groups.add(newGroup);
        System.out.println("Group added: " + newGroup);
        return true;
    }

    @Override
    public Group getGroupByName(String name) {
        for (Group group : Database.groups) {
            if (group.getName().equalsIgnoreCase(name)) {
                return group;
            }
        }
        System.out.println("Group с названием " + name + " не найдена.");
        return null;
    }

//    @Override
//    public Group getGroupById(Long id) {
//        for (Group group : Database.groups) {
//            if (group.getId().equals(id)) {
//                return group;
//            }
//        }
//        System.out.println("Group with id " + id + " not found.");
//        return null;
//    }

    @Override
    public void updateGroupByName(String name, String newName) {
        Group group = getGroupByName(name);
        if (group != null) {
            group.setName(newName);
            System.out.println("Название группы обновлено: " + newName);
        } else {
            System.out.println("Группы с таким названием не найдено.");
        }
    }

    @Override
    public void deleteGroupByName(String name) {
        Group group = getGroupByName(name);
        if (group != null) {
            Database.groups.remove(group);
            System.out.println("Группа " + name + " удалена.");
        } else {
            System.out.println("Группы с таким названием не найдено.");
        }
    }

    @Override
    public Group getGroupByNameForInstructor(String groupName, Instructor instructor) {
       Group group = getGroupByName(groupName);
        if (group == null ) {
            System.out.println("У инструктора " + instructor.getName() + " нет такой группы.");
            return null;
        }
        for (Instructor groupsInstructor : group.getGroupsInstructors()) {
            if(groupsInstructor.getName().equalsIgnoreCase(instructor.getName())){
                return group;
            }

        }


        System.out.println("У инструктора " + instructor.getName() + " нет группы с названием " + groupName);
        return null;
    }

}
