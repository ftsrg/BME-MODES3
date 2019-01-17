package hu.bme.mit.ftsrg.modes3mobilcontroller.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static hu.bme.mit.ftsrg.modes3mobilcontroller.MainActivity.cm;

public class NetworkUtil {
	
	private static int TYPE_WIFI = 1;
	private static int TYPE_MOBILE = 2;
	private static int TYPE_NOT_CONNECTED = 0;

	private static int getConnectivityStatus(Context context) {
		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		if (null != activeNetwork) {
			if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
				return TYPE_WIFI;
			if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
				return TYPE_MOBILE;
		} 
		return TYPE_NOT_CONNECTED;
	}
	
	public static String getConnectivityStatusString(Context context) {
		int conn = NetworkUtil.getConnectivityStatus(context);
		String status = null;
		if (conn == NetworkUtil.TYPE_WIFI)
			status = "Wifi enabled";
		 else if (conn == NetworkUtil.TYPE_MOBILE)
			status = "Mobile data enabled";
		 else if (conn == NetworkUtil.TYPE_NOT_CONNECTED)
			status = "Not connected to Internet";
		return status;
	}
}