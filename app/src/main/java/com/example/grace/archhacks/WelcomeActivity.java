package com.example.grace.archhacks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        message = (TextView)findViewById(R.id.message);
        message.setText(drawLines.getSuggestion());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.miHome:
                Intent i = new Intent(getApplicationContext(),WelcomeActivity.class);
                startActivity(i);
                return true;
            case R.id.miPicture:
                Intent i2 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i2);
                return true;
            case R.id.miTrends:
                Intent i3 = new Intent(getApplicationContext(),drawLines.class);
                startActivity(i3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void uploadPicture(View view) {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
