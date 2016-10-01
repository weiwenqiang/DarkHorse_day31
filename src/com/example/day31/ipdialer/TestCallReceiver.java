package com.example.day31.ipdialer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

public class TestCallReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("TestCallReceiver", "��绰�㲥���յ��ˡ�");
		// ���IP��·
		// �ڴ�绰�㲥�У���Я������ĵ绰���룬ͨ��һ�´����ȡ
		String number = getResultData();
		Log.d("TestCallReceiver", number);
		// С���ƣ��ж��Ƿ����������������жϺ��������
		if (number.startsWith("0")) {
			SharedPreferences sp = context.getSharedPreferences("ip",
					Context.MODE_PRIVATE);
			String ipNumber = sp.getString("ipNumber", "");
			// ��IP��·����������û���������ǰ��
			number = ipNumber + number;
			// ���µĺ������·��뵽�㲥��
			setResultData(number);
		}
	}
}
