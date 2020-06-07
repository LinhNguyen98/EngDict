package com.example.engdict;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class    MyOnClickListener implements View.OnClickListener
        {
private final int position;
private Context context;
        Intent theoryIntent;
private String[]tensList;

public MyOnClickListener(int position, Context context,String[]tensesList)
        {   this.context = context;
        this.position = position;
        this.tensList = tensesList;
        theoryIntent = new Intent(context,InfoActivity.class);
        }

public void onClick(View v)
        {
        theoryIntent.putExtra("title",tensList[position]);
        context.startActivity(theoryIntent);
        }
        }