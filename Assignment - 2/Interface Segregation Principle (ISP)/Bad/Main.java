public class Main {
    public static void main(String[] args) {
        Facebook facebook = new Facebook();
        facebook.addPost(2);
        Youtube youtube = new Youtube();
        youtube.watchVideos(5);
        youtube.doLikeandShare(3,6);
        youtube.doSubscriptions(1);
        WhatsApp whatsApp = new WhatsApp();
        whatsApp.watchStories(10);
    }
}
