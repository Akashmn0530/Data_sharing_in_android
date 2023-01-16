package com.example.fragmentinter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Myfragment1 extends Fragment {
    EditText e1,e2;
    Button b;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_myfragment1, container, false);
        e1 = v.findViewById(R.id.txtname);
        e2 = v.findViewById(R.id.txtage);
        b = v.findViewById(R.id.pass);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = e1.getText().toString();
                String age = e2.getText().toString();
                MainActivity mn = (MainActivity) getActivity();
                mn.f1(name,age);
            }
        });
        return v;
    }
}