public class Invoice {
    PublishedPaper publishedPaper;
    int quantity;
    double discountRate;
    double taxRate;
    double totalCost;

    public void invoice(PublishedPaper publishedPaper, int quantity, double discountRate, double taxRate) {
        this.publishedPaper = publishedPaper;
        this.quantity = quantity;
        this.discountRate = discountRate;
        this.taxRate = taxRate;
        this.totalCost = this.calculateTotalCost();
    }
    public double calculateTotalCost() {
        double price = (publishedPaper.cost - (publishedPaper.cost * discountRate/100))* this.quantity;
        double priceWithTaxes = price * (1 + (taxRate/100));
        return priceWithTaxes;
    }
}
