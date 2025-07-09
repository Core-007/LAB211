import java.time.Year;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Teacher> teachers = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Person> allPersons = new ArrayList<>();
        PersonLogic logic = new PersonLogic();

        while (true) {
            System.out.println("*** Information Management ***");
            System.out.println("1. Teacher");
            System.out.println("2. Student");
            System.out.println("3. Person");
            System.out.println("4. Exit");
            System.out.print("You choose: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Clear buffer

            if (choice == 1) {
                System.out.println("*** Teacher Management ***");
                System.out.println("1. Input");
                System.out.println("2. Print");
                System.out.println("3. Exit");
                System.out.print("You choose: ");
                int tChoice = sc.nextInt();
                sc.nextLine();

                if (tChoice == 1) {
                    System.out.print("Enter number of teachers: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        Teacher teacher = new Teacher();
                        System.out.print("ID: ");
                        teacher.setID(sc.nextLine());
                        System.out.print("Fullname: ");
                        teacher.setFullname(sc.nextLine());
                        System.out.print("Phone: ");
                        teacher.setPhoneNumber(sc.nextLine());

                        // Kiểm tra năm sinh hợp lệ
                        System.out.print("Year of birth: ");
                        int yearOfBirth = sc.nextInt();
                        int currentYear = Year.now().getValue();  // Lấy năm hiện tại
                        if (yearOfBirth >= currentYear) {
                            System.out.println("Năm sinh không hợp lệ! Năm sinh phải nhỏ hơn năm hiện tại.");
                            return;
                        }
                        teacher.setYearOfBirth(yearOfBirth);

                        sc.nextLine(); // Clear buffer
                        System.out.print("Major: ");
                        teacher.setMajor(sc.nextLine());

                        // Kiểm tra năm làm nghề hợp lệ
                        System.out.print("Year in profession: ");
                        teacher.setYearInProfession(sc.nextInt());
                        if (teacher.getYearInProfession() >= (currentYear - teacher.getYearOfBirth())) {
                            System.out.println("Năm làm nghề không hợp lệ! Năm làm nghề phải nhỏ hơn tuổi.");
                            return;
                        }

                        sc.nextLine(); // Clear buffer
                        System.out.print("Contract type (Long/Short): ");
                        teacher.setContractType(sc.nextLine());

                        System.out.print("Salary coefficient: ");
                        teacher.setSalaryCoefficient(sc.nextDouble());
                        sc.nextLine(); // Clear buffer
                        teachers.add(teacher);
                    }
                } else if (tChoice == 2) {
                    logic.sortTeachersByYearInProfession(teachers);
                    logic.printTeachers(teachers);
                } else if (tChoice == 3) {
                    continue;
                }
            } else if (choice == 2) {
                // Quản lý sinh viên
            } else if (choice == 3) {
                // Quản lý tất cả người
            } else if (choice == 4) {
                break;
            }
        }
    }
}
