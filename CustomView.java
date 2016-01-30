package com.example.getotherapp;


import com.example.getotherapp.R;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 *
 * @author Sandeep Kumar <pksandeepkumar@gmail.com>
 */
public class ItemAppInfo extends RelativeLayout                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               {
	

	TextView tvText = null;
	Button btnOK = null;
	
	Context context ;

	public ItemAppInfo(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public ItemAppInfo(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public ItemAppInfo(Context context) {
		super(context);
		init(context);
	}
	private void init(Context context) {
		
		this.context = context;
		LayoutInflater inflater = (LayoutInflater)  getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
		View child =  inflater.inflate(R.layout.element_app_info,this);
	}

}
