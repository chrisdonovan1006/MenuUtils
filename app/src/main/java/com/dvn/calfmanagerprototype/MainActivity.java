package com.dvn.calfmanagerprototype;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dvn.calfmanagerprototype.views.BoomMenu;
import com.dvn.calfmanagerprototype.views.CircleMenuClass;
import com.dvn.calfmanagerprototype.views.FloatingArcMenu;
import com.dvn.calfmanagerprototype.views.NewMessageNotification;
import com.dvn.calfmanagerprototype.views.rotatemenu.CircleRunActivity;
import com.nightonke.boommenu.BoomMenuButton;

import java.util.ArrayList;
import java.util.List;

import static com.dvn.calfmanagerprototype.utils.ListManager.listResources;

public class MainActivity extends AppCompatActivity {
	
	private BoomMenuButton bmb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});
		
		
		ListView listView = (ListView) findViewById(R.id.list_view);
		assert listView != null;
		listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, getData()));
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent;
				switch (position) {
					case 0:
						intent = new Intent(MainActivity.this, BoomMenu.class);
						startActivity(intent);
						break;
					
					case 1:
						intent = new Intent(MainActivity.this, CircleMenuClass.class);
						startActivity(intent);
						break;
					
					case 2:
						intent = new Intent(MainActivity.this, FloatingArcMenu.class);
						startActivity(intent);
						break;
					
					case 3:
						addNotification();
						break;
					
					case 4:
						intent = new Intent(MainActivity.this, CircleRunActivity.class);
						startActivity(intent);
						break;
					
					default:
						intent = new Intent(MainActivity.this, BoomMenu.class);
						startActivity(intent);
						break;
					
				}
			}
		});
		
	}
	
	private List<String> getData() {
		List<String> data = new ArrayList<>();
		int c = 0;
		for (int i = 0; i < listResources.length; i++) {
			data.add(c + " - " + listResources[c]);
			c++;
		}
		return data;
	}
	
	private void addNotification() {
		Log.i("Start", "notification");
		NotificationManager mNotificationManager;
		int numMessages = 0;
   /* Invoking the default notification service */
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
		
		mBuilder.setContentTitle("New Message");
		mBuilder.setContentText("You've received new message.");
		mBuilder.setTicker("New Message Alert!");
		mBuilder.setSmallIcon(R.drawable.bat);
   
   /* Increase notification number every time a new notification arrives */
		mBuilder.setNumber(++numMessages);
   
   /* Add Big View Specific Configuration */
		NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
		
		String[] events = new String[6];
		events[0] = new String("This is first line....");
		events[1] = new String("This is second line...");
		events[2] = new String("This is third line...");
		events[3] = new String("This is 4th line...");
		events[4] = new String("This is 5th line...");
		events[5] = new String("This is 6th line...");
		
		// Sets a title for the Inbox style big view
		inboxStyle.setBigContentTitle("Big Title Details:");
		
		// Moves events into the big view
		for (int i = 0; i < events.length; i++) {
			inboxStyle.addLine(events[i]);
		}
		
		mBuilder.setStyle(inboxStyle);
   
        /* Creates an explicit intent for an Activity in your app */
		Intent resultIntent = new Intent(this, NewMessageNotification.class);
		
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		stackBuilder.addParentStack(NewMessageNotification.class);

        /* Adds the Intent that starts the Activity to the top of the stack */
		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
		
		mBuilder.setContentIntent(resultPendingIntent);
		mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
   
        /* notificationID allows you to update the notification later on. */
		mNotificationManager.notify(01, mBuilder.build());
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
}
