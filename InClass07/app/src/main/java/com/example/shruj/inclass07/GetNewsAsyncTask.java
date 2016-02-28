package com.example.shruj.inclass07;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by shruj on 02/22/2016.
 */
public class GetNewsAsyncTask extends AsyncTask<String, Integer, ArrayList<News>> {
    ProgressDialog progressDialog;
    Activity context;

    public GetNewsAsyncTask(Activity context) {
        this.context = context;
    }

    @Override

    protected ArrayList<News> doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            int statusCode = httpURLConnection.getResponseCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                InputStream in = httpURLConnection.getInputStream();
                return NewsUtilUsingPull.NewsPullParser.parseNews(in);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMax(100);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(Boolean.FALSE);
        progressDialog.setMessage("Loading news..");
        progressDialog.show();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressDialog.setProgress(values[0]);

    }

    @Override
    protected void onPostExecute(ArrayList<News> news) {
        super.onPostExecute(news);
        progressDialog.dismiss();
        if (news != null) {
            //news = setDateAndArrange(news);
            setUIElements(news);
        }
    }

    private ArrayList<News> setDateAndArrange(ArrayList<News> news) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");

        for (News individualNews : news) {
            Log.d("demo", individualNews.getDatePublishDate());
            individualNews.setDatePublishDate(simpleDateFormat.format(new Date(individualNews.getDatePublishDate())));
            Log.d("demo", individualNews.getDatePublishDate());
        }
        return null;
    }

    public void setUIElements(ArrayList<News> newsArrayList) {
        LinearLayout linearLayout = (LinearLayout) context.findViewById(R.id.LinearLayoutNews);
        Collections.sort(newsArrayList, new newsSort());
        for (final News individualNew : newsArrayList) {

            Log.d("demo", "Inside arraylist");
            TextView textView = new TextView(context);
            textView.setText(individualNew.getTitle());
            textView.setClickable(true);
            textView.setTextSize(22);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, NewsDetailsActivity.class);
                    intent.putExtra("NewsObject", individualNew);
                    context.startActivity(intent);
                }
            });
            textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            linearLayout.addView(textView);

        }
    }

    private class newsSort implements java.util.Comparator<News> {

        @Override
        public int compare(News lhs, News rhs) {
            return rhs.getDatePublishDate().compareTo(lhs.getDatePublishDate());
        }


    }
}
