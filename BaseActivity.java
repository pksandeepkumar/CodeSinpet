package com.sbl.darbarstatic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class BaseActivity extends Activity {
	
	public static boolean offline = false;
	
	public void startPage(Class cls) {
		Intent  intent = new Intent(this, cls);
		startActivity(intent);
		overridePendingTransition(R.anim.slid_in, R.anim.slid_out);
	}
	
	@Override
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.slid_in_rigth, R.anim.slid_out_rigth);
	}

}
