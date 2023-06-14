public class Main {
    public static void main(String[] args) {
        PublishedPaper b = new PublishedPaper("Factors affecting lung function", "Faiza Umatiya", 2018, 5000, 4958372);
        Invoice in = new Invoice();
        in.invoice(b, 2, 10, 15 );
        in.calculateTotalCost();
        in.printInvoice();
        in.saveToFile("srp.txt", in);
    }
}
