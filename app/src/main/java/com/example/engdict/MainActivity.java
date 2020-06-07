package com.example.engdict;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    GridView gridview;
    Button practiceButton;
    Intent practiceIntent;
    Intent statisticsIntent;
    Intent searchItent;
    Bundle extras;

    int chosenItem = -1;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        extras = new Bundle();
        practiceIntent = new Intent(this, PracticeActivity.class);
        statisticsIntent = new Intent(this,StatisticsActivity.class);
        searchItent= new Intent(this, SearchActivity.class);

        gridview = (GridView) findViewById(R.id.grid);
        gridview.setAdapter(new ButtonAdapter(this, StringArrays.tenseList));
        practiceButton = (Button) findViewById(R.id.practice);
        practiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPracticeOptions();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.statistic:
                startActivity(statisticsIntent);
                return true;
            case R.id.search:
                startActivity(searchItent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
//
    }
    void showPracticeOptions(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Mode:");
        alert.setCancelable(false);
        alert.setSingleChoiceItems(StringArrays.practiceItems,-1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                chosenItem = i;
            }
        });
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(chosenItem==0){
                    chosenItem = -1;
                    extras.putInt("mode",0);
                    practiceIntent.putExtras(extras);
                    startActivity(practiceIntent);
                    finish();

                }else if(chosenItem==1){
                    chosenItem = -1;
                    showTimeModeOptions();
                }else if(chosenItem==2){
                    chosenItem = -1;
                    extras.putInt("mode",2);
                    practiceIntent.putExtras(extras);
                    startActivity(practiceIntent);
                    finish();
                }else if(chosenItem==-1){
                    chosenItem =-1;
                    showPracticeOptions();
                    Toast.makeText(getApplicationContext(),"Select a practice mode!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                chosenItem = -1;
                dialogInterface.cancel();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
    void showTimeModeOptions(){
        final AlertDialog.Builder timeAlert = new AlertDialog.Builder(this);
        timeAlert.setTitle("Choose a time:");
        timeAlert.setCancelable(false);

        timeAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                chosenItem = -1;
                dialogInterface.cancel();
            }
        });
        timeAlert.setSingleChoiceItems(StringArrays.timeItems,-1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                chosenItem = i;
            }
        });
        timeAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch(chosenItem){
                    case -1:
                        chosenItem = -1;
                        showTimeModeOptions();
                        Toast.makeText(getApplicationContext(),"Choose a time!",Toast.LENGTH_SHORT).show();
                        break;
                    case 0:
                        chosenItem = -1;
                        extras.putInt("mode",1);
                        extras.putInt("time",30000);
                        practiceIntent.putExtras(extras);
                        startActivity(practiceIntent);
                        finish();
                        break;
                    case 1:
                        chosenItem = -1;
                        extras.putInt("mode",1);
                        extras.putInt("time",60000);
                        practiceIntent.putExtras(extras);
                        startActivity(practiceIntent);
                        finish();
                        break;
                    case 2:
                        chosenItem = -1;
                        extras.putInt("mode",1);
                        extras.putInt("time",120000);
                        practiceIntent.putExtras(extras);
                        startActivity(practiceIntent);
                        finish();
                        break;
                }
            }
        });
        timeAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                chosenItem = -1;
                dialogInterface.cancel();
            }
        });
        AlertDialog dialog = timeAlert.create();
        dialog.show();
    }
}
