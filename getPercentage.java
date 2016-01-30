private int getPercentage(int value, int totalValue) {
		
		if( value == 0 || totalValue == 0) {
			return 0;
		}
		int percentage = 0;
		percentage = (value * 100) / totalValue;
		return percentage;
		
	}
