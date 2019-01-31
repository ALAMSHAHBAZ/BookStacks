package com.shahbaz.lenovo.bookstacks;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class HomePage extends AppCompatActivity  {
    private AdView mAdView;
    SharedPreferences sp;
    SharedPreferences.Editor se;
    TextView txt;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        sp = getSharedPreferences("logininfo", MODE_PRIVATE);
        txt=(TextView)findViewById(R.id.txt);
        name=sp.getString("name"," ");
        txt.setText("Welcome "+" "+name);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.i("Ads", "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.i("Ads", "onAdFailedToLoad");
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.i("Ads", "onAdOpened");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.i("Ads", "onAdLeftApplication");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
                Log.i("Ads", "onAdClosed");
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.basic, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings)
        {
            Intent i=new Intent(this,AboutUs.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void logout(View v)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(HomePage.this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
        Intent i=new Intent(this,LoginActivity.class);
        startActivity(i);

    }
public void buynew(View v)
{
    Intent i=new Intent(this,NewBook.class);
    startActivity(i);
}

    public void buyold(View v)
    {
        Intent i=new Intent(this,OldBook.class);
        startActivity(i);
    }


    public void contact(View v)
    {
        Intent i=new Intent(this,ContactUs.class);
        startActivity(i);
    }

    public void donate(View v)
    {
        Intent i=new Intent(this,DonateBook.class);
        startActivity(i);
    }
public  void rate(View v)
{
    try {
        Uri marketUri = Uri.parse("market://details?id=" + getPackageName());
        Intent marketIntent = new Intent(Intent.ACTION_VIEW, marketUri);
        startActivity(marketIntent);
    }catch(ActivityNotFoundException e) {
        Uri marketUri = Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName());
        Intent marketIntent = new Intent(Intent.ACTION_VIEW, marketUri);
        startActivity(marketIntent);
    }
}
public void share(View v)
{
    try {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "BookStacks");
        String sAux = "\nLet me recommend you this application\n BUY | DONATE | HIRE" +
                " all kinds of OLD | NEW | USED | SECOND HAND books\n";
        sAux = sAux + "https://play.google.com/store/apps/details?id=com.shahbaz.lenovo.bookstacks \n\n";
        i.putExtra(Intent.EXTRA_TEXT, sAux);
        startActivity(Intent.createChooser(i, "choose one"));
    } catch(Exception e) {
        e.toString();
    }
}

}
