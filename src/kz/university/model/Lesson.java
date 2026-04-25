package kz.university.model;

import java.io.Serializable;
import java.time.LocalDate;
import kz.university.enums.LessonType;

public class Lesson implements Serializable {
    private String lessonId;
    private String topic;
    private LocalDate date;
    private LessonType type;

    public Lesson(String lessonId, String topic, LocalDate date, LessonType type) {
        this.lessonId = lessonId;
        this.topic = topic;
        this.date = date;
        this.type = type;
    }

    public String getLessonId() {
        return lessonId;
    }

    public String getTopic() {
        return topic;
    }

    public LocalDate getDate() {
        return date;
    }

    public LessonType getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + ": " + topic + " at " + date;
    }
}
