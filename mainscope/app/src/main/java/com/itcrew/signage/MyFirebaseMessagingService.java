package com.itcrew.signage;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by maxse on 23/06/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public static final String TAG ="NOTIFICACION";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);

        String from = remoteMessage.getFrom();
        Log.d(TAG, "Mensaje recibido de: " + from);
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
        sendNotification(remoteMessage.getNotification().getBody());
        /*if(remoteMessage.getNotification() != null)
        {
            Log.d(TAG, "Notificacion: "+ remoteMessage.getNotification().getBody());
        }*/
    }


    private void sendNotification(String body){
        Intent intent = new Intent(this, Campaign.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pending = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Firebase cloud messaging")
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(notificationSound)
                .setContentIntent(pending);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilder.build());



    }
}
