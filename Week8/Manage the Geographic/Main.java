import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
        int choice;

        do {
            System.out.println("MENU");
            System.out.println("==========================================================================");
            System.out.println("1. Input the information of 11 countries in East Asia");
            System.out.println("2. Display the information of country you've just input");
            System.out.println("3. Search the information of country by user-entered name");
            System.out.println("4. Display the information of countries sorted name in ascending order");
            System.out.println("5. Exit");
            System.out.println("==========================================================================");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // Đọc dòng Enter còn lại

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter code of country: ");
                        String countryCode = sc.nextLine();
                        System.out.print("Enter name of country: ");
                        String countryName = sc.nextLine();
                        System.out.print("Enter total Area: ");
                        float totalArea = sc.nextFloat();
                        sc.nextLine();  // Đọc dòng Enter còn lại
                        System.out.print("Enter terrain of country: ");
                        String countryTerrain = sc.nextLine();

                        manager.addCountryInformation(countryCode, countryName, totalArea, countryTerrain);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    manager.getRecentlyEnteredInformation();
                    break;
                case 3:
                    System.out.print("Enter the name you want to search for: ");
                    String name = sc.nextLine();
                    manager.searchInformationByName(name);
                    break;
                case 4:
                    manager.sortInformationByAscendingOrder();
                    manager.getRecentlyEnteredInformation();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
