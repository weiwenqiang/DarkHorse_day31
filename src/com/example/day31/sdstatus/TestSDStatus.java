package com.example.day31.sdstatus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TestSDStatus extends BroadcastReceiver {
//	<action android:name="android.intent.action.MEDIA_MOUNTED"/>
//    <action android:name="android.intent.action.MEDIA_REMOVED"/>
//    <action android:name="android.intent.action.MEDIA_UNMOUNTED"/>
	@Override
	public void onReceive(Context context, Intent intent) {
		//�ж��ֵ��Ĺ㲥��ʲô���͵�
		String acction = intent.getAction();
		if("android.intent.action.MEDIA_MOUNTED".equals(acction)){
			Toast.makeText(context, "SD������", 0).show();
		}else if("android.intent.action.MEDIA_REMOVED".equals(acction)){
			Toast.makeText(context, "SD���γ�", 0).show();
		}else if("android.intent.action.MEDIA_UNMOUNTED".equals(acction)){
			Toast.makeText(context, "SD��������", 0).show();
		}
	}
}
