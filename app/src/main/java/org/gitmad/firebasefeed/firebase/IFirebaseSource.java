package org.gitmad.firebasefeed.firebase;

import org.gitmad.firebasefeed.models.Post;
import org.gitmad.firebasefeed.models.User;

import java.util.List;

/**
 * Created by Alex on 3/3/2015.
 */
public interface IFirebaseSource
{
    void AddPost(Post post);
    Post getPost(int id);

    User getUser(int id);

    /*
        void upvote(int postId);
     */

}
