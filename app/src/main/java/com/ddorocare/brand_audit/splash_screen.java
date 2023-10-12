package com.ddorocare.brand_audit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Intent i = new Intent(this,MainActivity.class);
        i.putExtra(AlarmClock.EXTRA_LENGTH, 2000);
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
        else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
}