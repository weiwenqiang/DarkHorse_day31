package com.example.day31.ipdialer;

import com.example.day31.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;

public class TestIPDialer extends Activity implements OnClickListener {
	EditText et_ip;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.b1_ipdialer);
		et_ip = (EditText) findViewById(R.id.b1_ipdialer);
		findViewById(R.id.b1_save).setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b1_save:
			SharedPreferences sp = getSharedPreferences("ip", MODE_PRIVATE);
			sp.edit().putString("ipNumber", et_ip.getText().toString()).commit();
			break;

		default:
			break;
		}
	}

}
