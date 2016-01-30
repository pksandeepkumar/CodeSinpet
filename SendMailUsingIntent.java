public void feedback(View view) {
		
		Intent emailIntent = new Intent(Intent.ACTION_SEND); 
	  	String []emails = {"texusapps@gmail.com"};
		emailIntent .setType("message/rfc822");
		emailIntent.putExtra(Intent.EXTRA_EMAIL, emails); 
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My Places: Feedback"); 
		emailIntent.putExtra(Intent.EXTRA_TEXT, ""); 
		startActivity(Intent.createChooser(emailIntent, "Send e-mail"));
	}
