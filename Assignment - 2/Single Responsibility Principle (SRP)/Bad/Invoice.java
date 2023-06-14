import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Invoice {
    private PublishedPaper publishedPaper;
    private int quantity;
    private double discountRate;
    private double taxRate;
    private double totalCost;

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
    public void printInvoice() {
        System.out.println(quantity + " x " + publishedPaper.paperTitle + " " + "costs for $"+publishedPaper.cost);
        System.out.println("Discount Rate: " + discountRate+"%");
        System.out.println("TaxRate: " + taxRate+"%");
        System.out.println("Total Cost: $" + totalCost);
    }
    //create a file to save and write the invoice
    public void saveToFile(String filename, Invoice invoice) {
        try
        {
            File file = new File(filename);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("Published Paper: "+ publishedPaper.paperTitle+"\n"+"Total cost is: $" +invoice.totalCost);
            printWriter.close();
        }
        catch (IOException e) {
            System.out.println("Error in saveToFile method");
        }
    }
}
