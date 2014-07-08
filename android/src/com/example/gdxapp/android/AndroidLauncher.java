package com.example.gdxapp.android;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.example.gdxapp.MyGdxApp;

public class AndroidLauncher extends AndroidApplication {
	
	String userImagePath = null;
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new MyGdxApp(new AndroidGalleryOpener(this)), config);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode == RESULT_OK && requestCode == AndroidGalleryOpener.SELECT_IMAGE_CODE) {
			Uri imageUri = data.getData();
			this.userImagePath = getPath(imageUri);
			Gdx.app.log("AndroidGalleryOpener", "Image path is " + userImagePath);
			
		}
		//super.onActivityResult(requestCode, resultCode, data);
	}
	
	private String getPath(Uri uri) {
		
		if(uri.getScheme().equalsIgnoreCase("file")){
			return uri.getPath();
		}
        
        Cursor cursor = getContentResolver().query(uri, new String[] { MediaStore.Images.Media.DATA } , null, null, null);
        
        if (cursor == null) {
        	return null;
        }
        
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        
        String filePath = cursor.getString(column_index);
        
        cursor.close();
        
        return filePath;
        
    }

}
