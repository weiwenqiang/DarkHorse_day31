package com.example.day31.hijack;

import com.example.day31.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class TestHijack extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.b2_hijack);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

}
