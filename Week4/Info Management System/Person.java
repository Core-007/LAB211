package Week4.PersonManagement;

import java.time.Year;
import java.util.Scanner;

public class Person {
    protected String id, fullName, phone, major;
    protected int yearOfBirth;

    public Person() {
        id = fullName = phone = major = "";
        yearOfBirth = 0;
    }

    public void inputAll(Scanner sc) {
        System.out.print("ID (6 digits): ");
        id = sc.nextLine();
        if (!id.matches("\\d{6}")) throw new IllegalArgumentException("Data input is invalid");

        System.out.print("Full name: ");
        fullName = sc.nextLine();
        if (!fullName.matches("[a-zA-Z ]+")) throw new IllegalArgumentException("Data input is invalid");

        System.out.print("Phone (12 digits): ");
        phone = sc.nextLine();
        if (!phone.matches("\\d{12}")) throw new IllegalArgumentException("Data input is invalid");

        System.out.print("Year of birth: ");
        yearOfBirth = Integer.parseInt(sc.nextLine());
        if (yearOfBirth >= Year.now().getValue()) throw new IllegalArgumentException("Data input is invalid");

        System.out.print("Major: ");
        major = sc.nextLine();
        if (major.length() > 30) throw new IllegalArgumentException("Data input is invalid");
    }

    public String getFullName() { return fullName; }
    public int getYearOfBirth() { return yearOfBirth; }

    public void printBasic() {
        System.out.printf("%s - %s - %s - %d - %s\n", id, fullName, phone, yearOfBirth, major);
    }
}
