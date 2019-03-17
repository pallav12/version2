package com.alonemusk.version2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import java.util.ArrayList;


public class CheckCheck extends MainActivity {
    private String text;
    private String id;
    private Toolbar tb;

    int j;




    public CheckCheck(String text) {
        this.text = text;
    }

    void show(LinearLayout ll, Context ct, ArrayList<CheckCheck>cc,int i){
         tb=new Toolbar(ct);

        tb.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tb.setBackgroundColor(Color.parseColor("#f4f4f4"));
        tb.setPadding(8,8,8,8);




        CheckBox checkBox=new CheckBox(ct);
        checkBox.setText(text);
        checkBox.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


        tb.addView(checkBox);
        tb.inflateMenu(R.menu.menu);
        ll.addView(tb);
        onclick(cc,i,ct);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }

    public String getText() {
        return text;
    }
    public Toolbar getTb(){
        return tb;


    }

    public void setText(String text) {
        this.text = text;
        this.tb=tb;
       j=i;
    }

    void onclick(final ArrayList<CheckCheck>cc, final int i, final Context ct){
        tb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.delete:
                            cc.remove(i);
                            Log.d("hello","jello"+i);
                        ((ViewGroup) tb.getParent()).removeView(tb);

                        break;
                }
                return true;
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
