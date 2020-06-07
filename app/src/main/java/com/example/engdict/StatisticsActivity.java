package com.example.engdict;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.engdict.StringArrays.STAT_ITEMS;
import static com.example.engdict.StringArrays.tenseList;
import static com.example.engdict.StringArrays.STAT_ITEMS;
import static com.example.engdict.StringArrays.tenseList;

public class StatisticsActivity extends AppCompatActivity {
    ListView statList;
    ArrayAdapter<String> listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_statistics);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setTitle("Statistics");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        statList = (ListView)findViewById(R.id.statList);
        listAdapter = new ArrayAdapter<String>(this,R.layout.stat_list_item,STAT_ITEMS);
        statList.setAdapter(listAdapter);
        statList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        openStatDialog(i);
                        break;
                    case 1:
                        openStatDialog(i);
                        break;
                    case 2:
                        openStatDialog(i);
                        break;
                    case 3:
                        openStatDialog(i);
                        break;
                    case 4:
                        openStatDialog(i);

                        break;
                }
            }
        });

    }
    void openStatDialog(int item){

        if(item==0){
            AlertDialog.Builder builder = new AlertDialog.Builder(StatisticsActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.statistic_dialog,null);
            builder.setCancelable(true);
            builder.setView(mView);
            TextView combo = (TextView)mView.findViewById(R.id.bestCombo);
            TextView ratio = (TextView)mView.findViewById(R.id.bestRatio);
            TextView needToWork = (TextView)mView.findViewById(R.id.problemTense);
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
            int topCombo = pref.getInt("NORMAL_COMBO",0);
            combo.setText("Maximum Combo : "+topCombo);
            ratio.setText("The best ratio in right/wrong: "+2.5);
            needToWork.setText("Time to work on: "+tenseList[0]);
            final AlertDialog dialog = builder.create();
            dialog.show();
        }else if(item==1){
            AlertDialog.Builder builder = new AlertDialog.Builder(StatisticsActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.statistic_dialog,null);
            builder.setCancelable(true);
            builder.setView(mView);
            TextView combo = (TextView)mView.findViewById(R.id.bestCombo);
            combo.setVisibility(View.INVISIBLE);
            final AlertDialog dialog = builder.create();
            dialog.show();
        }else if(item==2){
            AlertDialog.Builder builder = new AlertDialog.Builder(StatisticsActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.statistic_dialog,null);
            builder.setCancelable(true);
            builder.setView(mView);
            TextView combo = (TextView)mView.findViewById(R.id.bestCombo);
            combo.setVisibility(View.INVISIBLE);
            final AlertDialog dialog = builder.create();
            dialog.show();
        }
        else if(item==3){
            AlertDialog.Builder builder = new AlertDialog.Builder(StatisticsActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.statistic_dialog,null);
            builder.setCancelable(true);
            builder.setView(mView);
            TextView combo = (TextView)mView.findViewById(R.id.bestCombo);
            combo.setVisibility(View.INVISIBLE);
            final AlertDialog dialog = builder.create();
            dialog.show();
        }
        else if(item==4){
            AlertDialog.Builder builder = new AlertDialog.Builder(StatisticsActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.statistic_dialog,null);
            builder.setCancelable(true);
            builder.setView(mView);
            TextView combo = (TextView)mView.findViewById(R.id.bestCombo);
            combo.setVisibility(View.INVISIBLE);
            final AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}