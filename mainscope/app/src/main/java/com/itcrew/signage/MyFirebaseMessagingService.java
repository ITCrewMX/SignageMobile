package com.itcrew.signage;

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
        super.onMessageReceived(remoteMessage);

        String from = remoteMessage.getFrom();
        Log.d(TAG, "Mensaje recibido de: " + from);

        if(remoteMessage.getNotification() != null)
        {
            Log.d(TAG, "Notificacion: "+ remoteMessage.getNotification().getBody());
        }
    }
}
