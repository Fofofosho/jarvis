package com.uXperience.jarvis;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageButton weatherBtn;
    private ImageButton musicBtn;
    private ImageButton mapsBtn;
    private Camera cameraObject;
    private ShowCamera showCamera;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//initialize items
        cameraObject = getCameraInstance();
        showCamera = new ShowCamera(this, cameraObject);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(showCamera);

        weatherBtn = (ImageButton) findViewById(R.id.weatherButton);
        weatherBtn.setOnClickListener(this);

        musicBtn = (ImageButton) findViewById(R.id.musicButton);
        musicBtn.setOnClickListener(this);

        mapsBtn = (ImageButton) findViewById(R.id.mapButton);
        mapsBtn.setOnClickListener(this);

	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

    @Override
	public void onClick(View v) {

        if(v == weatherBtn) {
            Intent intent = new Intent(this, WeatherActivity.class);
            startActivity(intent);
        } else if(v == musicBtn) {
            //This launches music app on phone. For me it launched Google Music,
            //  which contained an album that I have on my phone
            Intent intent = new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);
            startActivity(intent);
        } else if(v == mapsBtn) {
            Intent intent = new Intent(this, WeatherActivity.class);
            startActivity(intent);
        }

	}

    public static Camera getCameraInstance(){
        Camera object = null;
        try {
            object = Camera.open();
        }
        catch (Exception e){
        }
        return object;
    }

}
