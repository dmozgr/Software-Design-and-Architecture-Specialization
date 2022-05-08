package com.example.sharingapp;

import android.content.Context;

import java.util.concurrent.ExecutionException;

/**
 * Command to delete a bid
 */
public class DeleteBidCommand extends Command {

    private Bid bid;

    public DeleteBidCommand(Bid bid) {
        this.bid = bid;
    }

    // Delete the item remotely from server
    public void execute() {
        ElasticSearchManager.RemoveBidTask removeBidTask = new ElasticSearchManager.RemoveBidTask();
        removeBidTask.execute(bid);

        // use get() to access the return of RemoveItemTask. i.e. RemoveItemTask returns a Boolean to
        // indicate if the item was successfully deleted from the remote server
        try {
            if(removeBidTask.get()) {
                super.setIsExecuted(true);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            super.setIsExecuted(false);
        }
    }

   /* // Delete bid locally
    public void execute(){
        bid_list.removeBid(bid);
        super.setIsExecuted(bid_list.saveBids(context));
    }*/
}