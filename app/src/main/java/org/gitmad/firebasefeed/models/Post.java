package org.gitmad.firebasefeed.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Brian on 2/25/2015.
 */
public class Post implements Comparable<Post>, Serializable {

    private String title;
    private String content;
    private String id;
    private String user_id;
    private int upvotes;
    private Set<String> upvoted;
    private long timePosted;


    public Post(String title, String content, String user_id)
    {
        this.title = title;
        this.content = content;
        this.id = null;
        this.user_id = user_id;
        this.upvoted = new HashSet<>();
        upvoted.add(user_id);
        this.upvotes = 0;
        timePosted = System.currentTimeMillis();
    }


    public Post()  //for firebase
    {
        this.upvoted = new HashSet<>();
    }

    public void upvote(String user_id) {
        if (!upvoted.contains(user_id)) {
            upvotes++;
            upvoted.add(user_id);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;}

    public int getUpvotes() {
        return upvotes;
    }

    public Set<String> getUpvoted() {
        return upvoted;
    }

    public long getTimePosted() {
        return timePosted;
    }

    @Override
    public int compareTo(Post another) {
        //later  == greater//
        return (int) (this.timePosted - another.timePosted);
    }

    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Post))
        {
            return false;
        }
        Post p = (Post)o;
        return p.getId() == getId();
    }



}
