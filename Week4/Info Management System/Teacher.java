public class Teacher extends Person {
    private int yearInProfession;
    private String contractType;
    private double salaryCoefficient;

    public Teacher() {
        super();
        this.yearInProfession = 0;
        this.contractType = "";
        this.salaryCoefficient = 0.0;
    }

    // Getters and Setters
    public int getYearInProfession() {
        return yearInProfession;
    }

    public String getContractType() {
        return contractType;
    }

    public double getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public void setYearInProfession(int yearInProfession) {
        this.yearInProfession = yearInProfession;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public void setSalaryCoefficient(double salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }
}
