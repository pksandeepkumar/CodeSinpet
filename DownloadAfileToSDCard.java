/**
	 * Download a file.
	 * @param fileName Filename to store
	 * @param fileUrl  
	 * 
	 */
	public boolean Download(String fileName, String fileUrl, String DestBasePath) {
		
		 HttpURLConnection urlConnection = null;
		 FileOutputStream fileOutput = null;
		 int totalSize = -1;
		 int downloadedSize = 0;
		 try {
				URL url = new URL(fileUrl);
				urlConnection = (HttpURLConnection) url.openConnection();
				urlConnection.setRequestMethod("GET");
				urlConnection.connect();
				File file = new File(DestBasePath, fileName);
				fileOutput = new FileOutputStream(file);
				InputStream inputStream = urlConnection.getInputStream();
				totalSize = urlConnection.getContentLength();
				downloadedSize = 0;
				byte[] buffer = new byte[1024];
				int bufferLength = 0; 
				while ( (bufferLength = inputStream.read(buffer)) > 0 ) {
					fileOutput.write(buffer, 0, bufferLength);
					downloadedSize += bufferLength;
				}
			} catch (Exception e) {
			} finally {
				if (null != fileOutput) {
					try {
						fileOutput.close();
					} catch (Exception e111) {
					}
				}

				if (null != urlConnection) {
					urlConnection.disconnect();
				}
				
			}
			
			if (totalSize == downloadedSize) {
				return true;
			}
			else {
				return false;
			}
	 }
