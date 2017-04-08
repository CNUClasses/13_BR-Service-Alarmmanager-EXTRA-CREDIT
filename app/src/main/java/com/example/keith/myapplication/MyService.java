package com.example.keith.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by keith on 4/6/17.
 */

public class MyService extends Service {

    private static final int TWO_SECONDS = 2000;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "In Service", Toast.LENGTH_SHORT).show();
        doagain();
        return START_NOT_STICKY;
    }

    private void doagain() {
        Intent startIntent = new Intent("KP.MYACTION");
        PendingIntent startPIntent = PendingIntent.getBroadcast(this, 0, startIntent, 0);
        AlarmManager alarm = (AlarmManager) this.getSystemService(this.ALARM_SERVICE);
        alarm.set(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime() + + TWO_SECONDS, startPIntent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
