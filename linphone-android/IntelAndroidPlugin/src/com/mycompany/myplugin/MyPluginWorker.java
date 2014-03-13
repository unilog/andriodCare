package com.mycompany.myplugin;

import org.linphone.CallManager;
import org.linphone.LinphoneManager;
import org.linphone.R;
import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneCoreException;

import com.appMobi.appMobiLib.AppMobiActivity;
import com.appMobi.appMobiLib.AppMobiWebView;
import android.webkit.JavascriptInterface;

public class MyPluginWorker extends MyPluginCommand
{
	public MyPluginWorker(AppMobiActivity activity, AppMobiWebView webview)
	{
		super(activity, webview);
    }
	
	@JavascriptInterface
	public void startWork(String message, int interval)
	{
		// Add your code here to start the work
		// TODO

		// get app directory for the app (directory where index.html, etc. is located)
		// You might do this so you can write an image or other web based file that you
		// want the app to be able to reference in the .html
		String appDir = webview.appDirectory().getPath();

		// get base directory for the app (directory for storing config or other persisted data)
		// You might do this so you can save a history of the work that you have done
		// and inject information about pending jobs and their status
		String baseDir = webview.baseDirectory().getPath();

		// Maybe you want to fire an event to the web view when it's started
		webview.loadUrl("javascript:var ev = document.createEvent('Events');ev.initEvent('myplugin.workstart',true,true);document.dispatchEvent(ev);");
		LinphoneAddress lAddress;
		try {
			lAddress = LinphoneManager.getLc().interpretUrl("wayel_yang");
			CallManager.getInstance().inviteAddress(lAddress, true, false);
		} catch (LinphoneCoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@JavascriptInterface
	public void stopWork()
	{
		// Add your code here to stop the work
		// TODO

		// Maybe you want to fire an event to the web view when it's done
		webview.loadUrl("javascript:var ev = document.createEvent('Events');ev.initEvent('myplugin.workstop',true,true);document.dispatchEvent(ev);");
		//Ñî·«
		AppMobiActivity.sharedActivity().finish();
	}
}
