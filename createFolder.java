private void createFolder() {
		File imageDirectory =  new File(BASE_PATH);
		if (null != imageDirectory) {
			
			if (!imageDirectory.exists()){
				imageDirectory.mkdir();
			}
		}
	}
