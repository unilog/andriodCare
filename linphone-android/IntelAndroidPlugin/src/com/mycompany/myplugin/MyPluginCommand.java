package com.mycompany.myplugin;

import com.appMobi.appMobiLib.AppMobiActivity;
import com.appMobi.appMobiLib.AppMobiCommand;
import com.appMobi.appMobiLib.AppMobiWebView;

public class MyPluginCommand extends AppMobiCommand
{
	public MyPluginCommand(AppMobiActivity activity, AppMobiWebView webview)
	{
		super(activity, webview);
	}
}
