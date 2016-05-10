/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package com.sagar.gcma;

import android.os.Bundle;
import org.apache.cordova.*;
import static com.sagar.gcma.CommonUtilities.SENDER_ID;
import android.app.Activity;
import com.sagar.gcma.GCMIntentService;

import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

 
import com.google.android.gcm.GCMRegistrar;

public class MainActivity extends CordovaActivity

{
	GCMIntentService g= new GCMIntentService();
	private String TAG = "** pushAndroidActivity **";
	private MainActivity mc;
	private WebView appView;
	String m="";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
	super.onCreate(savedInstanceState);
	
	checkNotNull(SENDER_ID, "SENDER_ID");
	 
	GCMIntentService.setRegId(m);
	GCMRegistrar.checkDevice(this);
	GCMRegistrar.checkManifest(this);
	 
	
	 
	final String regId = GCMRegistrar.getRegistrationId(this);
	Log.i(TAG, "registration id =====  "+regId);
	
	System.out.println("tttttt @@@@@@@@@  " +m);
	Toast.makeText(getApplicationContext(), "iiiiiiiiii", 4).show();

	
	if (regId.equals("")) {
	GCMRegistrar.register(this, SENDER_ID);
	} else {
	Log.v(TAG, "Already registered");
	}
	loadUrl(launchUrl); 

	}
	 
	private void checkNotNull(Object reference, String name) {
	if (reference == null) {
	throw new NullPointerException(
	
	);
	}
	}
	 
	@Override
	protected void onPause() {
	super.onPause();
	GCMRegistrar.unregister(this);
	}
	}
