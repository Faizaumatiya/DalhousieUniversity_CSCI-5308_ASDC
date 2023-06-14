import java.util.List;

public class Order {
    // objects of class
   public Dealer dealer;
    public List<Item> orderitems;
    public DeliveryAddress deliveryaddress;

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public List<Item> getOrderItems() {
        return orderitems;
    }

    public void setOrderitems(List<Item> orderitems) {
        this.orderitems = orderitems;
    }

    public DeliveryAddress getDeliveryaddress() {
        return deliveryaddress;
    }

    public void setDeliveryaddress(DeliveryAddress deliveryaddress) {
        this.deliveryaddress = deliveryaddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "dealer=" + dealer +
                ", orderitems=" + orderitems +
                ", deliveryaddress=" + deliveryaddress +
                '}';
    }
}


