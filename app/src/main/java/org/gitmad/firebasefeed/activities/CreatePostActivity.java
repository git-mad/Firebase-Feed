package org.gitmad.firebasefeed.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.gitmad.firebasefeed.R;
import org.gitmad.firebasefeed.firebase.FirebaseSource;
import org.gitmad.firebasefeed.models.Post;

public class CreatePostActivity extends ActionBarActivity {

    Intent intent;

    private EditText titleEditText;
    private EditText postEditText;
    private Button submitButton, cancelButton;
    private FirebaseSource mFirebaseSource;

    private String title;
    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        intent = getIntent();

        mFirebaseSource = new FirebaseSource(null);

        titleEditText = (EditText) findViewById(R.id.titleEditText);
        postEditText = (EditText) findViewById(R.id.postEditText);
        submitButton = (Button) findViewById(R.id.submitButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);

        title = "";
        content = "";

        submitButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //TODO(agrion): Create and add a post

                        CreatePostActivity.this.finish();

                    }
                }
        );

        cancelButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v)
                    {
                        Toast.makeText(CreatePostActivity.this, "Cancel Clicked!", Toast.LENGTH_SHORT).show();
                        CreatePostActivity.this.finish();
                    }
                }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_post, menu);
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
