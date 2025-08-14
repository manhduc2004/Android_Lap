package com.example.baithuchanh_9;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {

    private MediaPlayer mymedia;

    @Override
    public void onCreate() {
        super.onCreate();
        mymedia = MediaPlayer.create(this, R.raw.mymusic);
        mymedia.setLooping(true); // Lặp lại
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getAction() != null) {
            switch (intent.getAction()) {
                case "ACTION_PLAY":
                    if (!mymedia.isPlaying()) {
                        mymedia.start();
                    }
                    break;

                case "ACTION_STOP":
                    if (mymedia.isPlaying()) {
                        mymedia.stop();
                        mymedia.release();
                        mymedia = MediaPlayer.create(this, R.raw.mymusic);
                    }
                    break;
            }
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mymedia != null) {
            if (mymedia.isPlaying()) {
                mymedia.stop();
            }
            mymedia.release();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
