package com.example.baithuchanh_20;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.TextView;
import android.widget.Toast;

public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {

    Context context;
    TextView txtmsg;

    public MyAsyncTask(Context context, TextView txtmsg) {
        this.context = context;
        this.txtmsg = txtmsg;
    }

    //do something before doing main task
    @Override
    protected void onPreExecute() {
        Toast.makeText(context, "onPreExecute!", Toast.LENGTH_SHORT).show();
        super.onPreExecute();
    }

    //do main task
    @Override
    protected Void doInBackground(Void... args) {
        for (int i = 0; i <= 100; i++) {
            //update progress every 200 milliseconds
            SystemClock.sleep(200);
            //publish progress to update UI on main thread
            publishProgress(i);
        }
        return null;
    }

    //update UI on main thread with progress
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int val = values[0];
        //update the progress bar
        //... (missing code for ProgressBar)
        //update the TextView with the progress value
        txtmsg.setText(val + "%");
    }

    //do something after main task is finished
    @Override
    protected void onPostExecute(Void result) {
        Toast.makeText(context, "Hoàn thành!", Toast.LENGTH_SHORT).show();
        super.onPostExecute(result);
    }
}
