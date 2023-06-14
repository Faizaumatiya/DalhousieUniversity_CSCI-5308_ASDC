public class Main
{
        public static void main(String[] args)
        {
                PublishedPaper b = new PublishedPaper("Factors affecting Lung Function", "Faiza Umatiya", 2018, 5000, 4958372);
                Invoice in = new Invoice();
                in.invoice(b, 2, 10, 15);
                in.calculateTotalCost();
                InvoicePrinter ip = new InvoicePrinter(in);
                ip.printInvoice();
                InvoicePersistenceLayer ps = new InvoicePersistenceLayer(in);
                ps.saveToFile("srp.txt" , in);
        }
}
