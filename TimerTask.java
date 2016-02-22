

Timer timer = new Timer();
timer.schedule(new UIUpdateTimer(),1, 250);


 private class UIUpdateTimer extends TimerTask {
	   	    @Override
	   	    public void run() {
	   	    	
	   	     runOnUiThread(new Runnable() { 
			     @Override 
			     public void run() { 
			    	 
			    	 //Update UI from here
			    	 
			     }
		   	     });
	   	    }
}
