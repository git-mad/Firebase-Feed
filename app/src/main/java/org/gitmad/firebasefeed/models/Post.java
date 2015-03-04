package org.gitmad.firebasefeed.models;

import java.io.Serializable;

/**
 * Created by Brian on 2/25/2015.
 */
public class Post implements Comparable<Post>, Serializable {

    private String title;
    private String text;
    private int id;
    private int upvotes;
    private long timePosted;

    public Post(String text, int id, int upvotes)
    {
        this.text = text;
        this.id = id;
        this.upvotes = upvotes;
        timePosted = System.currentTimeMillis();
    }

    public Post(String title, String text, int id, int upvotes)
    {
        this(text, id, upvotes);
        this.title = title;
    }

    public void upvote() {
        upvotes++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public long getTimePosted() {
        return timePosted;
    }

    @Override
    public int compareTo(Post another) {
        //later  == greater//
        return (int) (this.timePosted - another.timePosted);
    }
}
