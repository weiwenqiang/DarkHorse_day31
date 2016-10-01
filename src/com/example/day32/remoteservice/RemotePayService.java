package com.example.day32.remoteservice;

import com.example.day32.remoteservice.PayInterface.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class RemotePayService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return new payPangZhi();
	}
	
	class payPangZhi extends Stub{

		@Override
		public void pay() throws RemoteException {
			RemotePayService.this.pay();
		}
	}
	
	public void pay(){
		Log.d("Զ��֧������", "������л���");
		Log.d("Զ��֧������", "�����û�������");
		Log.d("Զ��֧������", "��������");
		Log.d("Զ��֧������", "�ϴ�����");
		Log.d("Զ��֧������", "���֧��");
	}
}
