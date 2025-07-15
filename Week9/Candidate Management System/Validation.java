package logic;

public class Validation {
    public static boolean isValidBirthYear(String year) {
        return year.matches("\\d{4}") && Integer.parseInt(year) >= 1900 &&
               Integer.parseInt(year) <= java.time.Year.now().getValue();
    }

    public static boolean isValidPhone(String phone) {
        return phone.matches("\\d{10,}");
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    public static boolean isValidExpYear(int year) {
        return year >= 0 && year <= 100;
    }

    public static boolean isValidRank(String rank) {
        return rank.equalsIgnoreCase("Excellence") ||
               rank.equalsIgnoreCase("Good") ||
               rank.equalsIgnoreCase("Fair") ||
               rank.equalsIgnoreCase("Poor");
    }
}
