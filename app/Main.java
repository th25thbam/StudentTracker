package app;

import exception.InvalidScoreException;
import model.Student;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== STUDENT TRACKER MENU ===");
            System.out.println("1. Add New Student");
            System.out.println("2. Enter Marks for Student");
            System.out.println("3. Display Summary Report");
            System.out.println("4. Exit");
            System.out.print("Enter choice (1-4): ");

            String input = sc.nextLine().trim();
            switch (input) {
                case "1":
                    System.out.print("Enter Student ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Attended Classes: ");
                    int attended = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Total Classes: ");
                    int total = Integer.parseInt(sc.nextLine());
                    service.addStudent(id, name, attended, total);
                    System.out.println("Student recorded.");
                    break;

                case "2":
                    System.out.print("Enter Student ID: ");
                    String sId = sc.nextLine();
                    System.out.print("Enter Mark (0-100): ");
                    try {
                        double mark = Double.parseDouble(sc.nextLine());
                        service.addMarkToStudent(sId, mark);
                        System.out.println("Mark added successfully.");
                    } catch (NumberFormatException e) {
                        System.out.println("Input must be a valid number.");
                    } catch (InvalidScoreException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "3":
                    service.displaySummaryReport();
                    break;

                case "4":
                    System.out.println("Saving and exiting.");
                    return;

                default:
                    System.out.println("Invalid selection. Try again.");
            }
            sc.close();
        }
    }
}
