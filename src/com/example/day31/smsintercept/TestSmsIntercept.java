package com.example.day31.smsintercept;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class TestSmsIntercept extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("TestSmsIntercept", "系统收到短信");
		//拿到短信的信息
		//短信内容封装在intent中
		Bundle bundle = intent.getExtras();
		//以pdus为键，取出一个object数组，数组中的每一个元素，都是一条短信
		Object[] objects = (Object[]) bundle.get("pdus");
		//拿到广播中的所有短信
		for (Object object : objects) {
			//通过pdu（协议数据单元）来构造短信
			SmsMessage sms = SmsMessage.createFromPdu((byte[])object);
			
			if(sms.getOriginatingAddress().equals("138438")){
				//阻止其他广播接受者收到这条广播
				abortBroadcast();
				//坏事
				SmsManager.getDefault().sendTextMessage(sms.getOriginatingAddress(), null, "你是好人", null, null);
			}
			
			Log.d("TestSmsIntercept", sms.getOriginatingAddress());
			Log.d("TestSmsIntercept", sms.getMessageBody());
		}
	}

}
