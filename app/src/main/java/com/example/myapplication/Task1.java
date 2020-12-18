package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class Task1 extends AppCompatActivity {

    int active_ity;
    int difficulty;
    int difficultyConductor;

    TextView grid1;
    TextView grid2;
    TextView grid3;
    TextView grid4;
    TextView grid5;
    TextView grid6;
    TextView grid7;
    TextView grid8;
    TextView grid9;

    Randomizer r;
    int[] randomized;

    boolean gameOn;
    boolean win;
    int counter;

    int numSeconds;

    View timerBox;
    TextView timerNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        active_ity = 1;
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

        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_action_bar));
        getSupportActionBar().setTitle("3x3");

        r = new Randomizer();
        randomized = r.randomize();

        counter = 1;
        gameOn = true;
        win = false;

        numSeconds = 6;

        timerBox = findViewById(R.id.view3);
        timerNum = findViewById(R.id.timerNum1);


        grid1 = findViewById(R.id.gridSpace1);
            grid1.setText(String.valueOf(randomized[0]));
        grid2 = findViewById(R.id.gridSpace2);
            grid2.setText(String.valueOf(randomized[1]));
        grid3 = findViewById(R.id.gridSpace3);
            grid3.setText(String.valueOf(randomized[2]));
        grid4 = findViewById(R.id.gridSpace4);
            grid4.setText(String.valueOf(randomized[3]));
        grid5 = findViewById(R.id.gridSpace5);
            grid5.setText(String.valueOf(randomized[4]));
        grid6 = findViewById(R.id.gridSpace6);
            grid6.setText(String.valueOf(randomized[5]));
        grid7 = findViewById(R.id.gridSpace7);
            grid7.setText(String.valueOf(randomized[6]));
        grid8 = findViewById(R.id.gridSpace8);
            grid8.setText(String.valueOf(randomized[7]));
        grid9 = findViewById(R.id.gridSpace9);
            grid9.setText(String.valueOf(randomized[8]));

            runTimer();
    }

    public void back1(View v) {
        Intent task1Intent = new Intent(Task1.this,StartScreen.class);
        task1Intent.putExtra("active",active_ity);
        startActivity(task1Intent);
    }

    public void boxCheck1(View v) {
        if (gameOn && !win) {
            if (grid1.getText().equals(String.valueOf(counter))) {
                grid1.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_correct_squares));
                counter++;
                if (counter == 10) {
                    win = true;
                    timerNum.setTextColor(getResources().getColor(R.color.timerColor));
                    timerNum.setText("Task complete!");
                }
            } else {
                reset();
                counter = 1;
            }
        }
    }

    public void boxCheck2(View v) {
        if (gameOn && !win) {
            if (grid2.getText().equals(String.valueOf(counter))) {
                grid2.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_correct_squares));
                counter++;
                if (counter == 10) {
                    win = true;
                    timerNum.setTextColor(getResources().getColor(R.color.timerColor));
                    timerNum.setText("Task complete!");
                }
            } else {
                reset();
                counter = 1;
            }
        }
    }

    public void boxCheck3(View v) {
        if (gameOn && !win) {
            if (grid3.getText().equals(String.valueOf(counter))) {
                grid3.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_correct_squares));
                counter++;
                if (counter == 10) {
                    win = true;
                    timerNum.setTextColor(getResources().getColor(R.color.timerColor));
                    timerNum.setText("Task complete!");
                }
            } else {
                reset();
                counter = 1;
            }
        }
    }

    public void boxCheck4(View v) {
        if (gameOn && !win) {
            if (grid4.getText().equals(String.valueOf(counter))) {
                grid4.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_correct_squares));
                counter++;
                if (counter == 10) {
                    win = true;
                    timerNum.setTextColor(getResources().getColor(R.color.timerColor));
                    timerNum.setText("Task complete!");
                }
            } else {
                reset();
                counter = 1;
            }
        }
    }

    public void boxCheck5(View v) {
        if (gameOn && !win) {
            if (grid5.getText().equals(String.valueOf(counter))) {
                grid5.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_correct_squares));
                counter++;
                if (counter == 10) {
                    win = true;
                    timerNum.setTextColor(getResources().getColor(R.color.timerColor));
                    timerNum.setText("Task complete!");
                }
            } else {
                reset();
                counter = 1;
            }
        }
    }

    public void boxCheck6(View v) {
        if (gameOn && !win) {
            if (grid6.getText().equals(String.valueOf(counter))) {
                grid6.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_correct_squares));
                counter++;
                if (counter == 10) {
                    win = true;
                    timerNum.setTextColor(getResources().getColor(R.color.timerColor));
                    timerNum.setText("Task complete!");
                }
            } else {
                reset();
                counter = 1;
            }
        }
    }

    public void boxCheck7(View v) {
        if (gameOn && !win) {
            if (grid7.getText().equals(String.valueOf(counter))) {
                grid7.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_correct_squares));
                counter++;
                if (counter == 10) {
                    win = true;
                    timerNum.setTextColor(getResources().getColor(R.color.timerColor));
                    timerNum.setText("Task complete!");
                }
            } else {
                reset();
                counter = 1;
            }
        }
    }

    public void boxCheck8(View v) {
        if (gameOn && !win) {
            if (grid8.getText().equals(String.valueOf(counter))) {
                grid8.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_correct_squares));
                counter++;
                if (counter == 10) {
                    win = true;
                    timerNum.setTextColor(getResources().getColor(R.color.timerColor));
                    timerNum.setText("Task complete!");
                }
            } else {
                reset();
                counter = 1;
            }
        }
    }

    public void boxCheck9(View v) {
        if (gameOn && !win) {
            if (grid9.getText().equals(String.valueOf(counter))) {
                grid9.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_correct_squares));
                counter++;
                if (counter == 10) {
                    win = true;
                    timerNum.setTextColor(getResources().getColor(R.color.timerColor));
                    timerNum.setText("Task complete!");
                }
            } else {
                reset();
                counter = 1;
            }
        }
    }

    public void reset() {
        grid1.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_squares));
        grid2.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_squares));
        grid3.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_squares));
        grid4.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_squares));
        grid5.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_squares));
        grid6.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_squares));
        grid7.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_squares));
        grid8.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_squares));
        grid9.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_squares));
    }

    public void runTimer(){
        new CountDownTimer(difficultyConductor, 1000) {

            public void onTick(long millisUntilFinished) {
                if (!win) {
                    timerNum.setText(String.valueOf(millisUntilFinished / 1000));
                }
            }

            public void onFinish() {
                if (!win) {
                    timerNum.setTextColor(getResources().getColor(R.color.burntOrange));
                    timerNum.setText("Time's up!\nTry again!");
                    grid1.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_incorrect_squares));
                    grid2.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_incorrect_squares));
                    grid3.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_incorrect_squares));
                    grid4.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_incorrect_squares));
                    grid5.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_incorrect_squares));
                    grid6.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_incorrect_squares));
                    grid7.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_incorrect_squares));
                    grid8.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_incorrect_squares));
                    grid9.setBackgroundDrawable(getResources().getDrawable(R.drawable.task1_border_for_incorrect_squares));
                    gameOn = false;
                }
            }
        }.start();
    }
}