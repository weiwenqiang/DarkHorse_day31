package com.example.day31.custom;

import com.example.day31.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public class TestCustom extends Activity implements OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.b3_custom);
		findViewById(R.id.b3_sendcustom).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b3_sendcustom:
			Intent intent = new Intent();
			intent.setAction("test.custom.broadcast");
			sendBroadcast(intent);
			break;

		default:
			break;
		}
	}
}
