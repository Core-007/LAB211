// kế thừa từ Country

public class EastAsiaCountries extends Country {
    private String countryTerrain;

    // Constructor có tham số
    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);  // Gọi constructor của lớp cha
        this.countryTerrain = countryTerrain;
    }

    // Getter và Setter cho thuộc tính countryTerrain
    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    // Ghi đè phương thức display để hiển thị đầy đủ thông tin
    @Override
    public void display() {
        super.display(); // Gọi phương thức display() của lớp cha
        System.out.println("Terrain: " + countryTerrain);
    }
}
