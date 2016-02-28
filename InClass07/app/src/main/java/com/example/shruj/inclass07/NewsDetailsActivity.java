package com.example.shruj.inclass07;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NewsDetailsActivity extends AppCompatActivity {
    News individualNews;
    TextView title, date, description;
    ImageView imageView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        intent = getIntent();

        if (getIntent().getExtras() != null) {
            individualNews = (News) getIntent().getExtras().getSerializable("NewsObject");
        }

        title = (TextView) findViewById(R.id.idTitle);
        title.setText(individualNews.getTitle());
        date = (TextView) findViewById(R.id.idDate);
        date.setText((individualNews.getDatePublishDate()));
        description = (TextView) findViewById(R.id.idDescription);
        description.setText(individualNews.getDescription());
        imageView = (ImageView) findViewById(R.id.idImage);
        String imageAddress = individualNews.getUrl();
        Log.d("demo", "image Address " + imageAddress);

        new GetImage().execute(imageAddress);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsDetailsActivity.this, NewsWebViewActivity.class);
                intent.putExtra("Address", individualNews.getLink());
                startActivity(intent);
            }
        });
    }


    class GetImage extends AsyncTask<String, Void, Bitmap> {
        URL url;
        Bitmap image;

        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                url = new URL(params[0]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                image = BitmapFactory.decodeStream(con.getInputStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return image;
        }

        @Override
        protected void onPostExecute(Bitmap img) {
            imageView.setImageBitmap(img);
        }
    }


}
