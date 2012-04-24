package net.virifi.android.spmodemail;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class WlanPasswordManager {
	private static final String PREF_NAME = "spmodemail_auth_info";
	private static final String WLAN_PASS = "wlan_password";
	
	public static String getWlanPassword(Context context) {
		SharedPreferences pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		return pref.getString(WLAN_PASS, "");
	}
	
	public static void saveWlanPassword(Context context, String password) {
		SharedPreferences pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		Editor editor = pref.edit();
		editor.putString(WLAN_PASS, password);
		editor.commit();
	}
}