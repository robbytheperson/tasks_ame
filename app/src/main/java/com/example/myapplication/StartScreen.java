package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class StartScreen extends AppCompatActivity {

    int active_ity;
    TextView instructions;
    Database db;
    View startButton;

    SeekBar difficultySeekBar;
    TextView easy;
    TextView medium;
    TextView hard;
    int difficulty;

    int endlessModeCounter;
    boolean endlessMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);
        active_ity = getIntent().getIntExtra("active",1);

        difficultySeekBar = findViewById(R.id.seekBar2);
        easy = findViewById(R.id.difficulty_easy);
        medium = findViewById(R.id.difficulty_medium);
        hard = findViewById(R.id.difficulty_hard);
        difficulty = 2;

        endlessModeCounter = 0;
        endlessMode = false;

        SeekBar.OnSeekBarChangeListener difficultyListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress <= 26) {
                    easy();
                }
                else {
                    easy.setTextColor(getResources().getColor(R.color.lightGray));
                }
                if (24 > Math.abs(50 - progress)) {
                    medium();
                }
                else {
                    medium.setTextColor(getResources().getColor(R.color.lightGray));
                }
                if (progress >= 74) {
                    hard();
                }
                else {
                    hard.setTextColor(getResources().getColor(R.color.lightGray));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
        difficultySeekBar.setOnSeekBarChangeListener(difficultyListener);
        difficultySeekBar.setProgress(50);

        instructions = findViewById(R.id.instructions);
        startButton = findViewById(R.id.startButton);

        instructions.setText(db.instructions[active_ity - 1]);

        if (active_ity == 1) {
            instructions.setTextColor(getResources().getColor(R.color.theme1));
            getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_action_bar));
            startButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_start_button));
            getSupportActionBar().setTitle("3x3");
            medium.setTextColor(getResources().getColor(R.color.theme1));
        }
        if (active_ity == 2) {
            instructions.setTextColor(getResources().getColor(R.color.theme2));
            getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.task2_action_bar));
            startButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.task2_start_button));
            getSupportActionBar().setTitle("Reaction Test");
            medium.setTextColor(getResources().getColor(R.color.theme2));
        }
        if (active_ity == 3) {
            instructions.setTextColor(getResources().getColor(R.color.theme3));
            getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_action_bar));
            startButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_start_button));
            getSupportActionBar().setTitle("Simon Says");
            medium.setTextColor(getResources().getColor(R.color.theme3));
        }
    }

    public void easy() {
        difficulty = 1;
        medium.setTextColor(getResources().getColor(R.color.lightGray));
        hard.setTextColor(getResources().getColor(R.color.lightGray));
        if (active_ity == 1) {
            easy.setTextColor(getResources().getColor(R.color.theme1));
        }
        if (active_ity == 2) {
            easy.setTextColor(getResources().getColor(R.color.theme2));
        }
        if (active_ity == 3) {
            easy.setTextColor(getResources().getColor(R.color.theme3));
        }
    }
    public void medium() {
        difficulty = 2;
        easy.setTextColor(getResources().getColor(R.color.lightGray));
        hard.setTextColor(getResources().getColor(R.color.lightGray));
        if (active_ity == 1) {
            medium.setTextColor(getResources().getColor(R.color.theme1));
        }
        if (active_ity == 2) {
            medium.setTextColor(getResources().getColor(R.color.theme2));
        }
        if (active_ity == 3) {
            medium.setTextColor(getResources().getColor(R.color.theme3));
        }
    }
    public void hard() {
        difficulty = 3;
        easy.setTextColor(getResources().getColor(R.color.lightGray));
        medium.setTextColor(getResources().getColor(R.color.lightGray));
        if (active_ity == 1) {
            hard.setTextColor(getResources().getColor(R.color.theme1));
        }
        if (active_ity == 2) {
            hard.setTextColor(getResources().getColor(R.color.theme2));
        }
        if (active_ity == 3) {
            hard.setTextColor(getResources().getColor(R.color.theme3));
        }
    }

    public void clickEasy(View v) {
        difficultySeekBar.setProgress(0);
        easy();
    }
    public void clickMedium(View v) {
        difficultySeekBar.setProgress(50);
        medium();
    }
    public void clickHard(View v) {
        difficultySeekBar.setProgress(100);
        hard();
        endlessModeCounter++;
        if (endlessModeCounter == 5)
            endlessMode = true;
    }

    public void onStartButton(View v) {
        if (active_ity == 1) {
            Intent i = new Intent(StartScreen.this,Task1.class);
            i.putExtra("difficulty",difficulty);
            startActivity(i);
        }

        if (active_ity == 2) {
            Intent i = new Intent(StartScreen.this,Task2.class);
            i.putExtra("difficulty",difficulty);
            startActivity(i);
        }

        if (active_ity == 3) {
            Intent i = new Intent(StartScreen.this,Task3.class);
            i.putExtra("difficulty",difficulty);
            i.putExtra("endless",endlessMode);
            startActivity(i);
        }

        if (active_ity == 4) {
            Intent i = new Intent(StartScreen.this,Task4.class);
            i.putExtra("difficulty",difficulty);
            startActivity(i);
        }

        if (active_ity == 5) {
            Intent i = new Intent(StartScreen.this,Task5.class);
            i.putExtra("difficulty",difficulty);
            startActivity(i);
        }

        if (active_ity == 6) {
            Intent i = new Intent(StartScreen.this,Task6.class);
            i.putExtra("difficulty",difficulty);
            startActivity(i);
        }
    }
}