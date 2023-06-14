public class PublishedPaper {
    String paperTitle;
    String authorName;
    int yearOfPublish;
    int cost;
    int isbnNumber;
    //constructor with a parameter
    public PublishedPaper(String paperTitle, String authorName, int yearOfPublish, int cost, int isbnNumber)
    {
        //this keyword refers to current object in the constructor or method
        this.paperTitle = paperTitle;
        this.authorName = authorName;
        this.yearOfPublish = yearOfPublish;
        this.cost = cost;
        this.isbnNumber = isbnNumber;
    }
}
