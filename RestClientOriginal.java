package com.cynere.network;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class RestClient {



	public static String Get(String URLStr) throws Exception {
		 	
			String resultStr = "";
	        BufferedReader in = null;
	        try {
	            HttpClient client = new DefaultHttpClient();
	            HttpGet request = new HttpGet(URLStr);
	            HttpResponse response = client.execute(request);
	            in = new BufferedReader
	            (new InputStreamReader(response.getEntity().getContent()));
	            StringBuffer sb = new StringBuffer("");
	            String line = "";
	            String NL = System.getProperty("line.separator");
	            while ((line = in.readLine()) != null) {
	                sb.append(line + NL);
	            }
	            in.close();
	            resultStr = sb.toString();
	          } catch(Exception ee) {
	        		ee.printStackTrace();
	            } finally {
	        		if (in != null) {
		                try {
		                    in.close();
		                } catch (Exception e) {}
	        		}
	        }
	        return resultStr;
	 }

	/**
	 * Call a post method.
	 * @param url post url
	 * @param nameValuePair parameter list in NameValuePair
	 */
	public String callPostMethod( String url, List<NameValuePair> nameValuePair) {
		
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost req = new HttpPost(url);
		
		try {
			
			req.setEntity(new UrlEncodedFormEntity(nameValuePair));
			HttpResponse response = client.execute(req);
			HttpEntity entity = response.getEntity();
		   
			String result = EntityUtils.toString(entity);
		   
			return result;
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	/**
	 * Download a file.
	 * @param fileName Filename to store
	 * @param fileUrl  
	 * 
	 */
	public boolean Download(String fileName, String fileUrl, String DestPath) {
		
		 HttpURLConnection urlConnection = null;
		 FileOutputStream fileOutput = null;
		 int totalSize = -1;
		 int downloadedSize = 0;
		 try {
				URL url = new URL(fileUrl);
				urlConnection = (HttpURLConnection) url.openConnection();
				urlConnection.setRequestMethod("GET");
				urlConnection.connect();
				File file = new File(DestPath, fileName);
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
	

}
