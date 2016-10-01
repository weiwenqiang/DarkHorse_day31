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
		Log.d("服务生命周期", "onCreate-----创建");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("服务生命周期", "onStartCommand-----开启");
		return super.onStartCommand(intent, flags, startId);
		
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("服务生命周期", "onDestroy-----销毁");
	}

}
