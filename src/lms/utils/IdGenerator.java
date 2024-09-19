package lms.utils;

public class IdGenerator {

    private static Long adminId = 0L;
    private static Long instructorId = 0L;
    private static Long studentId = 0L;
    private static Long groupId = 0L;
    private static Long lessonId = 0L;


    public static Long genAdminId() {
        adminId++;
        return adminId;
    }

    public static Long genInstructorId() {
        instructorId++;
        return instructorId;
    }


    public static Long genStudentId() {
        studentId++;
        return studentId;
    }


    public static Long genGroupId() {
        groupId++;
        return groupId;
    }


    public static Long genLessonId() {
        lessonId++;
        return lessonId;
    }
}
