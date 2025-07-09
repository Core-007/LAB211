public class Country {
    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    // Constructor không tham số
    public Country() {
        this.countryCode = "";
        this.countryName = "";
        this.totalArea = 0;
    }

    // Constructor có tham số
    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    // Setters và Getters
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    // Phương thức hiển thị thông tin
    public void display() {
        System.out.println("ID: " + countryCode + " Name: " + countryName + " Total Area: " + totalArea);
    }
}
