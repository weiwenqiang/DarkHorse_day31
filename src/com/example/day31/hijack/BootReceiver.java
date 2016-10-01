package com.example.day31.hijack;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("BootReceiver", "�����㲥����");
		Toast.makeText(context, "�����㲥����", Toast.LENGTH_LONG).show();
		Intent intent1 = new Intent(context, TestHijack.class);
		//������Activity�������������ͼ�������������������
		intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent1);
	}
}
