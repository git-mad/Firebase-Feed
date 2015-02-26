package org.gitmad.firebasefeed.models;

/**
 * Created by Brian on 2/25/2015.
 */
public class Post {

    private String text;
    private int id;
    private int upvotes;

    public Post(String text, int id, int upvotes) {
        this.text = text;
        this.id = id;
        this.upvotes = upvotes;
    }

    public void upvote() {
        upvotes++;
    }


    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public int getUpvotes() {
        return upvotes;
    }
}
