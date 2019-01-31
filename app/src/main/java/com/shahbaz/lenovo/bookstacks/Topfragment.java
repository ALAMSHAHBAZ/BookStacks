package com.shahbaz.lenovo.bookstacks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lenovo on 7/15/2017.
 */

public class Topfragment extends Fragment
{
    TextView txt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v= inflater.inflate(R.layout.activity_topfragment,container,false);

        txt=(TextView) v.findViewById(R.id.txt);

        return  v;
    }
}
