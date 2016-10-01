package com.example.day31.recorder;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.media.MediaRecorder.AudioSource;
import android.os.IBinder;
import android.telecom.TelecomManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class CallRecorder extends Service {
	MediaRecorder recorder;
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		// 拿到电话管理器
		TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		// 电话状态监听
		// events:决定PhoneStateListener侦听什么内容
		tm.listen(new MyListener(), PhoneStateListener.LISTEN_CALL_STATE);
	}

	class MyListener extends PhoneStateListener {
		// 一旦电话状态改变，此方法调用
		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			super.onCallStateChanged(state, incomingNumber);
			//state电话的3个状态：空闲，响铃，摘机
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:
				Log.d("电话状态", "空闲");
				if(recorder!=null){
					recorder.stop();
					recorder.release();
					recorder=null;
				}
				break;
			case TelephonyManager.CALL_STATE_RINGING:
				Log.d("电话状态", "响铃");
				//初始化录音机
				if(recorder==null){
					recorder = new MediaRecorder();
					//设置声音来源是麦克风
					recorder.setAudioSource(AudioSource.MIC);
					//指定格式3gp
					recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
					//指定保存文件
					recorder.setOutputFile("sdcard/record.3gp");
					//指定音频编码
					recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
					//初始化完毕
					try {
						recorder.prepare();
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:
				Log.d("电话状态", "摘机");
				//开始录音
				if(recorder!=null){
					recorder.start();
				}
				break;
			default:
				break;
			}
		}
	}
}
