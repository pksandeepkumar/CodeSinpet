package com.sbl.darbarstatic.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.sbl.darbarstatic.SBLConfiguration;

public class SetImageTask extends AsyncTask<Void, Void, Void> {
	
	ImageView imageView;
	String image;
	BitmapDrawable bmap;
	Bitmap bmp;
	
	public SetImageTask(ImageView imageView, String image) {
		this.imageView = imageView;
		this.image = image;
	}
	
	@Override
	protected void onPreExecute() {

	}

	@Override
	protected Void doInBackground(Void... params) {
		
		
		try {
			this.bmp=BitmapFactory.decodeFile(SBLConfiguration.ImgPath + "/" + image);
		} catch (OutOfMemoryError e) {
		}
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		try {
			if(imageView != null) {
				 imageView.setImageBitmap(this.bmp);
			 } 
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}
		 
		
	}

}