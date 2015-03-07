package org.gitmad.firebasefeed.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.gitmad.firebasefeed.R;
import org.gitmad.firebasefeed.firebase.FirebaseSource;
import org.gitmad.firebasefeed.firebase.IFirebaseSource;
import org.gitmad.firebasefeed.models.Post;
import org.gitmad.firebasefeed.models.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FeedActivity extends ActionBarActivity implements IUpdateActivity{

    private List<Post> postList;
    private User currentUser;

    private IFirebaseSource firebaseSource;
    private ArrayAdapter<Post> postArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        //Instantiate source with activity as updateable
        firebaseSource = new FirebaseSource(this);

        //initialize post list to be updated later//
        postList = new ArrayList<>();

        final ListView postsListView = (ListView) findViewById(R.id.postsListView);

        //anon inner ArrayAdapter subclass to display upvotes//
        postArrayAdapter = new ArrayAdapter<Post>(this, R.layout.post_list_item,
                R.id.listItem_titleText, postList) {
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                //use default behavior to set main text with Post#toString()
                View v = super.getView(position, convertView, parent);

                //set Title Text.
                TextView titleTextView = (TextView)v.findViewById(R.id.listItem_titleText);
                titleTextView.setText(getItem(position).getTitle());
                //set upvotes text//
                TextView upvotesTextView = (TextView) v.findViewById(R.id.upvotesTextView);
                upvotesTextView.setText(Integer.toString(getItem(position).getUpvotes()));

                //set click listener to increment upvotes when TextView is clicked//
                upvotesTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Post postClicked = getItem(position);

                        //cant upvote twice//
                        if (!currentUser.hasUpvoted(postClicked.getId())) {

                            //update data model//
                            postClicked.upvote();

                            //update view//
                            ((TextView) v).setText(getItem(position).getUpvotes());

                            //TODO update remote database//
                            //firebaseSource.upvote(postClicked.getId());
                        }
                    }
                });


                return v;
            }
        };

        postsListView.setAdapter(postArrayAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_feed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_make_post) {

            //launch CreatePostActivity with user data//
            Intent intent = new Intent(this, CreatePostActivity.class);
            intent.putExtra(CreatePostActivity.KEY_USER, currentUser);

            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void addPost(Post post)
    {
        if(postList == null)
        {
            postList = new ArrayList<>();
        }
        postList.add(post);
        postArrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void removePost(Post removed_post)
    {
        postList.remove(removed_post);
        postArrayAdapter.notifyDataSetChanged();
    }
}
