package org.gitmad.firebasefeed.models;

import java.io.Serializable;

/**
 * Created by Brian on 2/25/2015.
 */
public class Post implements Comparable<Post>, Serializable {

    private String title;
    private String text;
    private String id;
    private int upvotes;
    private long timePosted;

    public Post(String text, int upvotes)
    {
        this.text = text;
        this.id = null;
        this.upvotes = upvotes;
        timePosted = System.currentTimeMillis();
    }

    public Post(String title, String text, int upvotes)
    {
        this(text,  upvotes);
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

    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;}

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
