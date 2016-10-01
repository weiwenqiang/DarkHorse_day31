package com.example.day32.remoteservice;

import com.example.day32.remoteservice.PublicBusiness.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class RemoteService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		Log.d("day31��Զ�̷���", "onBind");
		return new ZhouMi();
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.d("day31��Զ�̷���", "onUnbind");
		return super.onUnbind(intent);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("day31��Զ�̷���", "onCreate");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("day31��Զ�̷���", "onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("day31��Զ�̷���", "onDestroy");
	}
	class ZhouMi extends Stub{
		public void QianXian(){
			banZheng();
		}
		
		public void DaMaJiang(){
			
		}

	}
	
	public void banZheng(){
		Log.d("MyService", "������֤");
	}
}
