package org.gitmad.firebasefeed;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Alex on 3/5/2015.
 */
public class FirebaseApplication extends Application
{
    @Override
    public void onCreate() {
        Firebase.setAndroidContext(this);
        super.onCreate();
    }
}
