import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class InvoicePersistenceLayer {
    Invoice invoice;

    public InvoicePersistenceLayer(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToFile(String filename, Invoice invoice) {
        //create a file to save and write the invoice
        try {
            File file = new File(filename);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("Published Paper: "+ invoice.publishedPaper.paperTitle+"\n"+"Total cost: $" +invoice.totalCost);
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Error in saveToFile method");
        }
    }
}
