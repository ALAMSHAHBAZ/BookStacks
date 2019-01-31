package com.shahbaz.lenovo.bookstacks;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DonateBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_book);
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.top,new Topfragment());
        ft.commit();

        getSupportFragmentManager().beginTransaction().replace(R.id.bottom,new Bottomfragment()).commit();

    }
}
