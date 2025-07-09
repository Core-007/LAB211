//Lớp con của Course
public class OnlineCourse extends Course {
    private String platform;
    private String instructors;
    private String note;

    public OnlineCourse(String courseID, String courseName, int credits, String platform, String instructors, String note) {
        super(courseID, courseName, credits);
        this.platform = platform;
        this.instructors = instructors;
        this.note = note;
    }

    // Getter methods
    public String getPlatform() {
        return platform;
    }

    public String getInstructors() {
        return instructors;
    }

    public String getNote() {
        return note;
    }
}
