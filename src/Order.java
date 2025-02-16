import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDate moment = LocalDate.now();
    private OrderStatus status;

    List<OrderItem> orderItemList = new ArrayList<>();

    public Order(LocalDate moment) {}

    public Order(LocalDate moment, OrderStatus status) {
        this.moment = moment;
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDate getMoment() {
        return moment;
    }

    public void setMoment(LocalDate moment) {
        this.moment = moment;
    }

    public void addItem(OrderItem item){
        orderItemList.add(item);
    }

    public void removeItem(OrderItem item){
        orderItemList.remove(item);
    }

    /* public double total(List<OrderItem> list){
        double total = 0;
        for (int i = 0; i < list.size(); i++) {
            total += list.get(i).subTotal();
        }
    } */

    public String toString() {
        return "Order moment: " + moment + status;

    }
}
