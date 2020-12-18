package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int active_ity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        active_ity = 0;

        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.main_activity_action_bar));
    }

    public void openTask1 (View v) {
        active_ity = 1;
        Intent task1Intent = new Intent(MainActivity.this,StartScreen.class);
        task1Intent.putExtra("active",active_ity);
        startActivity(task1Intent);
    }

    public void openTask2 (View v) {
        active_ity = 2;
        Intent i = new Intent(MainActivity.this,StartScreen.class);
        i.putExtra("active",active_ity);
        startActivity(i);
    }

    public void openTask3 (View v) {
        active_ity = 3;
        Intent i = new Intent(MainActivity.this,StartScreen.class);
        i.putExtra("active",active_ity);
        startActivity(i);
    }

    public void openTask4 (View v) {
        active_ity = 4;
        Intent i = new Intent(MainActivity.this,StartScreen.class);
        i.putExtra("active",active_ity);
        startActivity(i);
    }

    public void openTask5 (View v) {
        active_ity = 5;
        Intent i = new Intent(MainActivity.this,StartScreen.class);
        i.putExtra("active",active_ity);
        startActivity(i);
    }
    public void openTask6 (View v) {
        active_ity = 6;
        Intent i = new Intent(MainActivity.this,StartScreen.class);
        i.putExtra("active",active_ity);
        startActivity(i);
    }
}