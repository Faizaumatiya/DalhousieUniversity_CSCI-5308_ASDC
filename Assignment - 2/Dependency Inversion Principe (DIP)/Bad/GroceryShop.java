public class GroceryShop {
    private DirectDebit debitCard;
    private DividenedCredit creditCard;
    public void doPurchaseDirectDebit(long amountToPay)
    {
        debitCard = new DirectDebit();
        debitCard.Transaction(amountToPay);
        System.out.println("Amount to pay: $" +amountToPay);
    }
    public void doPurchaseDividendCredit(long amountToPay)
    {
        creditCard = new DividenedCredit();
        creditCard.Transaction(amountToPay);
        System.out.println("Amount to pay: $" +amountToPay);
    }
}
