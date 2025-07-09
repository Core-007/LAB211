import java.util.*;

public class PersonLogic {
    // Sắp xếp danh sách giáo viên theo năm làm nghề (desc)
    public void sortTeachersByYearInProfession(List<Teacher> teachers) {
        teachers.sort(Comparator.comparingInt(Teacher::getYearInProfession).reversed());
    }

    // Sắp xếp danh sách sinh viên theo năm nhập học (asc)
    public void sortStudentsByYearOfAdmission(List<Student> students) {
        students.sort(Comparator.comparingInt(Student::getYearOfAdmission));
    }

    // Tìm kiếm người theo tên
    public List<Person> searchPersonByName(List<Person> people, String name) {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (person.getFullname().toLowerCase().contains(name.toLowerCase())) {
                result.add(person);
            }
        }
        return result;
    }

    // In danh sách giáo viên
    public void printTeachers(List<Teacher> teachers) {
        System.out.println("# - ID - Fullname - Phone number - Year of birth - Major - Year in the profession - Contract type - Salary coefficient");
        for (int i = 0; i < teachers.size(); i++) {
            Teacher teacher = teachers.get(i);
            System.out.println((i + 1) + " - " + teacher.getID() + " - " + teacher.getFullname() + " - " +
                    teacher.getPhoneNumber() + " - " + teacher.getYearOfBirth() + " - " + teacher.getMajor() + " - " +
                    teacher.getYearInProfession() + " - " + teacher.getContractType() + " - " + teacher.getSalaryCoefficient());
        }
    }

    // In danh sách sinh viên
    public void printStudents(List<Student> students) {
        System.out.println("# - ID - Fullname - Phone number - Year of birth - Major - Year of admission - Entrance English score");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println((i + 1) + " - " + student.getID() + " - " + student.getFullname() + " - " +
                    student.getPhoneNumber() + " - " + student.getYearOfBirth() + " - " + student.getMajor() + " - " +
                    student.getYearOfAdmission() + " - " + student.getEntranceEnglishScore());
        }
    }

    // In tất cả các person (cả teacher và student)
    public void printAllPersons(List<Person> persons) {
        System.out.println("# - ID - Fullname - Phone number - Year of birth - Major");
        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            System.out.println((i + 1) + " - " + person.getID() + " - " + person.getFullname() + " - " +
                    person.getPhoneNumber() + " - " + person.getYearOfBirth() + " - " + person.getMajor());
        }
    }
}
