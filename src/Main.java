import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyy");

        System.out.println("Enter client data:");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth date (DD/MM/YYYY): ");
        String birthDate = sc.nextLine();
        LocalDate birthdate = LocalDate.parse(birthDate, fmt1);

        Client client = new Client(name, email, birthdate);

        System.out.print("Enter order data: ");
        String orderData = sc.nextLine();
        OrderStatus ordSts = OrderStatus.valueOf(orderData);

        Order order = new Order(birthdate, ordSts);

        System.out.print("How many items to this order?");
        int n = sc.nextInt();

        double subTotal = 0;
        String orderItemStr = "";

        for (int i = 0; i < n; i++) {
            System.out.println("Enter #" + i+1 + "item data:");
            System.out.print("product name: ");
            String prodName = sc.nextLine();
            System.out.print("product price: ");
            double prodPrice = sc.nextDouble();
            System.out.print("quantity: ");
            int prodQuantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(prodQuantity, prodPrice);
            order.addItem(orderItem);
            subTotal = orderItem.subTotal(prodPrice, prodQuantity);
            orderItemStr = orderItem.toString();
            Product product = new Product(prodName, prodPrice);
        }

        System.out.println("ORDER SUMMARY:");

        System.out.print("Order moment: ");
        System.out.println(order.getMoment());

        System.out.print("Order status: ");
        System.out.println(ordSts);

        System.out.print("Client: ");
        System.out.println(client.toString());
        System.out.println();

        System.out.println("Order items:");
        for (int i = 0; i < n; i++) {
            System.out.println(orderItemStr);
        }
    }
}