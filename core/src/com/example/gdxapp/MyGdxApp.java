package com.example.gdxapp;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxApp extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	GalleryOpener galleryOpener;
	String imagePath;
	
	public MyGdxApp(GalleryOpener opener){
		this.galleryOpener = opener;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
		
		if(Gdx.input.justTouched()){
			galleryOpener.getGalleryImagePath();
		}
	}
}
