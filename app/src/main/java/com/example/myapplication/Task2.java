package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class Task2 extends AppCompatActivity {

    int active_ity;
    int difficulty;
    int difficultyConductor;

    CountDownTimer runTimer;
    CountDownTimer animationChecker;

    ObjectAnimator risingEdgeAnimator;
    ObjectAnimator fallingEdgeAnimator;

    TextView color;
    TextView timerNum;
    TextView result;

    View progress1;
    View progress2;
    View progress3;
    View progress4;
    View progress5;
    View progress6;

    int textConductor;
    int colorConductor;
    Database db;

    boolean matching;
    boolean win;
    boolean gameOn;
    boolean animationIsOn;

    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.task2_action_bar));
        getSupportActionBar().setTitle("Reaction Test");

        active_ity = 2;
        difficulty = getIntent().getIntExtra("difficulty",2);

        if (difficulty == 1) {
            difficultyConductor = 11000;
        }
        if (difficulty == 2) {
            difficultyConductor = 8000;
        }
        if (difficulty == 3) {
            difficultyConductor = 5000;
        }

        win = false;
        gameOn = true;
        animationIsOn = false;
        progress = 0;

        db = new Database();

        color = findViewById(R.id.colorDisplay);
        timerNum = findViewById(R.id.timerNum2);
        result = findViewById(R.id.resultView);
        result.setAlpha(0);

        risingEdgeAnimator = ObjectAnimator.ofFloat(result, "alpha", 0, 1);
        risingEdgeAnimator.setDuration(500);
        fallingEdgeAnimator = ObjectAnimator.ofFloat(result, "alpha", 1, 0);
        fallingEdgeAnimator.setDuration(500);


        progress1 = findViewById(R.id.progress1);
        progress2 = findViewById(R.id.progress2);
        progress3 = findViewById(R.id.progress3);
        progress4 = findViewById(R.id.progress4);
        progress5 = findViewById(R.id.progress5);
        progress6 = findViewById(R.id.progress6);

        generate();
        runTimer();
    }

    public void back2(View v) {
        Intent task1Intent = new Intent(Task2.this,StartScreen.class);
        task1Intent.putExtra("active",active_ity);
        startActivity(task1Intent);
    }

    public void generate() {
        textConductor = (int)(Math.random() * 6);
        color.setText(db.colors[textConductor]);

        colorConductor = (int)(Math.random() * 2);
        if (colorConductor == 1) {
            matching = true;
            matchColors();
        }
        else {
            matching = false;
            for (int i = (int)(Math.random() * 6); !(i == textConductor); i = (int)(Math.random() * 6)) {
                if (i == 0) {
                    color.setTextColor(getResources().getColor(R.color.cyan));
                }
                if (i == 1) {
                    color.setTextColor(getResources().getColor(R.color.magenta));
                }
                if (i == 2) {
                    color.setTextColor(getResources().getColor(R.color.red));
                }
                if (i == 3) {
                    color.setTextColor(getResources().getColor(R.color.black));
                }
                if (i == 4) {
                    color.setTextColor(getResources().getColor(R.color.yellow));
                }
                if (i == 5) {
                    color.setTextColor(getResources().getColor(R.color.green));
                }
            }
        }
    }

    public void matchColors() {
        if (textConductor == 0) {
            color.setTextColor(getResources().getColor(R.color.cyan));
        }
        if (textConductor == 1) {
            color.setTextColor(getResources().getColor(R.color.magenta));
        }
        if (textConductor == 2) {
            color.setTextColor(getResources().getColor(R.color.red));
        }
        if (textConductor == 3) {
            color.setTextColor(getResources().getColor(R.color.black));
        }
        if (textConductor == 4) {
            color.setTextColor(getResources().getColor(R.color.yellow));
        }
        if (textConductor == 5) {
            color.setTextColor(getResources().getColor(R.color.green));
        }
    }

    public void checkClicked(View v) {
        if (gameOn) {
            if (matching) {
                correct();
            } else {
                incorrect();
            }
        }
    }

    public void xClicked(View v) {
        if (gameOn) {
            if (!matching) {
                correct();
            } else {
                incorrect();
            }
        }
    }

    public void runTimer(){
        runTimer = new CountDownTimer(difficultyConductor, 1000) {

            public void onTick(long millisUntilFinished) {
                if (!win) {
                   timerNum.setText(String.valueOf(millisUntilFinished / 1000));
                }
            }

            public void onFinish() {
                if (!win) {
                   timerNum.setTextColor(getResources().getColor(R.color.burntOrange));
                   timerNum.setText("Time's up!\nTry again!");
                   gameOn = false;
                   color.setAlpha(0);
                }
            }
        }.start();
    }

    public void correct() {
        risingEdgeAnimator.cancel();
        if (animationIsOn) {
            animationChecker.cancel();
        }
        result.setAlpha(0);
        result.setTextColor(getResources().getColor(R.color.darkGreen));
        result.setText(getResources().getString(R.string.correct));
        risingEdgeAnimator.start();
        animationChecker = new CountDownTimer(1500, 1000) {

            public void onTick(long millisUntilFinished) {
                animationIsOn = true;
            }

            public void onFinish() {
                fallingEdgeAnimator.start();
                animationIsOn = false;
            }
        }.start();
        progress++;
        if (progress == 1) {
            progress1.setBackgroundDrawable(getResources().getDrawable(R.drawable.progress_bar_full));
            generate();
        }
        if (progress == 2) {
            progress2.setBackgroundDrawable(getResources().getDrawable(R.drawable.progress_bar_full));
            generate();
        }
        if (progress == 3) {
            progress3.setBackgroundDrawable(getResources().getDrawable(R.drawable.progress_bar_full));
            generate();
        }
        if (progress == 4) {
            progress4.setBackgroundDrawable(getResources().getDrawable(R.drawable.progress_bar_full));
            generate();
        }
        if (progress == 5) {
            progress5.setBackgroundDrawable(getResources().getDrawable(R.drawable.progress_bar_full));
            generate();
        }
        if (progress == 6) {
            progress6.setBackgroundDrawable(getResources().getDrawable(R.drawable.progress_bar_full));
            win = true;
            gameOn = false;
            timerNum.setTextColor(getResources().getColor(R.color.timerColor));
            timerNum.setText("Task complete!");
            color.setAlpha(0);
        }
    }

    public void incorrect() {
        risingEdgeAnimator.cancel();
        if (animationIsOn) {
            animationChecker.cancel();
        }
        generate();
        result.setAlpha(0);
        result.setTextColor(getResources().getColor(R.color.darkRed));
        result.setText(getResources().getString(R.string.incorrect));
        risingEdgeAnimator.start();
        animationChecker = new CountDownTimer(1500, 1000) {

            public void onTick(long millisUntilFinished) {
                animationIsOn = true;
            }

            public void onFinish() {
                fallingEdgeAnimator.start();
                animationIsOn = false;
            }
        }.start();
        progress = 0;
        progress1.setBackgroundDrawable(getResources().getDrawable(R.drawable.progress_bar_empty));
        progress2.setBackgroundDrawable(getResources().getDrawable(R.drawable.progress_bar_empty));
        progress3.setBackgroundDrawable(getResources().getDrawable(R.drawable.progress_bar_empty));
        progress4.setBackgroundDrawable(getResources().getDrawable(R.drawable.progress_bar_empty));
        progress5.setBackgroundDrawable(getResources().getDrawable(R.drawable.progress_bar_empty));
    }
}