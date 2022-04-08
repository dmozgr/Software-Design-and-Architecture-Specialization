package cc;

import java.util.ArrayList;

public class Playlist implements IComponent{
    public String playlistName;
    public ArrayList<IComponent> playlist = new ArrayList();

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
    }

    public void add(IComponent component)
    {
        playlist.add(component);
    }
    public void remove(IComponent component)
    {
        playlist.remove(component);
    }
    @Override
    public void play() {
        for(IComponent component : playlist)
        {
            component.play();
        }
    }

    @Override
    public void setPlaybackSpeed(float speed) {
        for(IComponent component : playlist)
        {
            component.setPlaybackSpeed(speed);
        }
    }

    @Override
    public String getName() {
        return playlistName;
    }
}
