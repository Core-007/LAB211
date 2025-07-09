// hình lập phương

public class Cube extends ThreeDimensionalShape {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return 6 * side * side;  // Công thức diện tích hình lập phương
    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3);  // Công thức thể tích hình lập phương
    }
}
