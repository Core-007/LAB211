public class Fruit {
    private int fruitId;
    private String fruitName;
    private double price;
    private int quantity;
    private String origin;

    public Fruit(int fruitId, String fruitName, double price, int quantity, String origin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public int getFruitId() {
        return fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Fruit{" + "fruitId=" + fruitId + ", fruitName='" + fruitName + "', price=" + price + ", quantity=" + quantity + ", origin='" + origin + "'}";
    }

    // Cập nhật số lượng trái cây sau khi bán
    public void updateQuantity(int quantity) {
        this.quantity -= quantity;
    }
}
