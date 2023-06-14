public class Youtube implements ISocialMedia{
    @Override
    public void addPost(int posts) {
        System.out.println("Adding "+posts+" post!");
    }
    @Override
    public void watchVideos(int videos) {
        System.out.println("Currently binging "+videos+" videos!");
    }
    @Override
    public void doSubscriptions(int subscribes) {
        System.out.println("Subscribed to "+subscribes+" channel!");
    }
    @Override
    public void watchStories(int stories) {
        System.out.println("watching "+stories+ "short stories!");
    }
    @Override
    public void doLikeandShare(int likes, int shares) {
        System.out.println("Gave "+likes+" like  and "+shares+" shared!");
    }
}
