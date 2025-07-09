public class Person {
    protected String ID;
    protected String fullname;
    protected String phoneNumber;
    protected int yearOfBirth;
    protected String major;

    public Person() {
        this.ID = "";
        this.fullname = "";
        this.phoneNumber = "";
        this.yearOfBirth = 0;
        this.major = "";
    }

    // Getters and Setters
    public String getID() {
        return ID;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getMajor() {
        return major;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
