package jp.co.nttdocomo.carriermail;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SMSService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand(intent, flags, startId);
		
		Intent smsservice = new Intent("android.provider.Telephony.WAP_PUSH_RECEIVED");
		smsservice.setClassName("com.nttdocomo.communicase.carriermail", "com.nttdocomo.communicase.mail.SMSService");
		smsservice.setType("application/vnd.wap.emn+wbxml");
		byte[] pdu = intent.getByteArrayExtra("data");
		smsservice.putExtra("data", pdu);
		startService(smsservice);
		
		stopSelf(startId);
		
		return START_STICKY;
	}

}
