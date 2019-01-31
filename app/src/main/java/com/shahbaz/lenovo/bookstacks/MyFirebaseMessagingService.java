package com.shahbaz.lenovo.bookstacks;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    public MyFirebaseMessagingService() {
    }
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        //sendNotification(remoteMessage.getData().get("title"),remoteMessage.getData().get("body"));

        Log.i("PVL", "MESSAGE RECEIVED!!");
        if (remoteMessage.getNotification().getBody() != null) {
            Log.i("PVL", "RECEIVED MESSAGE: " + remoteMessage.getNotification().getBody());
            sendNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
        } else {
            Log.i("PVL", "RECEIVED MESSAGE: " + remoteMessage.getData().get("message"));
            sendNotification(remoteMessage.getData().get("title"),remoteMessage.getData().get("body"));
        }
    }


    private void sendNotification(String messageTitle, String messageBody) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0 /* request code */, intent,PendingIntent.FLAG_UPDATE_CURRENT);
        int colour = Color.parseColor("#9ee1fc");
        long[] pattern = {500,500,500,500,500};
        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                 .setLargeIcon(BitmapFactory.decodeResource(
            getResources(), R.drawable.icon))
                .setSmallIcon(R.drawable.icon)
                .setColor(colour)
                .setContentTitle(messageTitle)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setVibrate(pattern)
                .setLights(Color.BLUE,1,1)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }

  /*  @Override
    public void handleIntent(Intent intent) {
        try
        {
            if (intent.getExtras() != null)
            {
                RemoteMessage.Builder builder = new RemoteMessage.Builder("MyFirebaseMessagingService");

                for (String key : intent.getExtras().keySet())
                {
                    builder.addData(key, intent.getExtras().get(key).toString());
                }

                onMessageReceived(builder.build());
            }
            else
            {
                super.handleIntent(intent);
            }
        }
        catch (Exception e)
        {
            super.handleIntent(intent);
        }

    }
*/
    /*    private void sendNotification(String messageBody)
    {
        Intent i =new Intent(this,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pi=PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_ONE_SHOT);
        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder nb=new NotificationCompat.Builder(this);
         *//*nb.setLargeIcon(BitmapFactory.decodeResource(
            getResources(), R.drawable.icon));*//*
            nb.setSmallIcon(R.drawable.icon);
        nb.setContentTitle("BookStacks");
        nb.setContentText(messageBody);
        nb.setAutoCancel(true);
        nb.setLights(Color.RED,1000,1000);
        nb.setVibrate (new long[] {1000,1000,1000,1000});
        nb.setSound(defaultSoundUri);
        nb.setContentIntent(pi);
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(0,nb.build());

    }*/
}
