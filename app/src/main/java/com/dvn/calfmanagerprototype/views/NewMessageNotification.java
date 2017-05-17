package com.dvn.calfmanagerprototype.views;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.dvn.calfmanagerprototype.R;

/**
 * Helper class for showing and canceling new message
 * notifications.
 * <p>
 * This class makes heavy use of the {@link NotificationCompat.Builder} helper
 * class to create notifications in a backward-compatible way.
 */
public class NewMessageNotification extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification);
	}
}
