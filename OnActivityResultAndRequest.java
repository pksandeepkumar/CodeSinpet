
//Calling 
Intent i = new Intent(getApplicationContext(), AddGoodOrBadActivity.class);
		i.putExtra(PARAM_ADD_TYPE,GOOD);
		startActivityForResult(i, REQUEST_CODE_FOR_ADD);
//On activity result

@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == REQUEST_CODE_FOR_ADD) {
	        if (resultCode == RESULT_OK) {
	        	setValues();
	        }
	    }
	}

//On other activity
Intent i = new Intent();

				setResult(RESULT_OK, i);

				finish();


