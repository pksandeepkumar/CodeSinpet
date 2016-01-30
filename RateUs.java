public void reteUsTask(View view) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("market://details?id=com.texus.iasquiz"));
		startActivity(intent);
	}
