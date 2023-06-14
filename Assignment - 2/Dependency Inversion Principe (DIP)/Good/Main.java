public class Main {
    public static void main(String[] args) {
        IBankCardPayment bankCard = new DividenedCreditCard();
        GroceryShop groceryShop= new GroceryShop(bankCard);
        groceryShop.doPurchase(80000);
    }
}
