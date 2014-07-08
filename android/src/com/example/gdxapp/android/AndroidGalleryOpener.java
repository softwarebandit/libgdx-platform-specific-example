package com.example.gdxapp.android;

import android.app.Activity;
import android.content.Intent;

import com.badlogic.gdx.Gdx;
import com.example.gdxapp.GalleryOpener;

public class AndroidGalleryOpener implements GalleryOpener {
	
	Activity activity;
	public static final int SELECT_IMAGE_CODE = 1;
	
	public AndroidGalleryOpener(Activity activity){
		this.activity = activity;
	}

	@Override
	public void getGalleryImagePath() {
		
		Intent intent = new Intent();
		intent.setType("image/*");
		intent.setAction(Intent.ACTION_GET_CONTENT);
		activity.startActivityForResult(Intent.createChooser(intent, "Select Users Image"), SELECT_IMAGE_CODE);

	}

}
