package com.mycompany.myplugin;

import com.appMobi.appMobiLib.AppMobiActivity;
import com.appMobi.appMobiLib.AppMobiModule;
import com.appMobi.appMobiLib.AppMobiWebView;

public class MyPluginModule extends AppMobiModule
{
	static private MyPluginSetup mysetup;
	static private MyPluginWorker myworker;

	@Override
	public void setup(AppMobiActivity activity, AppMobiWebView webview)
	{
		super.setup(activity, webview);
		
		mysetup = new MyPluginSetup(activity, webview);
		myworker = new MyPluginWorker(activity, webview);
		
		// You can get the application's shared activity with the following code 
		// AppMobiActivity parent = AppMobiActivity.sharedActivity();
		
		webview.registerCommand(mysetup, "MyPluginSetup");
		webview.registerCommand(myworker, "MyPluginWorker");
	}

	@Override
	public void initialize(AppMobiActivity activity, AppMobiWebView webview)
	{
		super.initialize(activity, webview);
		
		String result = "MyPluginInfo = " + mysetup.initialize() + ";";
		result += "MyPluginLoaded();";
		
		webview.loadUrl("javascript:" + result);
	}
}
