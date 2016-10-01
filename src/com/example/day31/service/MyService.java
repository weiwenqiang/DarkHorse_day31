package com.example.day31.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("������������", "onCreate-----����");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("������������", "onStartCommand-----����");
		return super.onStartCommand(intent, flags, startId);
		
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("������������", "onDestroy-----����");
	}

}
