package org.gitmad.firebasefeed.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Brian on 2/25/2015.
 */
public class User implements Serializable {

    private int id;
    private ArrayList<Post> posts;
    private ArrayList<Integer> upvotedPostIds;

    public User(int id) {
        this.id = id;
        posts = new ArrayList<>();
        upvotedPostIds = new ArrayList<>();
    }

    /**
     * checks if this user has already upvoted the post with the id specified
     *
     * @param postId id of the post being checked
     * @return true if upvoted, false otherwise
     */
    public boolean hasUpvoted(int postId) {
        if (upvotedPostIds.contains(postId)) {
            return false;
        } else {
            upvotedPostIds.add(postId);
            return true;
        }
    }

    public int getId() {
        return id;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }
}
