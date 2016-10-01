package com.example.day31.hijack;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("BootReceiver", "开机广播接收");
		Toast.makeText(context, "开机广播接收", Toast.LENGTH_LONG).show();
		Intent intent1 = new Intent(context, TestHijack.class);
		//不是在Activity上下文里调用意图，必须设置下面的属性
		intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent1);
	}
}
