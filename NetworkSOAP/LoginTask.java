package com.cynere.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.cynere.constants.AppConstance;
import com.cynere.datamodels.User;
import com.cynere.dialog.ProgressDialogActivity;
import com.cynere.lockscreenapplication.DashboardActivity;
import com.cynere.lockscreenapplication.LoginActivity;
import com.cynere.lockscreenapplication.R;
import com.cynere.network.RestClient;
import com.cynere.savedpreferance.SavedPreferance;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class LoginTask  extends AsyncTask<Void, Void, Void> {

	User user;
	boolean login = false;
	Context context;
	LoginActivity thisActivity;
	String response;
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		ProgressDialogActivity.showProgress(context.getResources().getString(R.string.Please_wait), context);
	}
	
	public LoginTask( User user, Context context, LoginActivity thisActivity ) {
		this.user = user;
		this.context = context;
		this.thisActivity = thisActivity;
	}
	
	public LoginTask( User user, Context context) {
		this.user = user;
		this.context = context;
	}
	
	@Override
	protected Void doInBackground(Void... params) {
		
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
		nameValuePair.add(new BasicNameValuePair(AppConstance.PARAM_EMAIL, user.email));
		nameValuePair.add(new BasicNameValuePair(AppConstance.PARAM_PASSWORD, user.password));
		
		RestClient client = new RestClient();
		
		response = client.callPostMethod(AppConstance.URL_LOGIN, nameValuePair);
		
		if(response.contains("user")) {
			login = true;
			user = User.getParse(response);
		}
		
		Log.d("Response:", "Response:" + response);
		
		return null;
		
	}
	
	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		ProgressDialogActivity.hideProgress();
		
//		Toast.makeText(context, "response" 
//				+ response + " email:" + user.email + " password:" + user.password
//				, Toast.LENGTH_LONG).show();
		if(login) {
			SavedPreferance.setLogin(context, true);
			SavedPreferance.setEmail(context, user.email);
			SavedPreferance.setPassword(context, user.password);
			SavedPreferance.setName(context, user.fullName);
			SavedPreferance.setDOB(context, user.birthDate);
			SavedPreferance.setIsMale(context, user.isMale);
			SavedPreferance.setPincode(context, user.postalCode);
			Intent  intent = new Intent(context, DashboardActivity.class);
			if(thisActivity != null) {
				thisActivity.finish();
			}
			context.startActivity(intent);
			
		} else {
//			Invalid email or password
			Toast.makeText(context,"e-mail ou senha invalida" , Toast.LENGTH_LONG).show();
		}
//		Toast.makeText(context,"Response:" + response , Toast.LENGTH_LONG).show();
		
		
	}

}






/*$.ajax({
    url: "http://lockscreen.cynere.net/UserLockScreenApi/GetAdvertisement",
     async: false,
     type: "post",
     data: {screenType:"smal",email: "nirmal@gmail.com"},
     dataType: "jsonp",
     success: function (data, textStatus, xhr) {
         for (var i = 0; i < data.length; i++) {
             var Id = data[i].Id;
             var ImageName = data[i].ImageName;
             var ImageUrl = data[i].ImageUrl;
             alert(Id)
             alert(ImageName);
             alert(ImageUrl);             
         }
     },
     error: function () {
         alert("failure");
     }
 });*/



/*$.ajax({
    url: "http://localhost:19615/UserLockScreenApi/SignUp",
    async: false,
    type: "post",
    data: { email: "nirmal@gmail.com",password:"ss",fullName:"Nirmal Alex",isMale:true,birthDate:"2/12/1987",postalCode:"235326"},
    dataType: "jsonp",
    success: function (data, textStatus, xhr) {
        alert(data);
    },
    error: function () {
        alert("failure");
    }
});*/


/*$.ajax({
    url: "http://localhost:19615/UserLockScreenApi/LogIn",
    async: false,
    type: "post",
    data: { email: "nirmal",password:"ss" },
    dataType: "jsonp",
    success: function (data, textStatus, xhr) {
        alert(data);
    },
    error: function () {
        alert("failure");
    }
});*/