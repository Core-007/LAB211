public class Experience extends Candidate {
    private int expInYear;
    private String proSkill;

    public Experience(String candidateId, String firstName, String lastName, String birthDate,
                      String address, String phone, String email, int candidateType,
                      int expInYear, String proSkill) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }
}
