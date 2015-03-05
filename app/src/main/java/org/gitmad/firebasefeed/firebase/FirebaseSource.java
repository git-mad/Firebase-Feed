package org.gitmad.firebasefeed.firebase;

import com.firebase.client.Firebase;

import org.gitmad.firebasefeed.models.Post;
import org.gitmad.firebasefeed.models.User;

import java.util.List;

/**
 * Created by Alex on 3/5/2015.
 */
public class FirebaseSource implements IFirebaseSource {

    private Firebase root;
    private Firebase postsRef;
    private Firebase usersRef;
    private final String FIREBASE_URL = "http://bitter.firebaseio.com";

    public FirebaseSource()
    {
        root = new Firebase(FIREBASE_URL);
        postsRef = root.child("posts");
        usersRef = root.child("users");
    }
    @Override
    public void AddPost(Post post)
    {
        Firebase newPostRef = postsRef.push();
        post.setId(newPostRef.getKey());
        newPostRef.setValue(post);
    }

    @Override
    public List<Post> listPosts() {
        return null;
    }

    @Override
    public Post getPost(int id) {
        return null;
    }

    @Override
    public User getUser(int id) {
        return null;
    }
}
