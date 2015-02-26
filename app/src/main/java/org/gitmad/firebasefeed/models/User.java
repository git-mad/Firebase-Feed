package org.gitmad.firebasefeed.models;

import java.util.ArrayList;

/**
 * Created by Brian on 2/25/2015.
 */
public class User {

    private int id;
    private ArrayList<Post> posts;

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }
}
