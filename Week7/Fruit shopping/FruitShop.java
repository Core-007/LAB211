import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FruitShop {
    private List<Fruit> fruits;
    private HashMap<String, Order> orders;

    public FruitShop() {
        fruits = new ArrayList<>();
        orders = new HashMap<>();
    }

    // Tạo sản phẩm mới
    public void createFruit(int fruitId, String fruitName, double price, int quantity, String origin) {
        fruits.add(new Fruit(fruitId, fruitName, price, quantity, origin));
    }

    // Xem danh sách trái cây
    public void showFruit() {
        System.out.println("List of Fruits: ");
        for (Fruit fruit : fruits) {
            System.out.println(fruit.toString());
        }
    }

    // Tìm sản phẩm theo tên
    public Fruit getFruitByName(String fruitName) {
        for (Fruit fruit : fruits) {
            if (fruit.getFruitName().equalsIgnoreCase(fruitName)) {
                return fruit;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }

    // Tạo đơn hàng
    public void createOrder(String customerName, ArrayList<OrderItem> orderItems) {
        Order order = new Order(customerName);
        for (OrderItem item : orderItems) {
            order.addItem(item);
        }
        orders.put(customerName, order); // Lưu đơn hàng theo tên khách hàng
    }

    // Xem đơn hàng của khách hàng
    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }

        for (Order order : orders.values()) {
            order.viewOrder();
            System.out.println("-----------------------------");
        }
    }

    // Cập nhật số lượng trái cây sau khi mua
    public void updateFruitQuantity(String fruitName, int quantity) {
        Fruit fruit = getFruitByName(fruitName);
        if (fruit != null) {
            fruit.updateQuantity(quantity);
        } else {
            System.out.println("Fruit not found!");
        }
    }
}
