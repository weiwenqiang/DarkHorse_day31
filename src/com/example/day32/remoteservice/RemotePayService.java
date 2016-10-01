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
		Log.d("远程支付服务", "检测运行环境");
		Log.d("远程支付服务", "加密用户名密码");
		Log.d("远程支付服务", "建立连接");
		Log.d("远程支付服务", "上传数据");
		Log.d("远程支付服务", "完成支付");
	}
}
