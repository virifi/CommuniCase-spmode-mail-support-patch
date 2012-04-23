package net.virifi.android.spswitcher;

import com.android.internal.telephony.IWapPushManager;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SPPushSwitcherActivity extends Activity {

	IWapPushManager mWapPushManager = null;

	private ServiceConnection mConnection = new ServiceConnection() {
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mWapPushManager = IWapPushManager.Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			mWapPushManager = null;
		}

	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bindService(new Intent(IWapPushManager.class.getName()), mConnection,
				Context.BIND_AUTO_CREATE);

		Button spmodemailButton = (Button) findViewById(R.id.spmodemail_button);
		spmodemailButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				boolean success = false;
				try {
					success = mWapPushManager.updatePackage("36956",
							"application/vnd.wap.emn+wbxml",
							"jp.co.nttdocomo.carriermail",
							"jp.co.nttdocomo.carriermail.SMSService", 1, false,
							false);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				if (success) {
					Toast.makeText(getApplicationContext(), "Success",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(), "Failed",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

		Button communicaseButton = (Button) findViewById(R.id.communicase_button);
		communicaseButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				boolean success = false;
				try {
					success = mWapPushManager.updatePackage("36956",
							"application/vnd.wap.emn+wbxml",
							"com.nttdocomo.communicase.carriermail",
							"com.nttdocomo.communicase.mail.SMSService", 1,
							false, false);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				if (success) {
					Toast.makeText(getApplicationContext(), "Success",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(), "Failed",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unbindService(mConnection);
	}
}