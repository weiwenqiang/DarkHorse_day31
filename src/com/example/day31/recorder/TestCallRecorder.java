package com.example.day31.recorder;

import com.example.day31.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public class TestCallRecorder extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.b6_callrecorder);
		findViewById(R.id.b6_callrecorder).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b6_callrecorder:
			Intent intent = new Intent(TestCallRecorder.this, CallRecorder.class);
			startService(intent);
			break;

		default:
			break;
		}
	}

}
