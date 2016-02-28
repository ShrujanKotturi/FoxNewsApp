package com.example.shruj.inclass07;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by user on 2/22/2016.
 */
public class getImageAsyncTask extends AsyncTask<String, Void, Bitmap>

{


    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bmp = null;
        try {
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            int i = connection.getResponseCode();
            if (i == HttpURLConnection.HTTP_OK) {
                connection.setRequestMethod("GET");
                InputStream is = connection.getInputStream();
                bmp = BitmapFactory.decodeStream(is);

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return bmp;


    }


    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

    }
}
