package com.example.day31.application;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class TestApplicationReceiverd extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		Uri uri = intent.getData();
		if("android.intent.action.PACKAGE_ADDED".equals(action)){
			Toast.makeText(context, uri.toString()+"����װ��", 0).show();
		}else if("android.intent.action.PACKAGE_REPLACED".equals(action)){
			Toast.makeText(context, uri.toString()+"��������", 0).show();
		}else if("android.intent.action.PACKAGE_REMOVED".equals(action)){
			Toast.makeText(context, uri.toString()+"��ж����", 0).show();
		}
	}

}
