package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.os.CountDownTimer;

public class ActivityGame extends AppCompatActivity {

    EditText prans;
    TextView exam, errors;

    int level = 1;
    int anscorr = 0;
    int err = 0;

    int points = 0;

    long remainingTime;
    CountDownTimer gameTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        exam = findViewById(R.id.textexample);
        errors = findViewById(R.id.texterr);
        prans = findViewById(R.id.inputanswer);
        generator(level);
        startGameTimer();
        errors.setText(err + "/3");
    }

    public void clickNumber(View view) {
        String ans = prans.getText().toString();
        if(view.getId() == R.id.btn0) {
            ans = ans + "0";
        }
        if(view.getId() == R.id.btn1) {
            ans = ans + "1";
        }
        if(view.getId() == R.id.btn2) {
            ans = ans + "2";
        }
        if(view.getId() == R.id.btn3) {
            ans = ans + "3";
        }
        if(view.getId() == R.id.btn4) {
            ans = ans + "4";
        }
        if(view.getId() == R.id.btn5) {
            ans = ans + "5";
        }
        if(view.getId() == R.id.btn6) {
            ans = ans + "6";
        }
        if(view.getId() == R.id.btn7) {
            ans = ans + "7";
        }
        if(view.getId() == R.id.btn8) {
            ans = ans + "8";
        }
        if(view.getId() == R.id.btn9) {
            ans = ans + "9";
        }
        if(view.getId() == R.id.btnYes) {
            try {
                if(Integer.parseInt(ans) == anscorr){
                    generator(level);
                    diff((int) remainingTime, level);
                    gameTimer.cancel();
                    startGameTimer();
                }
                else {
                    generator(level);
                    err = err + 1;
                    if(err == 3){
                        err = 0;
                        gameTimer.cancel();
                        Intent intentsc = new Intent(ActivityGame.this, ActivityScore.class);
                        intentsc.putExtra("POINTS", points);
                        startActivity(intentsc);
                        finish();
                        Intent intent = new Intent(ActivityGame.this, ActivityGameOver.class);
                        intent.putExtra("POINTS", points);
                        startActivity(intent);
                        finish();
                    }
                    errors.setText(err + "/3");
                }
                ans = "";
            }
            catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        if(view.getId() == R.id.btnNo) {
            ans = "";
        }
        prans.setText(ans);
    }

    public void generator(int level){

        int a, b, c, sign;

        if(level == 1){
            sign = (int) (Math.random()*2);
            if(sign == 0){
                a = (int) (Math.random()*10);
                b = (int) (Math.random()*10);
                exam.setText(a + " + " + b + "=");
                anscorr = a + b;

            }
            if(sign == 1){
                a = (int) (Math.random()*10);
                b = (int) (Math.random()*10);
                if(a<b){
                    int z = a;
                    a = b;
                    b = z;
                }
                exam.setText(a + "-" + b + "=");
                anscorr = a - b;

            }
        }
        if(level == 2) {
            sign = (int) (Math.random() * 2);
            if (sign == 0) {
                sign = (int) (Math.random() * 2);
                if (sign == 0) {
                    a = (int) (Math.random() * 10);
                    b = (int) (Math.random() * 10);
                    c = (int) (Math.random() * 10);
                    exam.setText(a + "+" + b + "+" + c + "=");
                    anscorr = a + b + c;
                }
                if (sign == 1) {
                    a = (int) (Math.random() * 10);
                    b = (int) (Math.random() * 10);
                    c = (int) (Math.random() * 10);
                    if (a + b < c) {
                        int z = c;
                        c = a;
                        a = z;
                    }
                    exam.setText(a + "+" + b + "-" + c + "=");
                    anscorr = a + b - c;
                }
            }
            if (sign == 1) {
                sign = (int) (Math.random() * 2);
                if (sign == 0) {
                    a = (int) (Math.random() * 10 + 2);
                    b = (int) (Math.random() * 3);
                    c = (int) (Math.random() * 10 + 2);

                    exam.setText(a + "-" + b + "+" + c + "=");
                    anscorr = a - b + c;
                }
                if (sign == 1) {
                    a = (int) (Math.random() * 5 + 10);
                    b = (int) (Math.random() * 5);
                    c = (int) (Math.random() * 5);
                    if (a + b < c) {
                        int z = c;
                        c = a;
                        a = z;
                    }
                    exam.setText(a + "+" + b + "-" + c + "=");
                    anscorr = a + b - c;
                }
            }
        }
        if (level == 3) {
            sign = (int) (Math.random()*2);
            if(sign == 0){
                a = (int) (Math.random()*5);
                b = (int) (Math.random()*5);
                exam.setText(a + " x " + b + "=");
                anscorr = a * b;

            }
            if(sign == 1){
                a = (int) (Math.random()*5+1);
                b = (int) (Math.random()*5+1);
                c = a * b;
                exam.setText(c + ":" + a + "=");
                anscorr = c / a;

            }
        }
        if (level == 4) {

        }
        if (level == 5) {

        }
    }

    public void startGameTimer() {
        gameTimer = new CountDownTimer(11000 - level*1000, 1000) {
            public void onTick(long millisUntilFinished) {

                remainingTime = millisUntilFinished / 1000;
                updateTimerUI(remainingTime);
            }

            public void onFinish() {

                Intent intentsc = new Intent(ActivityGame.this, ActivityScore.class);
                intentsc.putExtra("POINTS", points);
                startActivity(intentsc);
                finish();
                Intent intent = new Intent(ActivityGame.this, ActivityGameOver.class);
                intent.putExtra("POINTS", points);
                startActivity(intent);
                finish();

            }
        }.start();
    }

    public void updateTimerUI(long secondsRemaining) {
        // Обновляем пользовательский интерфейс с оставшимся временем

        TextView timerTextView = findViewById(R.id.timerTextView);
        timerTextView.setText(String.valueOf(secondsRemaining));
    }

    public void diff(int time, int lev){

        points = points + lev*time;
        TextView pointsTextView = findViewById(R.id.pointsTextView);
        pointsTextView.setText(String.valueOf(points));
        if(lev == 1 && points > 60 ){
            level = level + 1;
        }
        if(lev == 2 && points > 140 ){
            level = level + 1;
        }

    }

    public int getPoints() {
        return points;
    }
}