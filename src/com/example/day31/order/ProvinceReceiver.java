package com.example.day31.order;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ProvinceReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String text = getResultData();
		Log.d("ʡ�յ��ļ�", text);
		setResultData("ÿ�˷�80�����");
	}

}
