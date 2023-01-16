package com.example.fragmentinter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t1, t2;
    View v;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.switchbtn);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction t = manager.beginTransaction();
        Myfragment1 f1 = new Myfragment1();
        Myfragment2 f2 = new Myfragment2();
        Myfragment3 f3 = new Myfragment3();
        t.add(R.id.frame1,f1);
        t.add(R.id.frame2,f2);
        t.add(R.id.frame3,f3);
        t.commit();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences spp = getSharedPreferences("username", Context.MODE_PRIVATE);
                String msg = spp.getString("name","");
                //SharedPreferences spp1 = getSharedPreferences("userage", Context.MODE_PRIVATE);
                String age = spp.getString("age","");
                ((TextView)findViewById(R.id.activitytxt1)).setText("Username :" + msg);
                ((TextView)findViewById(R.id.activitytxt2)).setText("UserAge:" + age);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction t1 = fm.beginTransaction();
                Myfragment2 mf2 = new Myfragment2();
                Bundle b1 = new Bundle();
                b1.putString("name",msg);
                b1.putString("age",age);
                mf2.setArguments(b1);
                t1.add(R.id.frame2,mf2);
                t1.commit();
            }
        });
    }
    public void f1(String name, String age) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction t1 = fm.beginTransaction();
        Myfragment3 mf3 = new Myfragment3();
        Bundle b1 = new Bundle();
        b1.putString("name",name);
        b1.putString("age",age);
        mf3.setArguments(b1);
        t1.add(R.id.frame3,mf3);
        t1.commit();
    }
    public void someEvent(String s, String ss){
        SharedPreferences sp = getSharedPreferences("username", Context.MODE_PRIVATE);
        //SharedPreferences sp1 = getSharedPreferences("userage", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        //SharedPreferences.Editor editor1 = sp1.edit();
        editor.putString("name",s.toString().trim());
        editor.putString("age",ss.toString().trim());
        editor.apply();
        //editor1.apply();
        Toast.makeText(getApplicationContext(), "Saved Successfully", Toast.LENGTH_SHORT).show();
    }
}