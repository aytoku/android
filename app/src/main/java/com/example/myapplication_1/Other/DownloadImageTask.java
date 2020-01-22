package com.example.myapplication_1.Other;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {



    public interface CallBack<A> {
        A async( A a);
        void sync( A a);
    }
    private final CallBack<Bitmap> callBack;

    public DownloadImageTask(CallBack<Bitmap> callBack) {
        this.callBack = callBack;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return this.callBack.async(mIcon11);
    }

    protected void onPostExecute(Bitmap result) {
        this.callBack.sync(result);
    }
}