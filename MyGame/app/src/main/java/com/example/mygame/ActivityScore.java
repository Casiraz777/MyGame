package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityScore extends AppCompatActivity {

    private SharedPreferences pref;
    private final static String KEY0 = "0";
    private final static String KEY1 = "1";
    private final static String KEY2 = "2";
    private final static String KEY3 = "3";
    private final static String KEY4 = "4";
    private final static String KEY5 = "5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        int points = getIntent().getIntExtra("POINTS", 0);
        pref = getSharedPreferences("Table", MODE_PRIVATE);
        if(points != 0){
            saveData(points);
        }
        Viewscore();

    }

    private void saveData(int dataToSave){
        SharedPreferences.Editor editor = pref.edit();
        if(dataToSave > pref.getInt(KEY0, 0)){
            editor.putInt(KEY0, dataToSave);
            editor.apply();
        }
        editor.putInt(KEY5,pref.getInt(KEY4, 0));
        editor.apply();
        editor.putInt(KEY4,pref.getInt(KEY3, 0));
        editor.apply();
        editor.putInt(KEY3,pref.getInt(KEY2, 0));
        editor.apply();
        editor.putInt(KEY2,pref.getInt(KEY1, 0));
        editor.apply();
        editor.putInt(KEY1,dataToSave);
        editor.apply();
    }
    private void Viewscore(){
        TextView bestscore = findViewById(R.id.besttextView);
        TextView lastscore = findViewById(R.id.last5textView);
        bestscore.setText(String.valueOf(pref.getInt(KEY0, 0)));
        lastscore.setText("1. " + String.valueOf(pref.getInt(KEY1, 0)) + "\n" +
                "2. " + String.valueOf(pref.getInt(KEY2, 0)) + "\n" +
                "3. " + String.valueOf(pref.getInt(KEY3, 0)) + "\n" +
                "4. " + String.valueOf(pref.getInt(KEY4, 0)) + "\n" +
                "5. " + String.valueOf(pref.getInt(KEY5, 0)) + "\n");
    }

    public void clickbackmenu(View view) {
        finish();
    }
}