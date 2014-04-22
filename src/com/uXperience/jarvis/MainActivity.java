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

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageButton weatherBtn;
    private ImageButton musicBtn;
    private ImageButton mapsBtn;
    private SurfaceView sView;

    private Camera hCamera;
    private CameraPreview cPreview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//initialize items
        hCamera = getCameraInstance();

        weatherBtn = (ImageButton) findViewById(R.id.weatherButton);
        weatherBtn.setOnClickListener(this);

        musicBtn = (ImageButton) findViewById(R.id.musicButton);
        musicBtn.setOnClickListener(this);

        mapsBtn = (ImageButton) findViewById(R.id.mapButton);
        mapsBtn.setOnClickListener(this);

        // Create our Preview view and set it as the content of our activity.
        cPreview = new CameraPreview(this, hCamera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);

        sView = (SurfaceView) findViewById(R.id.surfaceView);

        cPreview.surfaceCreated(sView.getHolder());
        preview.addView(cPreview);
	}

    private boolean safeCameraOpenInView(View view) {
        boolean qOpened = false;
        releaseCameraAndPreview();
        hCamera = getCameraInstance();
        qOpened = (hCamera != null);
        cPreview = new CameraPreview(getActivity().getBaseContext(), hCamera);
        FrameLayout preview = (FrameLayout) view.findViewById(R.id.camera_preview);
        preview.addView(cPreview);
        return qOpened;
    }

    private void releaseCameraAndPreview() {

        if (hCamera != null) {
            hCamera.stopPreview();
            hCamera.release();
            hCamera = null;
        }
        if(cPreview != null){
            cPreview.destroyDrawingCache();
            cPreview.hCamera = null;
        }
    }
    
    /** A safe way to get an instance of the Camera object. */
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
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
//            Intent intent = new Intent(this, WeatherActivity.class);
//            startActivity(intent);
        }

	}

}
