// hình tứ diện

public class Tetrahedron extends ThreeDimensionalShape {
    private double edgeLength;

    public Tetrahedron(double edgeLength) {
        this.edgeLength = edgeLength;
    }

    @Override
    public double getArea() {
        return Math.sqrt(3) * edgeLength * edgeLength;  // Công thức diện tích hình tứ diện
    }

    @Override
    public double getVolume() {
        return (Math.sqrt(2) / 12.0) * Math.pow(edgeLength, 3);  // Công thức thể tích hình tứ diện
    }
}
