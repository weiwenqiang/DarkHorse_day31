package com.example.day32.remoteservice;

import com.example.day32.remoteservice.PublicBusiness.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class RemoteService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		Log.d("day31的远程服务", "onBind");
		return new ZhouMi();
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.d("day31的远程服务", "onUnbind");
		return super.onUnbind(intent);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("day31的远程服务", "onCreate");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("day31的远程服务", "onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("day31的远程服务", "onDestroy");
	}
	class ZhouMi extends Stub{
		public void QianXian(){
			banZheng();
		}
		
		public void DaMaJiang(){
			
		}

	}
	
	public void banZheng(){
		Log.d("MyService", "李处帮你办证");
	}
}
