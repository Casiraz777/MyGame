package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityGameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        scores();
    }
    public void scores(){
        int points = getIntent().getIntExtra("POINTS", 0);
        TextView scoreTextView = findViewById(R.id.textView2);
        scoreTextView.setText(String.valueOf(points));
    }
    public void clickNumber(View view) {
        this.finish();
    }
}