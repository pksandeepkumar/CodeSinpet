package com.feathernet.masara.adapters;

import java.util.ArrayList;

import com.feathernet.masara.adapters.ContractListAdapter.ViewHolder;
import com.feathernet.masara.datamodels.Contract;
import com.feathernet.masara.datamodels.Crop;
import com.feathernet.masara.datamodels.FruitCountHdr;
import com.feathernet.masara.datamodels.TrainingClassHdr;
import com.feathernet.masara.db.Databases;
import com.feathernet.masaranew.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ClassListAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	Context context;
	ArrayList<TrainingClassHdr> fruitCountDatas;

	public ClassListAdapter(Context context,
			ArrayList<TrainingClassHdr> meetingDatas) {
		this.context = context;
		this.fruitCountDatas = meetingDatas;
	}

	@Override
	public int getCount() {
		return fruitCountDatas.size();
	}

	@Override
	public TrainingClassHdr getItem(int position) {
		return fruitCountDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			mInflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = mInflater.inflate(R.layout.list_item_class,
						null);
			holder = new ViewHolder();
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
			holder.tvSubTitle = (TextView) convertView.findViewById(R.id.tvSubTitle);
			holder.rlHolder  = (RelativeLayout) convertView.findViewById(R.id.rlHolder);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		TrainingClassHdr contractData = null;
		try {
			contractData = fruitCountDatas.get(position);
		} catch (Exception e) {
			e.printStackTrace();
		} 

		if (contractData != null) {
			holder.tvSubTitle.setText("( " + getCropName(contractData) + " )" );
			holder.tvTitle.setText(contractData.Name);
		}
		return convertView;
	}
	
	private String getCropName(TrainingClassHdr data) {
		Databases db = new Databases(context);
		Crop crop = Crop.getAnObject(db, data.CropId);
		db.close();
		return crop.CropName;
	}


	public static class ViewHolder {
		public TextView tvTitle;
		public TextView tvSubTitle;
		public RelativeLayout rlHolder;
	}

}
