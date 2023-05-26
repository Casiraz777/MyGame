package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void clickexit(View view) {
        this.finish();
    }
    public void clickstart(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityGame.class);
        startActivity(intent);
    }

    public void clickabout(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityAbout.class);
        startActivity(intent);
    }

    public void clickscore(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityScore.class);
        startActivity(intent);
    }
}