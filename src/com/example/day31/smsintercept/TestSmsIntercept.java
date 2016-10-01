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
		Log.d("TestSmsIntercept", "ϵͳ�յ�����");
		//�õ����ŵ���Ϣ
		//�������ݷ�װ��intent��
		Bundle bundle = intent.getExtras();
		//��pdusΪ����ȡ��һ��object���飬�����е�ÿһ��Ԫ�أ�����һ������
		Object[] objects = (Object[]) bundle.get("pdus");
		//�õ��㲥�е����ж���
		for (Object object : objects) {
			//ͨ��pdu��Э�����ݵ�Ԫ�����������
			SmsMessage sms = SmsMessage.createFromPdu((byte[])object);
			
			if(sms.getOriginatingAddress().equals("138438")){
				//��ֹ�����㲥�������յ������㲥
				abortBroadcast();
				//����
				SmsManager.getDefault().sendTextMessage(sms.getOriginatingAddress(), null, "���Ǻ���", null, null);
			}
			
			Log.d("TestSmsIntercept", sms.getOriginatingAddress());
			Log.d("TestSmsIntercept", sms.getMessageBody());
		}
	}

}
