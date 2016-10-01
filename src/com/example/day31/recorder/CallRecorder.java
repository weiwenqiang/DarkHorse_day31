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
		// �õ��绰������
		TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		// �绰״̬����
		// events:����PhoneStateListener����ʲô����
		tm.listen(new MyListener(), PhoneStateListener.LISTEN_CALL_STATE);
	}

	class MyListener extends PhoneStateListener {
		// һ���绰״̬�ı䣬�˷�������
		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			super.onCallStateChanged(state, incomingNumber);
			//state�绰��3��״̬�����У����壬ժ��
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:
				Log.d("�绰״̬", "����");
				if(recorder!=null){
					recorder.stop();
					recorder.release();
					recorder=null;
				}
				break;
			case TelephonyManager.CALL_STATE_RINGING:
				Log.d("�绰״̬", "����");
				//��ʼ��¼����
				if(recorder==null){
					recorder = new MediaRecorder();
					//����������Դ����˷�
					recorder.setAudioSource(AudioSource.MIC);
					//ָ����ʽ3gp
					recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
					//ָ�������ļ�
					recorder.setOutputFile("sdcard/record.3gp");
					//ָ����Ƶ����
					recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
					//��ʼ�����
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
				Log.d("�绰״̬", "ժ��");
				//��ʼ¼��
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
