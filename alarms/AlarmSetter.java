package com.feathernet.todo.alarms;

import java.util.Calendar;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class AlarmSetter {
	
	public static void setAlarm(Context context, long targetTimeInMillisecond) {

		Intent myIntent = new Intent(context,
			AlarmServiceClass.class);
		PendingIntent pendingIntent = PendingIntent.getService(
				context, 0, myIntent, 0);
		AlarmManager alarmManager = (AlarmManager) context
				.getSystemService(android.content.Context.ALARM_SERVICE);
			alarmManager.set(AlarmManager.RTC_WAKEUP, targetTimeInMillisecond , pendingIntent);
	}
	
	
	public static void cancelAlarm(Context context) {

		 Intent myIntent = new Intent(context,
					AlarmServiceClass.class);
		 PendingIntent pendingIntent = PendingIntent.getService(
				 context, 0, myIntent, 0);
		 AlarmManager alarmManager = (AlarmManager) context
						.getSystemService(android.content.Context.ALARM_SERVICE);

		 alarmManager.cancel(pendingIntent);
	}
}
