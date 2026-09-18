package app;

import model.Student;
import exception.InvalidScoreException;
import storage.FileStorage;

import java.util.*;

public class StudentService {
    private List<Student> students;

    public StudentService() {
        this.students = FileStorage.loadStudents();
    }

    public void addStudent(String id, String name, int attended, int total) {
        students.add(new Student(id, name, attended, total));
        FileStorage.saveStudents(students);
    }

    public void addMarkToStudent(String id, double mark) throws InvalidScoreException {
        if (mark < 0 || mark > 100) {
            throw new InvalidScoreException("Score must be between 0 and 100.");
        }
        Student s = findStudent(id);
        if (s != null) {
            s.addMark(mark);
            FileStorage.saveStudents(students);
        } else {
            System.out.println("Student not found.");
        }
    }

    public Student findStudent(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) return s;
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public void displaySummaryReport() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("\n--- Performance & Defaulter Summary ---");
        for (Student s : students) {
            double avg = s.calculateAverage();
            double att = s.getAttendancePercentage();
            String status = (att < 75.0) ? "DEFICIT (<75%)" : "ELIGIBLE";
            System.out.printf("ID: %s | Name: %s | Average: %.2f | Attendance: %.1f%% [%s]\n",
                    s.getId(), s.getName(), avg, att, status);
        }
    }
}
