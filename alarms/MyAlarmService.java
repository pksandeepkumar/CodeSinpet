package com.feathernet.todo.alarms;



import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyAlarmService extends Service {

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
		 
		/* Log.d("MyAlarmService", "MyAlarmService");
		 AlarmSetter.setAlarm(SharedPreferanceActivity.getTimeInteval());
		 Intent updateIntent = new Intent(TellingTimerActivity.context, NotificationManager.class); 
	     updateIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	     TellingTimerActivity.context.startActivity(updateIntent);*/
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		 return super.onUnbind(intent);
	}

}