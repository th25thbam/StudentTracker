package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private List<Double> marks;
    private int attendedClasses;
    private int totalClasses;

    public Student(String id, String name, int attendedClasses, int totalClasses) {
        super(id, name);
        this.marks = new ArrayList<>();
        this.attendedClasses = attendedClasses;
        this.totalClasses = totalClasses;
    }

    public void addMark(double mark) {
        marks.add(mark);
    }

    public List<Double> getMarks() { return marks; }
    public int getAttendedClasses() { return attendedClasses; }
    public int getTotalClasses() { return totalClasses; }

    public double calculateAverage() {
        if (marks.isEmpty()) return 0.0;
        double sum = 0;
        for (double m : marks) sum += m;
        return sum / marks.size();
    }

    public double getAttendancePercentage() {
        if (totalClasses == 0) return 0.0;
        return ((double) attendedClasses / totalClasses) * 100.0;
    }
}