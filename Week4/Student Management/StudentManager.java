import java.util.*;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public boolean shouldAskToContinue() {
        return students.size() >= 3;
    }

    public List<Student> findStudentsByName(String keyword) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(s);
            }
        }
        result.sort(Comparator.comparing(Student::getName));
        return result;
    }

    public List<Student> getStudentsById(String id) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                result.add(s);
            }
        }
        return result;
    }

    public void updateStudent(Student s, String newName, String newSemester, String newCourse) {
        s.setName(newName);
        s.setSemester(newSemester);
        s.setCourseName(newCourse);
    }

    public void deleteStudent(Student s) {
        students.remove(s);
    }

    public Map<String, Map<String, Integer>> generateReport() {
        Map<String, Map<String, Integer>> report = new LinkedHashMap<>();
        for (Student s : students) {
            report
                .computeIfAbsent(s.getName(), k -> new HashMap<>())
                .merge(s.getCourseName(), 1, Integer::sum);
        }
        return report;
    }
}
