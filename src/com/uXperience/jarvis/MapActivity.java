package com.uXperience.jarvis;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Charles on 4/22/2014.
 */
public class MapActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

}