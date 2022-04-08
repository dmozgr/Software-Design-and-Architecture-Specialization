package cc;

public class Follower implements Observer{
    private String followerName;

    public Follower(String followerName) {
        this.followerName = followerName;
    }

    @Override
    public void update(String string) {
        System.out.println(followerName+", "+string +"  is live now..");
        play();
    }

    public void play()
    {
        System.out.println("Channel is playing");
    }
}
