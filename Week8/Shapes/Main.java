public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[6];
        shapes[0] = new Circle(5);       // Hình tròn với bán kính 5
        shapes[1] = new Square(4);       // Hình vuông với cạnh 4
        shapes[2] = new Triangle(6, 8);  // Hình tam giác với đáy 6 và chiều cao 8
        shapes[3] = new Sphere(3);       // Hình cầu với bán kính 3
        shapes[4] = new Cube(4);         // Hình lập phương với cạnh 4
        shapes[5] = new Tetrahedron(5);  // Hình tứ diện với cạnh 5

        // Xử lý mảng shapes
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
    }
}
