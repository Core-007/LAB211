public class Student {
    private String id;
    private String studentName;
    private String semester;
    private String courseName;

    public Student(String id, String studentName, String semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() { return id; }
    public String getStudentName() { return studentName; }
    public String getSemester() { return semester; }
    public String getCourseName() { return courseName; }

    public void setStudentName(String studentName) { this.studentName = studentName; }
    public void setSemester(String semester) { this.semester = semester; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    @Override
    public String toString() {
        return id + " | " + studentName + " | " + semester + " | " + courseName;
    }
}
