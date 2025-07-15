package main;

import entity.*;
import logic.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CandidateManager manager = new CandidateManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nCANDIDATE MANAGEMENT SYSTEM");
            System.out.println("1. Experience\n2. Fresher\n3. Internship\n4. Searching\n5. Exit");
            System.out.print("Please choose: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> createExperience(sc, manager);
                case 2 -> createFresher(sc, manager);
                case 3 -> createIntern(sc, manager);
                case 4 -> searchCandidate(sc, manager);
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
            }
        }
    }

    private static void createExperience(Scanner sc, CandidateManager manager) {
        while (true) {
            System.out.print("Enter Candidate ID: ");
            String id = sc.nextLine();
            System.out.print("First Name: ");
            String firstName = sc.nextLine();
            System.out.print("Last Name: ");
            String lastName = sc.nextLine();
            System.out.print("Birth Year: ");
            String birthDate = sc.nextLine();
            while (!Validation.isValidBirthYear(birthDate)) {
                System.out.print("Invalid year. Try again: ");
                birthDate = sc.nextLine();
            }
            System.out.print("Address: ");
            String address = sc.nextLine();
            System.out.print("Phone: ");
            String phone = sc.nextLine();
            while (!Validation.isValidPhone(phone)) {
                System.out.print("Invalid phone. Try again: ");
                phone = sc.nextLine();
            }
            System.out.print("Email: ");
            String email = sc.nextLine();
            while (!Validation.isValidEmail(email)) {
                System.out.print("Invalid email. Try again: ");
                email = sc.nextLine();
            }
            System.out.print("Years of Experience: ");
            int expYear = Integer.parseInt(sc.nextLine());
            while (!Validation.isValidExpYear(expYear)) {
                System.out.print("Invalid experience. Try again: ");
                expYear = Integer.parseInt(sc.nextLine());
            }
            System.out.print("Professional Skill: ");
            String proSkill = sc.nextLine();

            manager.addCandidate(new Experience(id, firstName, lastName, birthDate,
                    address, phone, email, 0, expYear, proSkill));

            System.out.print("Do you want to continue (Y/N)? ");
            if (!sc.nextLine().equalsIgnoreCase("Y")) break;
        }

        manager.displayGroupedCandidates();
    }

    private static void createFresher(Scanner sc, CandidateManager manager) {
    while (true) {
        System.out.print("Enter Candidate ID: ");
        String id = sc.nextLine();
        System.out.print("First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Birth Year: ");
        String birthDate = sc.nextLine();
        while (!Validation.isValidBirthYear(birthDate)) {
            System.out.print("Invalid year. Try again: ");
            birthDate = sc.nextLine();
        }
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        while (!Validation.isValidPhone(phone)) {
            System.out.print("Invalid phone. Try again: ");
            phone = sc.nextLine();
        }
        System.out.print("Email: ");
        String email = sc.nextLine();
        while (!Validation.isValidEmail(email)) {
            System.out.print("Invalid email. Try again: ");
            email = sc.nextLine();
        }

        System.out.print("Graduation Date: ");
        String graduationDate = sc.nextLine();
        System.out.print("Graduation Rank (Excellence, Good, Fair, Poor): ");
        String graduationRank = sc.nextLine();
        while (!Validation.isValidRank(graduationRank)) {
            System.out.print("Invalid rank. Try again: ");
            graduationRank = sc.nextLine();
        }
        System.out.print("Education (University): ");
        String education = sc.nextLine();

        manager.addCandidate(new Fresher(id, firstName, lastName, birthDate, address,
                phone, email, 1, graduationDate, graduationRank, education));

        System.out.print("Do you want to continue (Y/N)? ");
        if (!sc.nextLine().equalsIgnoreCase("Y")) break;
    }

    manager.displayGroupedCandidates();
}


   private static void createIntern(Scanner sc, CandidateManager manager) {
    while (true) {
        System.out.print("Enter Candidate ID: ");
        String id = sc.nextLine();
        System.out.print("First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Birth Year: ");
        String birthDate = sc.nextLine();
        while (!Validation.isValidBirthYear(birthDate)) {
            System.out.print("Invalid year. Try again: ");
            birthDate = sc.nextLine();
        }
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        while (!Validation.isValidPhone(phone)) {
            System.out.print("Invalid phone. Try again: ");
            phone = sc.nextLine();
        }
        System.out.print("Email: ");
        String email = sc.nextLine();
        while (!Validation.isValidEmail(email)) {
            System.out.print("Invalid email. Try again: ");
            email = sc.nextLine();
        }

        System.out.print("Majors: ");
        String majors = sc.nextLine();
        System.out.print("Semester: ");
        String semester = sc.nextLine();
        System.out.print("University Name: ");
        String university = sc.nextLine();

        manager.addCandidate(new Intern(id, firstName, lastName, birthDate, address,
                phone, email, 2, majors, semester, university));

        System.out.print("Do you want to continue (Y/N)? ");
        if (!sc.nextLine().equalsIgnoreCase("Y")) break;
    }

    manager.displayGroupedCandidates();
}


    private static void searchCandidate(Scanner sc, CandidateManager manager) {
        manager.displayGroupedCandidates();

        System.out.print("Input Candidate name (First name or Last name): ");
        String name = sc.nextLine();
        System.out.print("Input type of candidate (0: Experience, 1: Fresher, 2: Intern): ");
        int type = Integer.parseInt(sc.nextLine());

        var found = manager.search(name, type);
        System.out.println("The candidates found:");
        for (Candidate c : found) {
            System.out.println(c);
        }
    }
}
