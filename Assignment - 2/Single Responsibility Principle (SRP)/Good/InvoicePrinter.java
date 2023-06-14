public class InvoicePrinter {
    private Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void printInvoice() {
        System.out.println(invoice.quantity + " x " + invoice.publishedPaper.paperTitle + "  $" + invoice.publishedPaper.cost);
        System.out.println("Discount Rate: " + invoice.discountRate+"%");
        System.out.println("Tax Rate: " + invoice.taxRate+"%");
        System.out.println("Total: $" + invoice.totalCost);
    }
}

