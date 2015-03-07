package org.gitmad.firebasefeed.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Brian on 2/25/2015.
 */
public class User implements Serializable {

    private int id;
    private ArrayList<Post> posts;

    public User(int id) {
        this.id = id;
        this.posts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }
}
