
import java.util.*;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nWELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    do {
                        System.out.print("Enter ID: ");
                        String id = sc.nextLine();

                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter semester: ");
                        String semester = sc.nextLine();

                        System.out.print("Enter course (Java, .Net, C/C++): ");
                        String course = sc.nextLine();

                        manager.addStudent(new Student(id, name, semester, course));

                        if (manager.shouldAskToContinue()) {
                            System.out.print("Do you want to continue (Y/N)? ");
                            String ans = sc.nextLine();
                            if (!ans.equalsIgnoreCase("Y")) break;
                        }
                    } while (true);
                    break;

                case "2":
                    System.out.print("Enter student name to search: ");
                    String keyword = sc.nextLine();
                    List<Student> results = manager.findStudentsByName(keyword);
                    if (results.isEmpty()) {
                        System.out.println("No student found.");
                    } else {
                        for (Student s : results) {
                            System.out.println(s);
                        }
                    }
                    break;

                case "3":
                    System.out.print("Enter student ID to update/delete: ");
                    String id = sc.nextLine();
                    List<Student> found = manager.getStudentsById(id);
                    if (found.isEmpty()) {
                        System.out.println("No student found.");
                        break;
                    }
                    for (Student s : found) {
                        System.out.println(s);
                    }

                    System.out.print("Do you want to Update (U) or Delete (D)? ");
                    String opt = sc.nextLine();

                    if (opt.equalsIgnoreCase("U")) {
                        System.out.print("Enter new name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter new semester: ");
                        String semester = sc.nextLine();
                        System.out.print("Enter new course: ");
                        String course = sc.nextLine();
                        manager.updateStudent(found.get(0), name, semester, course);
                        System.out.println("Student updated.");
                    } else if (opt.equalsIgnoreCase("D")) {
                        manager.deleteStudent(found.get(0));
                        System.out.println("Student deleted.");
                    }
                    break;

                case "4":
                    Map<String, Map<String, Integer>> report = manager.generateReport();
                    for (String name : report.keySet()) {
                        for (String course : report.get(name).keySet()) {
                            int count = report.get(name).get(course);
                            System.out.println(name + " | " + course + " | " + count);
                        }
                    }
                    break;

                case "5":
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
