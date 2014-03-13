package com.mycompany.myplugin;

import com.appMobi.appMobiLib.AppMobiActivity;
import com.appMobi.appMobiLib.AppMobiWebView;

public class MyPluginSetup extends MyPluginCommand
{
	public MyPluginSetup(AppMobiActivity activity, AppMobiWebView webview)
	{
		super(activity, webview);
    }

    public String initialize()
    {
		return "{ 'ready' : 1 }";
	}
}
