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
public class FirebaseSource implements IFirebaseSource {

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

        postsRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                Post post = dataSnapshot.getValue(Post.class);
                if(updateableActivity != null)
                {
                    FirebaseSource.this.updateableActivity.addPost(post);
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot)
            {
                Post post = dataSnapshot.getValue(Post.class);
                FirebaseSource.this.updateableActivity.removePost(post);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @Override
    public void AddPost(Post post)
    {
        Firebase newPostRef = postsRef.push();
        post.setId(newPostRef.getKey());
        newPostRef.setValue(post);
    }

    @Override
    public Firebase getPost(String post_id) {
        return postsRef.child(post_id);
    }

    @Override
    public Firebase getUser(String user_id) {
        return usersRef.child(user_id);
    }
}
