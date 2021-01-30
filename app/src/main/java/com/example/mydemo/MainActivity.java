package com.example.mydemo;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FlutterActivity.withNewEngine().initialRoute("/home").build(MainActivity.this);
            }
        });

        init();
    }

    /// uri 解析
    private void init() {
        String url = "https://www.klook.com/zh-HK/event/2";
        String url1 = "https://www.klook.com/zh-HK/event/2-hk-black-friday";
        String url2 = "klook://event_detail/1002?city_id=2";
        String url3 = "klook://event/2";
        Uri uri = Uri.parse(url3);

        Log.d(TAG, "scheme: " +  uri.getScheme());
        Log.d(TAG, "host: " +  uri.getHost());
        Log.d(TAG, "path: " +  uri.getPathSegments().get(uri.getPathSegments().size() -1 ).split("-")[0]);
        Log.d(TAG, "query: " +  uri.getQuery());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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