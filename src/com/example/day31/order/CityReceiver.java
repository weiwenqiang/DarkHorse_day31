package com.example.day31.order;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CityReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String text = getResultData();
		Log.d("市收到文件", text);
		abortBroadcast();
	}

}
