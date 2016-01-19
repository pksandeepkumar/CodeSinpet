package com.feathernet.todo.alarms;



import com.feathernet.todo.NotificationActivity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class AlarmServiceClass extends Service {

	@Override
	public void onCreate() {
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		 return null;
	}
	
	@Override
	public void onDestroy() {
		 super.onDestroy();
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		 super.onStart(intent, startId);
		 
		 Intent updateIntent = new Intent(this, NotificationActivity.class); 
	     updateIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	     startActivity(updateIntent);
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		 return super.onUnbind(intent);
	}

}