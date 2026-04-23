package university.academic;

import university.enums.LessonType;

import java.time.LocalDate;

public class Lesson {
    private final String lessonId;
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

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LessonType getType() {
        return type;
    }

    public void setType(LessonType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonId='" + lessonId + '\'' +
                ", topic='" + topic + '\'' +
                ", date=" + date +
                ", type=" + type +
                '}';
    }
}
