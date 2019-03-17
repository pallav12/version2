package com.alonemusk.version2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class editText extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
         editText=(EditText) findViewById(R.id.editText);
    }

    public void Onclick(View v){
        Intent i=new Intent();
        String  ss=editText.getText().toString();

        i.putExtra("h",ss);
        setResult(RESULT_OK,i);
        finish();

    }

}

