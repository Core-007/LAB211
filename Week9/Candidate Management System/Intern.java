//lớp con

public class Intern extends Candidate {
    private String majors;
    private String semester;
    private String universityName;

    public Intern(String candidateId, String firstName, String lastName, String birthDate,
                  String address, String phone, String email, int candidateType,
                  String majors, String semester, String universityName) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }
}
