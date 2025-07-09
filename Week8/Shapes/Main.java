import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mảng chứa các đối tượng Shape
        Shape[] shapes = new Shape[6];

        // Nhập thông tin cho các hình học
        System.out.println("Enter details for Circle:");
        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();
        shapes[0] = new Circle(radius);  // Hình tròn với bán kính nhập từ người dùng

        System.out.println("Enter details for Square:");
        System.out.print("Enter side length: ");
        double side = scanner.nextDouble();
        shapes[1] = new Square(side);  // Hình vuông với cạnh nhập từ người dùng

        System.out.println("Enter details for Triangle:");
        System.out.print("Enter base length: ");
        double base = scanner.nextDouble();
        System.out.print("Enter height: ");
        double height = scanner.nextDouble();
        shapes[2] = new Triangle(base, height);  // Hình tam giác với đáy và chiều cao nhập từ người dùng

        System.out.println("Enter details for Sphere:");
        System.out.print("Enter radius: ");
        radius = scanner.nextDouble();
        shapes[3] = new Sphere(radius);  // Hình cầu với bán kính nhập từ người dùng

        System.out.println("Enter details for Cube:");
        System.out.print("Enter side length: ");
        side = scanner.nextDouble();
        shapes[4] = new Cube(side);  // Hình lập phương với cạnh nhập từ người dùng

        System.out.println("Enter details for Tetrahedron:");
        System.out.print("Enter edge length: ");
        double edgeLength = scanner.nextDouble();
        shapes[5] = new Tetrahedron(edgeLength);  // Hình tứ diện với cạnh nhập từ người dùng

        // Hiển thị thông tin về các hình học
        for (Shape shape : shapes) {
            System.out.println("Shape: " + shape.getClass().getSimpleName());
            if (shape instanceof TwoDimensionalShape) {
                System.out.println("Area: " + shape.getArea());
            } else if (shape instanceof ThreeDimensionalShape) {
                System.out.println("Area: " + shape.getArea());
                System.out.println("Volume: " + shape.getVolume());
            }
            System.out.println();
        }

        scanner.close();
    }
}
