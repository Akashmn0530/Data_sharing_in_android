package com.example.fragmentinter;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Myfragment3 extends Fragment {
    TextView t1,t2;
    Button b3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_myfragment3, container, false);
        t1 = v.findViewById(R.id.frag3txt);
        t2 = v.findViewById(R.id.frag3txt2);
        b3 = v.findViewById(R.id.frag3btn1);
        Bundle b2 = getArguments();
        if(b2!=null){
            String name = b2.getString("name");
            String age = b2.getString("age");
            t1.setText(name);
            t2.setText(age);
            Toast.makeText(this.getActivity().getApplicationContext(), "Passed to Fragment3 Successfully", Toast.LENGTH_SHORT).show();

        }
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = t1.getText().toString();
                String age1 = t2.getText().toString();
                MainActivity mn1 = (MainActivity) getActivity();
                mn1.someEvent(name1,age1);
            }
        });
        return v;
    }
}