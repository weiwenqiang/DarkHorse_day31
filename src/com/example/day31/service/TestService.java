package com.example.day31.service;

import com.example.day31.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public class TestService extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.b5_service);
		findViewById(R.id.b5_start).setOnClickListener(this);
		findViewById(R.id.b5_stop).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(TestService.this, MyService.class);
		switch (v.getId()) {
		case R.id.b5_start:
			//开启服务
			startService(intent);
			break;
		case R.id.b5_stop:
			//关闭服务
			stopService(intent);
			break;
		default:
			break;
		}
	}
}
