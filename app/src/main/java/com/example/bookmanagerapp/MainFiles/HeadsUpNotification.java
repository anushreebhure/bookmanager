package com.example.bookmanagerapp.MainFiles;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.bookmanagerapp.R;

public class HeadsUpNotification {

    private NotificationManager manager;
    private static final String PRIMARY_CHANNEL = "default";
    private Context ctx;
    private PendingIntent pendingIntent;


    HeadsUpNotification(Context activity){
        ctx = activity;
        Intent intent = new Intent(ctx, MainActivity.class); //replace Activity_home with the activity you want to start after clicking on notification
        pendingIntent = PendingIntent.getActivity(ctx,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private int getSmallIcon() {
        return R.drawable.ic_launcher_foreground;
    }


    private NotificationManager getManager() {

        if (manager == null) {
            manager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return manager;
    }

    //Call this function to get notification
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void getNotification(String title, String body) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel chan1 = new NotificationChannel(PRIMARY_CHANNEL,
                    "Primary_Channel", NotificationManager.IMPORTANCE_DEFAULT);
            chan1.setLightColor(Color.GREEN);
            chan1.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            getManager().createNotificationChannel(chan1);

            getManager().notify(1,  new Notification.Builder(ctx, PRIMARY_CHANNEL)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setContentIntent(pendingIntent)
                    .setSmallIcon(getSmallIcon())
                    .setAutoCancel(true)
                    .build());

        }


        else {
            Notification.Builder notificationBuilder = new Notification.Builder(ctx)
                    .setSmallIcon(getSmallIcon())
                    .setPriority(Notification.PRIORITY_DEFAULT)
                    .setCategory(Notification.CATEGORY_MESSAGE)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setContentTitle(title)
                    .setContentText(body);
            notificationBuilder.build();
        }


    }

}