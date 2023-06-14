public class WhatsApp implements ISocialMedia{
    @Override
    public void addPost(int posts) {
        System.out.println("Adding "+posts+" post!");
    }
    @Override
    public void watchVideos(int videos) {
        System.out.println("Currently binging "+videos+" videos!");
    }
    @Override
    public void watchStories(int stories) {
        System.out.println("watching "+stories+" short stories!");
    }
}

