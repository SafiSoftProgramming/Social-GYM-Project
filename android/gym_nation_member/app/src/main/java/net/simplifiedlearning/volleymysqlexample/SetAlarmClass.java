package net.simplifiedlearning.volleymysqlexample;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by root on 6/3/18.
 */

public class SetAlarmClass {


    public void setalarm(Context context){

        Intent intent_time = new Intent(context.getApplicationContext(),ReceiverNotificationForNewData.class);
        PendingIntent pendingIntent_time = PendingIntent.getBroadcast(context.getApplicationContext(),1,intent_time, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager_time = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        alarmManager_time.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(),2*60*1000,pendingIntent_time);
    }



}
