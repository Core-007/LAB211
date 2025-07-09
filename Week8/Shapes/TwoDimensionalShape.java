//Lớp con của Shape cho hình 2D

public abstract class TwoDimensionalShape extends Shape {
    // Lớp này sẽ chứa phương thức getArea() để tính diện tích của các hình 2D.
    // Phương thức này sẽ được các lớp con như Circle, Square, Triangle kế thừa và cài đặt

    @Override
    public abstract double getArea();  // Diện tích của hình 2D
}
