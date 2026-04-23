package university.academic;

import university.core.Teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {
    private final String courseId;
    private String name;
    private int credits;
    private String description;
    private final List<Lesson> lessons = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();

    public Course(String courseId, String name, int credits, String description) {
        this.courseId = courseId;
        this.name = name;
        this.credits = credits;
        this.description = description;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public void addTeacher(Teacher teacher) {
        if (!teachers.contains(teacher)) {
            teachers.add(teacher);
        }
    }

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Lesson> getLessons() {
        return Collections.unmodifiableList(lessons);
    }

    public List<Teacher> getTeachers() {
        return Collections.unmodifiableList(teachers);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                '}';
    }
}
