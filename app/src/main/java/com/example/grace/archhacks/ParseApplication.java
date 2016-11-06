package com.example.grace.archhacks;

import android.app.Application;
import android.content.Context;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.interceptors.ParseLogInterceptor;

/**
 * Created by Grace on 11/5/2016.
 */

public class ParseApplication extends Application {
    public static final String YOUR_APPLICATION_ID = "555s4djdjs03kzlsujdhsjdkz";
    public static final String YOUR_CLIENT_KEY = "7d5w36d9g8h274312sd5xd";

    public static Context CONTEXT;

    @Override
    public void onCreate() {
        super.onCreate();

        CONTEXT = this;

        // set applicationId, and server server based on the values in the Heroku settings.
        // clientKey is not needed unless explicitly configured
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(YOUR_APPLICATION_ID) // should correspond to APP_ID env variable
                .clientKey(null)  // set explicitly unless clientKey is explicitly configured on Parse server
                .addNetworkInterceptor(new ParseLogInterceptor())
                .server("http://guarded-meadow-68333.herokuapp.com/parse").build());

        ParseObject.registerSubclass(Picture.class);

         // Test creation of object
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
    }
}
