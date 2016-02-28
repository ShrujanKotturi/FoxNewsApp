package com.example.shruj.inclass07;

import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    String URL = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScrollView sv = (ScrollView) findViewById(R.id.scrollViewMain);
        LinearLayout Llayout = (LinearLayout) findViewById(R.id.LinearLayout);
        TextView[] tx = new TextView[11];


        for (int i = 0; i < 11; i++) {
            tx[i] = new TextView(MainActivity.this);
            tx[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            if (i == 0) {
                tx[i].setText("Most Popular");
                tx[i].setTextSize(40);
                tx[i].setGravity(Gravity.CENTER);
                tx[i].setTextColor(Color.WHITE);
                tx[i].setClickable(true);

                tx[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String URL = "http://feeds.foxnews.com/foxnews/most-popular";
                        Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                        intent.putExtra("Link", URL);
                        startActivity(intent);
                    }
                });
            } else if (i == 1) {
                tx[i].setText("Entertainment");
                tx[i].setTextSize(40);
                tx[i].setGravity(Gravity.CENTER);
                tx[i].setTextColor(Color.WHITE);
                tx[i].setClickable(true);

                tx[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String URL = "http://feeds.foxnews.com/foxnews/entertainment";
                        Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                        intent.putExtra("Link", URL);
                        startActivity(intent);
                    }
                });
            } else if (i == 2) {
                tx[i].setText("Health");
                tx[i].setTextSize(40);
                tx[i].setGravity(Gravity.CENTER);
                tx[i].setTextColor(Color.WHITE);
                tx[i].setClickable(true);

                tx[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String URL = "http://feeds.foxnews.com/foxnews/health";
                        Log.d("URLDemo", "" + URL);
                        Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                        intent.putExtra("Link", URL);
                        startActivity(intent);
                    }
                });
            } else if (i == 3) {
                tx[i].setText("Lifestyle");
                tx[i].setTextSize(40);
                tx[i].setGravity(Gravity.CENTER);
                tx[i].setTextColor(Color.WHITE);
                tx[i].setClickable(true);

                tx[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String URL = "http://feeds.foxnews.com/foxnews/section/lifestyle";
                        Log.d("URLDemo", "" + URL);
                        Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                        intent.putExtra("Link", URL);
                        startActivity(intent);
                    }
                });
            } else if (i == 4) {
                tx[i].setText("Opinion");
                tx[i].setTextSize(40);
                tx[i].setGravity(Gravity.CENTER);
                tx[i].setTextColor(Color.WHITE);
                tx[i].setClickable(true);

                tx[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String URL = "http://feeds.foxnews.com/foxnews/opinion";
                        Log.d("URLDemo", "" + URL);
                        Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                        intent.putExtra("Link", URL);
                        startActivity(intent);
                    }
                });
            } else if (i == 5) {
                tx[i].setText("Politics");
                tx[i].setTextSize(40);
                tx[i].setGravity(Gravity.CENTER);
                tx[i].setTextColor(Color.WHITE);
                tx[i].setClickable(true);

                tx[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String URL = "http://feeds.foxnews.com/foxnews/politics";
                        Log.d("URLDemo", "" + URL);
                        Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                        intent.putExtra("Link", URL);
                        startActivity(intent);
                    }
                });
            } else if (i == 6) {
                tx[i].setText("Science");
                tx[i].setTextSize(40);
                tx[i].setGravity(Gravity.CENTER);
                tx[i].setTextColor(Color.WHITE);
                tx[i].setClickable(true);

                tx[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String URL = "http://feeds.foxnews.com/foxnews/science";
                        Log.d("URLDemo", "" + URL);
                        Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                        intent.putExtra("Link", URL);
                        startActivity(intent);
                    }
                });
            } else if (i == 7) {
                tx[i].setText("Sports");
                tx[i].setTextSize(40);
                tx[i].setGravity(Gravity.CENTER);
                tx[i].setTextColor(Color.WHITE);
                tx[i].setClickable(true);

                tx[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String URL = "http://feeds.foxnews.com/foxnews/sports";
                        Log.d("URLDemo", "" + URL);
                        Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                        intent.putExtra("Link", URL);
                        startActivity(intent);
                    }
                });
            } else if (i == 8) {
                tx[i].setText("Tech");
                tx[i].setTextSize(40);
                tx[i].setGravity(Gravity.CENTER);
                tx[i].setTextColor(Color.WHITE);
                tx[i].setClickable(true);

                tx[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String URL = "http://feeds.foxnews.com/foxnews/tech";
                        Log.d("URLDemo", "" + URL);
                        Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                        intent.putExtra("Link", URL);
                        startActivity(intent);
                    }
                });
            } else if (i == 9) {
                tx[i].setText("Travel");
                tx[i].setTextSize(40);
                tx[i].setGravity(Gravity.CENTER);
                tx[i].setTextColor(Color.WHITE);
                tx[i].setClickable(true);

                tx[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String URL = "http://feeds.foxnews.com/foxnews/internal/travel/mixed";
                        Log.d("URLDemo", "" + URL);
                        Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                        intent.putExtra("Link", URL);
                        startActivity(intent);
                    }
                });
            } else if (i == 10) {
                tx[i].setText("U.S.");
                tx[i].setTextSize(40);
                tx[i].setGravity(Gravity.CENTER);
                tx[i].setTextColor(Color.WHITE);
                tx[i].setClickable(true);

                tx[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String URL = "http://feeds.foxnews.com/foxnews/national";
                        Log.d("URLDemo", "" + URL);
                        Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                        intent.putExtra("Link", URL);
                        startActivity(intent);
                    }
                });
            }


            Llayout.addView(tx[i]);


        }
    }

    private boolean isConnectedOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()) {
            return true;
        } else {
            return false;
        }
    }
}
