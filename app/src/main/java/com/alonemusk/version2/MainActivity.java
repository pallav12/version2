package com.alonemusk.version2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout ll;
   ArrayList<CheckCheck> cc;
    ArrayList<CheckCheck> cb;
   ArrayList<String>ss;
   int i;
    Toolbar tb;
   FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=0;
        cc=new ArrayList<>();
        fab=(FloatingActionButton) findViewById(R.id.fab);
        tb=new Toolbar(getApplicationContext());

        ss=new ArrayList<>();


        ll=(LinearLayout) findViewById(R.id.ll);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Intent intent=new Intent(getApplicationContext(),editText.class);
                startActivityForResult(intent,1);
                Log.d("hell","jello"+i);



            }
        });

    }


    void Onclick(ArrayList<CheckCheck>cc){
        for(int i=0;i<cc.size();i++){
        cc.get(i).show(ll,getApplicationContext(),cc,i);}
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if((requestCode==1) && (resultCode==RESULT_OK)){

            String res=data.getStringExtra("h");
            cb=new ArrayList<>();
            cb.add(new CheckCheck(res));
            cc.add(cb.get(cb.size()-1));
            ll.removeAllViews();


            Onclick(cc);

        }
    }






}
