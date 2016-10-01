package com.example.day31.recorder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class CallBootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent call = new Intent(context,  CallRecorder.class);
		context.startService(call);
	}

}
