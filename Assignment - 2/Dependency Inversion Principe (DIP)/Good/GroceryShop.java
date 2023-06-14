public class GroceryShop {
    private IBankCardPayment bankCard ;
    public GroceryShop(IBankCardPayment bankCard)
    {
        this.bankCard = bankCard;
    }
    public void doPurchase(long amountToPay)
    {
        bankCard.Transaction(amountToPay);
        System.out.println("Amount to pay: $" +amountToPay);
    }
}
