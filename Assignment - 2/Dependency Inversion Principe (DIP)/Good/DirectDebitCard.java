public class DirectDebitCard implements IBankCardPayment {
    public void Transaction(long amountToPay)
    {
        System.out.println("Payment using Debit Card");
    }

}
