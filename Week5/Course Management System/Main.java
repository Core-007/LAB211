import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseManager manager = new CourseManager();

        while (true) {
            System.out.println("*** Course Management ***");
            System.out.println("1. Add online course / offline course");
            System.out.println("2. Update course");
            System.out.println("3. Delete course");
            System.out.println("4. Print all courses");
            System.out.println("5. Search course by name");
            System.out.println("6. Exit");
            System.out.print("You choose: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Clear the buffer

            switch (choice) {
                case 1:
                    System.out.print("Online (O) or Offline (F): ");
                    String type = sc.nextLine();
                    if (type.equalsIgnoreCase("O")) {
                        addOnlineCourse(manager, sc);
                    } else if (type.equalsIgnoreCase("F")) {
                        addOfflineCourse(manager, sc);
                    } else {
                        System.out.println("Invalid option. Please choose 'O' or 'F'.");
                    }
                    break;

                case 2:
                    System.out.print("Enter course ID to update: ");
                    String updateID = sc.nextLine();
                    updateCourse(manager, updateID, sc);
                    break;

                case 3:
                    System.out.print("Enter course ID to delete: ");
                    String deleteID = sc.nextLine();
                    deleteCourse(manager, deleteID);
                    break;

                case 4:
                    manager.printAllCourses();
                    break;

                case 5:
                    System.out.print("Enter course name to search: ");
                    String searchName = sc.nextLine();
                    Course course = manager.searchCourseByName(searchName);
                    if (course != null) {
                        System.out.println("Course ID: " + course.getCourseID());
                        System.out.println("Course Name: " + course.getCourseName());
                        System.out.println("Credits: " + course.getCredits());
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case 6:
                    System.out.println("BYE AND SEE YOU NEXT TIME");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Phương thức để thêm khóa học Online
    private static void addOnlineCourse(CourseManager manager, Scanner sc) {
        System.out.println("Enter online course details:");

        System.out.print("Course ID: ");
        String courseID = sc.nextLine();

        System.out.print("Course Name: ");
        String courseName = sc.nextLine();

        System.out.print("Credits: ");
        int credits = sc.nextInt();
        sc.nextLine();  // Clear the buffer

        System.out.print("Platform: ");
        String platform = sc.nextLine();

        System.out.print("Instructors: ");
        String instructors = sc.nextLine();

        System.out.print("Note: ");
        String note = sc.nextLine();

        OnlineCourse onlineCourse = new OnlineCourse(courseID, courseName, credits, platform, instructors, note);
        manager.addCourse(onlineCourse);
        System.out.println("Online course added successfully.");
    }

    // Phương thức để thêm khóa học Offline
    private static void addOfflineCourse(CourseManager manager, Scanner sc) {
        System.out.println("Enter offline course details:");

        System.out.print("Course ID: ");
        String courseID = sc.nextLine();

        System.out.print("Course Name: ");
        String courseName = sc.nextLine();

        System.out.print("Credits: ");
        int credits = sc.nextInt();
        sc.nextLine();  // Clear the buffer

        System.out.print("Begin (MM/dd/yyyy): ");
        String begin = sc.nextLine();

        System.out.print("End (MM/dd/yyyy): ");
        String end = sc.nextLine();

        System.out.print("Campus: ");
        String campus = sc.nextLine();

        OfflineCourse offlineCourse = new OfflineCourse(courseID, courseName, credits, begin, end, campus);
        manager.addCourse(offlineCourse);
        System.out.println("Offline course added successfully.");
    }

    // Phương thức để cập nhật khóa học
    private static void updateCourse(CourseManager manager, String courseID, Scanner sc) {
        Course course = manager.getCourseByID(courseID);
        if (course != null) {
            System.out.println("Updating course: " + course.getCourseName());
            System.out.print("New Course Name: ");
            String newName = sc.nextLine();
            System.out.print("New Credits: ");
            int newCredits = sc.nextInt();
            sc.nextLine();  // Clear the buffer

            course = new Course(courseID, newName, newCredits);  // Cập nhật thông tin khóa học
            System.out.println("Course updated successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    // Phương thức để xóa khóa học
    private static void deleteCourse(CourseManager manager, String courseID) {
        boolean deleted = manager.deleteCourse(courseID);
        if (deleted) {
            System.out.println("Course deleted successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }
}
