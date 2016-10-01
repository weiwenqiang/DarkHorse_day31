package com.example.day31.ipdialer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

public class TestCallReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("TestCallReceiver", "打电话广播，收到了。");
		// 添加IP线路
		// 在打电话广播中，会携带拨打的电话号码，通过一下代码获取
		String number = getResultData();
		Log.d("TestCallReceiver", number);
		// 小完善，判断是否是座机，还可以判断号码归属地
		if (number.startsWith("0")) {
			SharedPreferences sp = context.getSharedPreferences("ip",
					Context.MODE_PRIVATE);
			String ipNumber = sp.getString("ipNumber", "");
			// 把IP线路号码添加至用户拨打号码的前面
			number = ipNumber + number;
			// 把新的号码重新放入到广播中
			setResultData(number);
		}
	}
}
