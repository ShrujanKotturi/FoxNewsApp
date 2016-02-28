package com.example.shruj.inclass07;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {
    Intent intent;
    static ArrayList<News> newsArrayList = new ArrayList<>();
    ScrollView sv;
    LinearLayout Llayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        sv = (ScrollView) findViewById(R.id.scrollViewNews);
        Llayout = (LinearLayout) findViewById(R.id.LinearLayoutNews);

        if (getIntent().getExtras() != null) {
            new GetNewsAsyncTask(this).execute(getIntent().getExtras().getString("Link"));
        }
    }


}
