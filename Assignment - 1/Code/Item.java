public class Item {
    public int partnumber;
    public int quantity;

    public int getPartnumber() {
        return partnumber;
    }

    public void setPartnumber(int partnumber) {
        this.partnumber = partnumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public boolean isPartNumberValidOrNot(Database database){
       return database.isPartNumberValidOrInvalid(partnumber);
    }

    @Override
    public String toString() {
        return "Item{" +
                "partnumber='" + partnumber + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
