package org.gitmad.firebasefeed.activities;

import org.gitmad.firebasefeed.models.Post;

import java.util.List;

/**
 * Created by Alex on 3/5/2015.
 */
public interface IUpdateActivity
{
    public void addPost(Post post);

    public void removePost(Post removed_post);


}
