//Lớp con của Course
public class OfflineCourse extends Course {
    private String begin;
    private String end;
    private String campus;

    public OfflineCourse(String courseID, String courseName, int credits, String begin, String end, String campus) {
        super(courseID, courseName, credits);
        this.begin = begin;
        this.end = end;
        this.campus = campus;
    }

    // Getter methods
    public String getBegin() {
        return begin;
    }

    public String getEnd() {
        return end;
    }

    public String getCampus() {
        return campus;
    }
}
