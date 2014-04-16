package com.uXperience.jarvis;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageButton weatherBtn;
    private ImageButton musicBtn;
    private ImageButton mapsBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
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
//            Intent intent = new Intent(this, WeatherActivity.class);
//            startActivity(intent);
        } else if(v == mapsBtn) {
//            Intent intent = new Intent(this, WeatherActivity.class);
//            startActivity(intent);
        }

	}

}
