package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Task3 extends AppCompatActivity {

    int active_ity;
    int difficulty;
    int difficultyConductor;

    ArrayList pattern;
    ArrayList input;
    Integer random;

    TextView countdown;

    View cpuGrid1;
    View cpuGrid2;
    View cpuGrid3;
    View cpuGrid4;
    View cpuGrid5;
    View cpuGrid6;
    View cpuGrid7;
    View cpuGrid8;
    View cpuGrid9;

    View playerGrid1;
    View playerGrid2;
    View playerGrid3;
    View playerGrid4;
    View playerGrid5;
    View playerGrid6;
    View playerGrid7;
    View playerGrid8;
    View playerGrid9;

    View progress1;
    View progress2;
    View progress3;
    View progress4;
    View progress5;
    View progress6;

    TextView resultDisplay;

    CountDownTimer actualCountdownTimer;
    CountDownTimer incorrectFlashTimer;
    CountDownTimer cpuThinking;
    CountDownTimer cpuDisplayTimer;
    int countdownStage;

    int gameStage;
    int gameCountStage;

    boolean gameOn;
    boolean gameOver;

    boolean redFlashConductor;

    boolean endless;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);

        active_ity = 3;
        difficulty = getIntent().getIntExtra("difficulty",2);
        endless = getIntent().getBooleanExtra("endless",false);
        if (endless)
            difficulty = 3;

        if (difficulty == 1) {
            difficultyConductor = 600;
        }
        if (difficulty == 2) {
            difficultyConductor = 400;
        }
        if (difficulty == 3) {
            difficultyConductor = 200;
        }

        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_action_bar));
        if (endless) {
            getSupportActionBar().setTitle("Simon Says (Endless)");
        }
        else {
            getSupportActionBar().setTitle("Simon Says");
        }

        cpuGrid1 = findViewById(R.id.cpuGrid1);
        cpuGrid2 = findViewById(R.id.cpuGrid2);
        cpuGrid3 = findViewById(R.id.cpuGrid3);
        cpuGrid4 = findViewById(R.id.cpuGrid4);
        cpuGrid5 = findViewById(R.id.cpuGrid5);
        cpuGrid6 = findViewById(R.id.cpuGrid6);
        cpuGrid7 = findViewById(R.id.cpuGrid7);
        cpuGrid8 = findViewById(R.id.cpuGrid8);
        cpuGrid9 = findViewById(R.id.cpuGrid9);

        playerGrid1 = findViewById(R.id.playerGrid1);
        playerGrid2 = findViewById(R.id.playerGrid2);
        playerGrid3 = findViewById(R.id.playerGrid3);
        playerGrid4 = findViewById(R.id.playerGrid4);
        playerGrid5 = findViewById(R.id.playerGrid5);
        playerGrid6 = findViewById(R.id.playerGrid6);
        playerGrid7 = findViewById(R.id.playerGrid7);
        playerGrid8 = findViewById(R.id.playerGrid8);
        playerGrid9 = findViewById(R.id.playerGrid9);

        progress1 = findViewById(R.id.progress1);
        progress2 = findViewById(R.id.progress2);
        progress3 = findViewById(R.id.progress3);
        progress4 = findViewById(R.id.progress4);
        progress5 = findViewById(R.id.progress5);
        progress6 = findViewById(R.id.progress6);

        resultDisplay = findViewById(R.id.resultDisplay);

        @SuppressLint("ClickableViewAccessibility") View.OnTouchListener touchGrid1 = (v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (gameOn) {
                        playerGrid1.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_grid_cyan));
                        if (input.size() < gameStage) {
                            addInput(1);
                        }
                    }
                    return true;
                case MotionEvent.ACTION_UP:
                    if (!gameOver) {
                        playerGrid1.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_empty));
                    }
                    return true;
            }
            return false;
        };
        playerGrid1.setOnTouchListener(touchGrid1);

        @SuppressLint("ClickableViewAccessibility") View.OnTouchListener touchGrid2 = (v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (gameOn) {
                        playerGrid2.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_grid_brown));
                        if (input.size() < gameStage) {
                            addInput(2);
                        }
                    }
                    return true;
                case MotionEvent.ACTION_UP:
                    if (!gameOver) {
                        playerGrid2.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_empty));
                    }
                    return true;
            }
            return false;
        };
        playerGrid2.setOnTouchListener(touchGrid2);

        @SuppressLint("ClickableViewAccessibility") View.OnTouchListener touchGrid3 = (v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (gameOn) {
                        playerGrid3.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_grid_pink));
                        if (input.size() < gameStage) {
                            addInput(3);
                        }
                    }
                    return true;
                case MotionEvent.ACTION_UP:
                    if (!gameOver) {
                        playerGrid3.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_empty));
                    }
                    return true;
            }
            return false;
        };
        playerGrid3.setOnTouchListener(touchGrid3);

        @SuppressLint("ClickableViewAccessibility") View.OnTouchListener touchGrid4 = (v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (gameOn) {
                        playerGrid4.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_grid_purp));
                        if (input.size() < gameStage) {
                            addInput(4);
                        }
                    }
                    return true;
                case MotionEvent.ACTION_UP:
                    if (!gameOver) {
                        playerGrid4.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_empty));
                    }
                    return true;
            }
            return false;
        };
        playerGrid4.setOnTouchListener(touchGrid4);

        @SuppressLint("ClickableViewAccessibility") View.OnTouchListener touchGrid5 = (v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (gameOn) {
                        playerGrid5.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_grid_yellow));
                        if (input.size() < gameStage) {
                            addInput(5);
                        }
                    }
                    return true;
                case MotionEvent.ACTION_UP:
                    if (!gameOver) {
                        playerGrid5.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_empty));
                    }
                    return true;
            }
            return false;
        };
        playerGrid5.setOnTouchListener(touchGrid5);

        @SuppressLint("ClickableViewAccessibility") View.OnTouchListener touchGrid6 = (v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (gameOn) {
                        playerGrid6.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_grid_red));
                        if (input.size() < gameStage) {
                            addInput(6);
                        }
                    }
                    return true;
                case MotionEvent.ACTION_UP:
                    if (!gameOver) {
                        playerGrid6.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_empty));
                    }
                    return true;
            }
            return false;
        };
        playerGrid6.setOnTouchListener(touchGrid6);

        @SuppressLint("ClickableViewAccessibility") View.OnTouchListener touchGrid7 = (v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (gameOn) {
                        playerGrid7.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_grid_blue));
                        if (input.size() < gameStage) {
                            addInput(7);
                        }
                    }
                    return true;
                case MotionEvent.ACTION_UP:
                    if (!gameOver) {
                        playerGrid7.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_empty));
                    }
                    return true;
            }
            return false;
        };
        playerGrid7.setOnTouchListener(touchGrid7);

        @SuppressLint("ClickableViewAccessibility") View.OnTouchListener touchGrid8 = (v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (gameOn) {
                        playerGrid8.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_grid_orange));
                        if (input.size() < gameStage) {
                            addInput(8);
                        }
                    }
                    return true;
                case MotionEvent.ACTION_UP:
                    if (!gameOver) {
                        playerGrid8.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_empty));
                    }
                    return true;
            }
            return false;
        };
        playerGrid8.setOnTouchListener(touchGrid8);

        @SuppressLint("ClickableViewAccessibility") View.OnTouchListener touchGrid9 = (v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (gameOn) {
                        playerGrid9.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_grid_green));
                        if (input.size() < gameStage) {
                            addInput(9);
                        }
                    }
                    return true;
                case MotionEvent.ACTION_UP:
                    if (!gameOver) {
                        playerGrid9.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_empty));
                    }
                    return true;
            }
            return false;
        };
        playerGrid9.setOnTouchListener(touchGrid9);

        pattern = new ArrayList();
        input = new ArrayList();
        countdown = findViewById(R.id.countdownDisplay);
        countdownStage = 3;

        gameStage = 1;
        gameCountStage = 1;

        gameOn = false;
        gameOver = false;

        redFlashConductor = true;

        countdown();
    }


    public void back3(View v) {
        Intent task1Intent = new Intent(Task3.this, StartScreen.class);
        task1Intent.putExtra("active", active_ity);
        startActivity(task1Intent);
    }

    public void countdown() {
        actualCountdownTimer = new CountDownTimer(1000, 800) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                if (countdownStage > 0) {
                    countdown.setAlpha(1);
                    countdown.setText(String.valueOf(countdownStage));
                    countdown.animate().alpha(0).setDuration(600);
                    actualCountdownTimer.start();
                    countdownStage--;
                } else if (countdownStage == 0) {
                    countdown.setText(getResources().getString(R.string.go));
                    countdown.setAlpha(1);
                    countdown.animate().alpha(0).setDuration(1000);
                    countdownStage--;
                    actualCountdownTimer.start();
                }
                else {
                    play();
                }
            }
        }.start();
    }

    public void play() {
        gameOn = false;
        input.clear();
        random = (int)(Math.random() * 9 + 1);
        pattern.add(random);
        cpuThinking = new CountDownTimer(500,100) {
            @Override
            public void onTick(long millisUntilFinished) {}

            @Override
            public void onFinish() {
                cpuDisplayTimer = new CountDownTimer(difficultyConductor, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        if (pattern.get(gameCountStage - 1).equals(1)) {
                            cpuGrid1.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_grid_cyan));
                        }
                        if (pattern.get(gameCountStage - 1).equals(2)) {
                            cpuGrid2.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_grid_brown));
                        }
                        if (pattern.get(gameCountStage - 1).equals(3)) {
                            cpuGrid3.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_grid_pink));
                        }
                        if (pattern.get(gameCountStage - 1).equals(4)) {
                            cpuGrid4.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_grid_purp));
                        }
                        if (pattern.get(gameCountStage - 1).equals(5)) {
                            cpuGrid5.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_grid_yellow));
                        }
                        if (pattern.get(gameCountStage - 1).equals(6)) {
                            cpuGrid6.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_grid_red));
                        }
                        if (pattern.get(gameCountStage - 1).equals(7)) {
                            cpuGrid7.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_grid_blue));
                        }
                        if (pattern.get(gameCountStage - 1).equals(8)) {
                            cpuGrid8.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_grid_orange));
                        }
                        if (pattern.get(gameCountStage - 1).equals(9)) {
                            cpuGrid9.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_grid_green));
                        }
                    }

                    @Override
                    public void onFinish() {
                        cpuGrid1.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_cpu_grid_empty));
                        cpuGrid2.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_cpu_grid_empty));
                        cpuGrid3.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_cpu_grid_empty));
                        cpuGrid4.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_cpu_grid_empty));
                        cpuGrid5.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_cpu_grid_empty));
                        cpuGrid6.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_cpu_grid_empty));
                        cpuGrid7.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_cpu_grid_empty));
                        cpuGrid8.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_cpu_grid_empty));
                        cpuGrid9.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_cpu_grid_empty));
                        if (gameCountStage < gameStage) {
                            gameCountStage++;
                            cpuDisplayTimer.start();
                        }
                        else {
                            gameCountStage = 1;
                            gameOn = true;
                        }
                    }
                }.start();
            }
        }.start();
    }

    public void addInput(int clicked) {
        input.add(clicked);
        if (input.get(input.size() - 1).equals(pattern.get(input.size() - 1))) {
            correct();
        }
        else {
            incorrect();
        }
    }

    public void correct() {
        if (input.size() == gameStage) {
            gameStage++;
            if (gameStage == 7) {
                progress6.setBackgroundDrawable(getResources().getDrawable(R.drawable.progress_bar_full));
                if (!endless) {
                    gameOn = false;
                    resultDisplay.setAlpha(1);
                    resultDisplay.setTextColor(getResources().getColor(R.color.timerColor));
                    resultDisplay.setText("Task complete!");
                }
                else {
                    play();
                }
            }
            else {
                if (gameStage == 2) {
                    progress1.setBackgroundDrawable(getResources().getDrawable(R.drawable.progress_bar_full));
                }
                if (gameStage == 3) {
                    progress2.setBackgroundDrawable(getResources().getDrawable(R.drawable.progress_bar_full));
                }
                if (gameStage == 4) {
                    progress3.setBackgroundDrawable(getResources().getDrawable(R.drawable.progress_bar_full));
                }
                if (gameStage == 5) {
                    progress4.setBackgroundDrawable(getResources().getDrawable(R.drawable.progress_bar_full));
                }
                if (gameStage == 6) {
                    progress5.setBackgroundDrawable(getResources().getDrawable(R.drawable.progress_bar_full));
                }
                play();
            }
        }
    }

    public void incorrect() {
        gameOn = false;
        resultDisplay.setAlpha(1);
        gameOver = true;
        if (endless) {
            resultDisplay.setText("Score: " + (gameStage - 1));
        }
        else {
            resultDisplay.setTextColor(getResources().getColor(R.color.burntOrange));
            resultDisplay.setText("Task failed!\nTry again!");
        }
            incorrectFlashTimer = new CountDownTimer(600,100) {
                @Override
                public void onTick(long millisUntilFinished) {
                    if (millisUntilFinished > 300) {
                        playerGrid1.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_incorrect));
                        playerGrid2.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_incorrect));
                        playerGrid3.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_incorrect));
                        playerGrid4.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_incorrect));
                        playerGrid5.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_incorrect));
                        playerGrid6.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_incorrect));
                        playerGrid7.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_incorrect));
                        playerGrid8.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_incorrect));
                        playerGrid9.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_incorrect));
                    }
                    else {
                        playerGrid1.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_empty));
                        playerGrid2.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_empty));
                        playerGrid3.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_empty));
                        playerGrid4.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_empty));
                        playerGrid5.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_empty));
                        playerGrid6.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_empty));
                        playerGrid7.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_empty));
                        playerGrid8.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_empty));
                        playerGrid9.setBackgroundDrawable(getResources().getDrawable(R.drawable.task3_player_grid_empty));
                    }
                }

                @Override
                public void onFinish() {
                    if (redFlashConductor) {
                        redFlashConductor = false;
                        incorrectFlashTimer.start();
                    }

                }
            }.start();
    }

}