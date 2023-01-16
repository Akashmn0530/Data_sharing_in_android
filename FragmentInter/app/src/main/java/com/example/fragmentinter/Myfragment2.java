package com.example.fragmentinter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Myfragment2 extends Fragment {
    TextView t1,t2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_myfragment2, container, false);
        t1 = v.findViewById(R.id.frag2txt);
        t2 = v.findViewById(R.id.frag2txt2);
        Bundle b2 = getArguments();
        if(b2!=null){
            String name = b2.getString("name");
            String age = b2.getString("age");
            t1.setText(name);
            t2.setText(age);
        }
        return v;
    }
}