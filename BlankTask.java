package com.sbl.hotelautomation.task;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import com.sbl.hotelautomation.AppConstance;
import com.sbl.hotelautomation.LoadingActivity;
import com.sbl.hotelautomation.components.ItemSingleBar;
import com.sbl.hotelautomation.datamodel.RoomStatusData;
import com.sbl.hotelautomation.datamodel.RoomType;
import com.sbl.hotelautomation.db.Databases;
import com.sbl.hotelautomation.dialogs.Progress;
import com.sbl.hotelautomation.network.SBLService;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class BlankTask extends  AsyncTask<Void, Void, String>  {
    Context context;
    
    public BlankTask(Context context) {
    	this.context = context;
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		Progress.showProgress("Please wait", context);
	}

	@Override
	protected String doInBackground(Void... params) {
		try {
			Thread.sleep(1000); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		Progress.hideProgress();
	}

}
