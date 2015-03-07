package org.gitmad.firebasefeed.firebase;

import com.firebase.client.Firebase;

import org.gitmad.firebasefeed.models.Post;
import org.gitmad.firebasefeed.models.User;

import java.util.List;

/**
 * Created by Alex on 3/3/2015.
 */
public interface IFirebaseSource
{
    void AddPost(Post post);
    Firebase getPost(String post_id);

    Firebase getUser(String user_id);

    /*
        void upvote(int postId);
     */

}
