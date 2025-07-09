//main

import java.util.ArrayList;
import java.util.Scanner;

public class FruitShopManagementSystem {

    public static void main(String[] args) {
        FruitShop shop = new FruitShop();
        Scanner sc = new Scanner(System.in);

        // Tạo sản phẩm
        shop.createFruit(1, "Apple", 1.0, 100, "USA");
        shop.createFruit(2, "Mango", 2.0, 50, "India");
        shop.createFruit(3, "Banana", 0.5, 200, "Vietnam");

        // Menu chính
        while (true) {
            System.out.println("FRUIT SHOP SYSTEM");
            System.out.println("1. Create Fruit");
            System.out.println("2. View Orders");
            System.out.println("3. Shopping (for Buyer)");
            System.out.println("4. Exit");
            System.out.print("Please choose an option (1-4): ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:  // Tạo sản phẩm
                    System.out.print("Enter Fruit ID: ");
                    int fruitId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Fruit Name: ");
                    String fruitName = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Origin: ");
                    String origin = sc.nextLine();

                    shop.createFruit(fruitId, fruitName, price, quantity, origin);
                    break;

                case 2:  // Xem đơn hàng
                    shop.viewOrders();
                    break;

                case 3:  // Mua sắm
                    System.out.println("List of Fruits:");
                    shop.showFruit();

                    ArrayList<OrderItem> orderItems = new ArrayList<>();
                    System.out.print("Enter Fruit Name to order: ");
                    String productName = sc.nextLine();
                    Fruit fruit = shop.getFruitByName(productName);

                    if (fruit != null) {
                        System.out.print("Enter Quantity: ");
                        int orderQuantity = sc.nextInt();
                        sc.nextLine(); // consume newline

                        // Kiểm tra số lượng có đủ không
                        if (fruit.getQuantity() < orderQuantity) {
                            System.out.println("Not enough stock!");
                        } else {
                            // Thêm vào giỏ hàng
                            OrderItem item = new OrderItem(fruit.getFruitName(), orderQuantity, fruit.getPrice());
                            orderItems.add(item);
                            shop.updateFruitQuantity(fruit.getFruitName(), orderQuantity);  // Cập nhật số lượng trái cây

                            System.out.print("Do you want to order now (Y/N)? ");
                            String orderNow = sc.nextLine();
                            if (orderNow.equalsIgnoreCase("Y")) {
                                System.out.print("Enter your name: ");
                                String customerName = sc.nextLine();
                                shop.createOrder(customerName, orderItems);
                                System.out.println("Order successfully placed!");
                            }
                        }
                    } else {
                        System.out.println("Fruit not found!");
                    }
                    break;

                case 4:  // Thoát
                    System.out.println("Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
