package com.uXperience.jarvis;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageButton weatherBtn;
    private ImageButton musicBtn;
    private ImageButton mapsBtn;
    private SurfaceView sView;
    private Camera cameraObject;
    private ShowCamera showCamera;
    private ImageView pic;

    public static Camera isCameraAvailiable(){
        Camera object = null;
        try {
           object = Camera.open(); 
        }
        catch (Exception e){
        }
        return object; 
     }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		pic = (ImageView)findViewById(R.id.imageView1);
	      cameraObject = isCameraAvailiable();
	      showCamera = new ShowCamera(this, cameraObject);
	      FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
	      preview.addView(showCamera);
		
		//initialize items


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

}
