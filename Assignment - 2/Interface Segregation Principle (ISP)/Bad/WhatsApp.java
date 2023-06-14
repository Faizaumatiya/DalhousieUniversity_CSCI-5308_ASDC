public class WhatsApp implements ISocialMedia{
    @Override
    public void addPost(int posts) {
        System.out.println("Adding "+posts+" post!");
    }
    @Override
    public void watchVideos(int videos) {
        System.out.println("Currently binginig "+videos+"  videos!");
    }
    @Override
    public void watchStories(int stories) {
        System.out.println("Watching "+stories+" short stories!");
    }
    @Override
    public void doSubscriptions(int subscribes) {
        // do nothing method
    }
    @Override
    public void doLikeandShare(int likes, int shares) {
        // do nothing method
    }
}

