package com.cynere.task;


public class Task extends AsyncTask<Void, Void, Void> {
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}
	
	public Task() {
	}
	   
	@Override
	protected Void doInBackground(Void... params) {
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
	}
}
