package com.SBL.eDinette;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;

public class FileContentProvider extends ContentProvider {
       private static final String URI_PREFIX = "content://com.SBL.eDinette.filecontentprovider";

       public static String constructUri(String url) {
           Uri uri = Uri.parse(url);
           return uri.isAbsolute() ? url : URI_PREFIX + url;
       }
       

       @Override
       public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
//           URI uri1 = URI.create("file:///data/data/com.SBL.eDinette/files/Img/promotion.pdf"); 
           URI uri1 = URI.create("file:/" + uri.getPath()); 
           Log.d("XX12XXXXX","file:/"+ uri.getPath() );
           File file = new File(uri1.getPath());
           ParcelFileDescriptor parcel = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY);
           return parcel;
           
           
           
//           try {
//   			AssetManager am = ctx.getAssets();
//   			InputStream is = am.open("file.pdf");
//   			File dir = new File("data/data/package.name/files/");
//   			dir.mkdirs();
//   			File file = new File("data/data/package.name/files/outFile.pdf");
//   			file.createNewFile();
//   			OutputStream out=new FileOutputStream(file);
//   			byte buf[]=new byte[1024];
//   			int len;
//   			while((len=is.read(buf))>0)
//   				out.write(buf,0,len);
//   			out.close();
//   			is.close();
//   			parcel = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_WRITE);
//   		}
//   		catch (Exception e) {
//   			Log.e("Exception",e.toString());
//   		}
//    
//   		return parcel;
       }

       @Override
       public boolean onCreate() {
           return true;
       }

       @Override
       public int delete(Uri uri, String s, String[] as) {
           throw new UnsupportedOperationException("Not supported by this provider");
       }

       @Override
       public String getType(Uri uri) {
           throw new UnsupportedOperationException("Not supported by this provider");
       }

       @Override
       public Uri insert(Uri uri, ContentValues contentvalues) {
           throw new UnsupportedOperationException("Not supported by this provider");
       }

       @Override
       public Cursor query(Uri uri, String[] as, String s, String[] as1, String s1) {
           throw new UnsupportedOperationException("Not supported by this provider");
       }

       @Override
       public int update(Uri uri, ContentValues contentvalues, String s, String[] as) {
           throw new UnsupportedOperationException("Not supported by this provider");
       }

    }