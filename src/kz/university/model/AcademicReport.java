package kz.university.model;

import java.io.Serializable;
import java.util.List;

public class AcademicReport implements Serializable {
    private double averageMark;
    private int passedCount;
    private int failedCount;

    public void generate(List<Enrollment> enrollments) {
        double sum = 0;
        int count = 0;
        passedCount = 0;
        failedCount = 0;

        for (Enrollment e : enrollments) {
            if (e.getMark() == null) continue;
            sum += e.getTotal();
            count++;
            if (e.getMark().isPassed()) {
                passedCount++;
            } else {
                failedCount++;
            }
        }
        averageMark = count == 0 ? 0 : sum / count;
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "AcademicReport{" +
                "averageMark=" + averageMark +
                ", passedCount=" + passedCount +
                ", failedCount=" + failedCount +
                '}';
    }
}
