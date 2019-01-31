package com.shahbaz.lenovo.bookstacks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lenovo on 7/15/2017.
 */

public class Bottomfragment extends Fragment
{
    TextView txt;
    Button btn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v= inflater.inflate(R.layout.activity_bottomfragment,container,false);

        txt=(TextView) v.findViewById(R.id.txt);
        btn=(Button)v.findViewById(R.id.btn);
       btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getActivity(),Donate.class);
                startActivity(i);
            }
        });

        return  v;
    }
}
