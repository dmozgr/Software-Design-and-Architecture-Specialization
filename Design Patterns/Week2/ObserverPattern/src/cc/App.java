package cc;

public class App {
    public static void main(String[] args) {
        Channel channel = new Channel("Ahmet Aga","Liveness");
        Channel channel1 = new Channel("Burak Oyunda","Liveness");
        Follower follower = new Follower("Umut Ozgur");
        channel.registerObserver(follower);
        channel1.registerObserver(follower);
        channel.setStatus("Live");
        channel1.setStatus("Live");
    }
}
