//chứa logic xử lý như nhập thông tin, tìm kiếm, sắp xếp...

import java.util.ArrayList;

public class ManageEastAsiaCountries {

    private ArrayList<EastAsiaCountries> countries;

    public ManageEastAsiaCountries() {
        countries = new ArrayList<>();
    }

    // Phương thức nhập thông tin cho một quốc gia
    public void addCountryInformation(String countryCode, String countryName, float totalArea, String countryTerrain) throws Exception {
        if (totalArea <= 0) {
            throw new Exception("Total area must be greater than 0.");
        }
        EastAsiaCountries country = new EastAsiaCountries(countryCode, countryName, totalArea, countryTerrain);
        countries.add(country);
    }

    // Phương thức hiển thị thông tin các quốc gia đã nhập
    public void getRecentlyEnteredInformation() {
        if (countries.isEmpty()) {
            System.out.println("No country information entered.");
            return;
        }

        for (EastAsiaCountries country : countries) {
            country.display();
        }
    }

    // Phương thức tìm kiếm quốc gia theo tên
    public void searchInformationByName(String name) {
        boolean found = false;
        for (EastAsiaCountries country : countries) {
            if (country.getCountryName().equalsIgnoreCase(name)) {
                country.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Country not found.");
        }
    }

    // Phương thức sắp xếp các quốc gia theo tên tăng dần
    public void sortInformationByAscendingOrder() {
        countries.sort((a, b) -> a.getCountryName().compareToIgnoreCase(b.getCountryName()));
    }

    // Lấy danh sách các quốc gia
    public ArrayList<EastAsiaCountries> getCountries() {
        return countries;
    }
}
