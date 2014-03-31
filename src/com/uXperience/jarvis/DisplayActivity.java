package com.uXperience.jarvis;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;


/**
 * Created by Forrest on 3/30/2014.
 */
public class DisplayActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
    }

    public void closeActivity(View view) {
        finish();
    }

    public void launchNewActivity(View view) {
        finishActivity(CONTEXT_INCLUDE_CODE);

    }
}