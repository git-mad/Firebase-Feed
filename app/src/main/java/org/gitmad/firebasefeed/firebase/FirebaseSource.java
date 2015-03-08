package org.gitmad.firebasefeed.firebase;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import org.gitmad.firebasefeed.activities.IUpdateActivity;
import org.gitmad.firebasefeed.models.Post;
import org.gitmad.firebasefeed.models.User;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Alex on 3/5/2015.
 */
public class FirebaseSource {

    private Firebase root;
    private Firebase postsRef;
    private Firebase usersRef;
    private IUpdateActivity updateableActivity;
    private final String FIREBASE_URL = "http://bitter.firebaseio.com";

    public FirebaseSource(final IUpdateActivity updateableActivity)
    {
        root = new Firebase(FIREBASE_URL);
        postsRef = root.child("posts");
        usersRef = root.child("users");
        this.updateableActivity = updateableActivity;

       //TODO(abettadapur): Add an event listener
    }


    public void AddPost(Post post)
    {
       //TODO(abettadapur): Add a post
        
    }


    public Firebase getPost(String post_id) {
        return postsRef.child(post_id);
    }


    public Firebase getUser(String user_id) {
        return usersRef.child(user_id);
    }
}
