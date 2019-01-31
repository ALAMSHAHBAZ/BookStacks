package com.shahbaz.lenovo.bookstacks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.MobileAds;

public class UserSession extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences.Editor se;
    Boolean Registered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_session);

       MobileAds.initialize(this, "ca-app-pub-9339586260563180/6844395288");

        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Registered = sharedPref.getBoolean("Registered", false);


        if (Registered==true)
        {
            startActivity(new Intent(this,SplashScreen.class));
        }else {
            startActivity(new Intent(this,SplashScreen.class));
        }
    }
}
