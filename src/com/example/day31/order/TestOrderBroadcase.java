package com.example.day31.order;

import com.example.day31.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;

public class TestOrderBroadcase extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.b4_orderbroadcase);
		findViewById(R.id.b4_order).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b4_order:
			Intent intent = new Intent();
			intent.setAction("test.order.broadcase");
			//发送有序广播
			//resultReceiver:不需要在清单文件中配置，这个广播接收者只接收该条有序广播，并且是最后一个收到该广播，并且一定可以收到该广播
			sendOrderedBroadcast(intent, null, new MyReceiver(), null, 0, "每人发100斤大米", null);
			
			break;

		default:
			break;
		}
	}
	class MyReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			String text = getResultData();
			Log.d("反贪局收到文件", text);
		}
		
	}
}
