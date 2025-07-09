//Chứa các phương thức xử lý logic
import java.util.*;

public class CourseManager {
    private List<Course> courses;

    public CourseManager() {
        this.courses = new ArrayList<>();
    }

    // Thêm khóa học
    public void addCourse(Course course) {
        this.courses.add(course);
    }

    // Cập nhật khóa học
    public Course getCourseByID(String courseID) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        return null;
    }

    // Xóa khóa học
    public boolean deleteCourse(String courseID) {
        return courses.removeIf(course -> course.getCourseID().equals(courseID));
    }

    // In tất cả khóa học
    public void printAllCourses() {
        for (Course course : courses) {
            System.out.println(course.getCourseID() + " - " + course.getCourseName() + " - " + course.getCredits() + " credits");
        }
    }

    // Tìm kiếm khóa học theo tên
    public Course searchCourseByName(String name) {
        for (Course course : courses) {
            if (course.getCourseName().equalsIgnoreCase(name)) {
                return course;
            }
        }
        return null;
    }
}
