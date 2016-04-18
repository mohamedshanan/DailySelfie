package com.coursera.shanan.dailyselfie;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SelfieNotificationReceiver extends BroadcastReceiver {
    private static final String TAG = "SelfieNotificationReceiver";
    private final CharSequence contentTitle = "Daily Selfie";
    private final CharSequence contentText = "Time for another selfie!";
    private Intent mSelfieIntent;
    private PendingIntent mContentIntent;

    @Override
    public void onReceive(Context context, Intent intent) {

        // The intent to be used when the user clicks on the notification
        mSelfieIntent = new Intent(context, SelfieListViewActivity.class);

        // The pending intent that wraps the underlying intent
        mContentIntent = PendingIntent.getActivity(context, 0, mSelfieIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Build the notification
        Notification.Builder notificationBuilder = new Notification.Builder(context)
                .setContentText(contentText)
                .setContentTitle(contentTitle)
                .setSmallIcon(android.R.drawable.ic_menu_camera)
                .setContentIntent(mContentIntent)
                .setAutoCancel(true);

        // Get the notification manager
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Pass the notification to the notification manager
        mNotificationManager.notify(1, notificationBuilder.build());
    }
}
