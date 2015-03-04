package org.gitmad.firebasefeed.activities;

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
import org.gitmad.firebasefeed.models.Post;
import org.gitmad.firebasefeed.models.User;

import java.util.ArrayList;


public class FeedActivity extends ActionBarActivity {

    private ArrayList<Post> postList = new ArrayList<Post>();
    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        final ListView postsListView = (ListView) findViewById(R.id.postsListView);

        //anon inner ArrayAdapter subclass to display upvotes//
        ArrayAdapter<Post> postArrayAdapter = new ArrayAdapter<Post>(this, R.layout.post_list_item,
                R.id.text1, postList) {
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                //use default behavior to set main text with Post#toString()
                View v = super.getView(position, convertView, parent);

                //set upvotes text//
                TextView upvotesTextView = (TextView) v.findViewById(R.id.upvotesTextView);
                upvotesTextView.setText(getItem(position).getUpvotes());

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

                            //TODO update database
                        }
                    }
                });


                return v;
            }
        };

        postsListView.setAdapter(postArrayAdapter);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
