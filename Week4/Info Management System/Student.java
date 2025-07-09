public class Student extends Person {
    private int yearOfAdmission;
    private int entranceEnglishScore;

    public Student() {
        super();
        this.yearOfAdmission = 0;
        this.entranceEnglishScore = 0;
    }

    // Getters and Setters
    public int getYearOfAdmission() {
        return yearOfAdmission;
    }

    public int getEntranceEnglishScore() {
        return entranceEnglishScore;
    }

    public void setYearOfAdmission(int yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }

    public void setEntranceEnglishScore(int entranceEnglishScore) {
        this.entranceEnglishScore = entranceEnglishScore;
    }
}
