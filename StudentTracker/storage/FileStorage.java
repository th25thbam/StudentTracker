package storage;

import model.Student;
import java.io.*;
import java.util.*;

public class FileStorage {
    private static final String FILE_NAME = "students.txt";

    public static void saveStudents(List<Student> students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                // Format: ID,Name,Attended,Total,Mark1;Mark2;...
                StringBuilder sb = new StringBuilder();
                sb.append(s.getId()).append(",").append(s.getName()).append(",")
                  .append(s.getAttendedClasses()).append(",").append(s.getTotalClasses()).append(",");
                for (double m : s.getMarks()) {
                    sb.append(m).append(";");
                }
                writer.println(sb.toString());
            }
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }

    public static List<Student> loadStudents() {
        List<Student> list = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return list;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    Student s = new Student(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                    if (parts.length > 4 && !parts[4].isEmpty()) {
                        for (String markStr : parts[4].split(";")) {
                            if (!markStr.isBlank()) s.addMark(Double.parseDouble(markStr));
                        }
                    }
                    list.add(s);
                }
            }
        } catch (Exception e) {
            System.out.println("Notice: Could not parse past records, starting fresh.");
        }
        return list;
    }
}
