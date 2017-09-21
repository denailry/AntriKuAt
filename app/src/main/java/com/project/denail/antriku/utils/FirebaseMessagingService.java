package com.project.denail.antriku.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;
import com.project.denail.antriku.APICallLib;
import com.project.denail.antriku.OnSendResponse;
import com.project.denail.antriku.R;

/**
 * Created by denail on 17/08/13.
 */

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        showNotification(
                remoteMessage.getData().get("user_token")
        );
    }

    private void showNotification(String userToken) {
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Uri notifSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

        String message = "Code generated for token: " + userToken;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setContentTitle("Code Generation")
                .setContentText(message)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(icon);

        Notification notification = builder.build();

        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.bigText(message)
                .setBigContentTitle("Code Generation")
                .setSummaryText("FROM: Server");

        builder.setStyle(bigText);
        builder.setSound(notifSound);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());

        APICallLib.response(5, "ABCD", userToken, new OnSendResponse() {
            @Override
            public void onSuccess(String result) {
                Log.d("TEST", result);
            }

            @Override
            public void onFailure(String error) {
                Log.d("TEST", error);
            }
        });
    }
}
