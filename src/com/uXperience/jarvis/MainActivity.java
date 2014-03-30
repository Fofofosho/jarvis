package com.uXperience.jarvis;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.Menu;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button button1;
	private View MenuDetails;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//initialize button
		button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(this);

		
		MenuDetails = (View)findViewById(R.id.listview_background_shape);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if (v == button1){
			MenuDetails.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
		}
		
	}

}
