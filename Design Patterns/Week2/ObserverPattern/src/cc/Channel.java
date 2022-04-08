package cc;

import java.util.ArrayList;

public class Channel implements Subject{
    private String channelName;
    private String status;
    private ArrayList<Observer> observerList;

    public Channel(String channelName, String status) {
        this.channelName = channelName;
        this.status = status;
        observerList = new ArrayList<>();
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public void setStatus(String status) {
        this.status = status;
        if(status.equalsIgnoreCase("Live"))
            notifyObserver();
    }

    public String getStatus() {
        return status;
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update(getChannelName());
        }
    }
}
