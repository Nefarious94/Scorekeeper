package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int score1 = 0, score2 = 0;
    TextView scoreboard1, scoreboard2;
    ImageButton minus1, plus1, minus2, plus2;
    static String STATE_SCORE_1;
    static String STATE_SCORE_2;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.night_mode:
                int nm = AppCompatDelegate.getDefaultNightMode();
                if (nm == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                recreate();
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//Inflate the menu from XML
        getMenuInflater().inflate(R.menu.main_menu, menu);
//Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreboard1 = findViewById(R.id.Score_t1);
        scoreboard2 = findViewById(R.id.Score_t2);
        minus1 = findViewById(R.id.imageButton);
        plus1 = findViewById(R.id.imageButton2);
        minus2 = findViewById(R.id.imageButton3);
        plus2 = findViewById(R.id.imageButton4);
        scoreboard1.setText(Integer.toString(score1));
        scoreboard2.setText(Integer.toString(score2));
        STATE_SCORE_1 = "equipo 1";
        STATE_SCORE_2 = "equipo 2";
        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt(STATE_SCORE_1);
            score2 = savedInstanceState.getInt(STATE_SCORE_2);
//Set the score text views
            scoreboard1.setText(String.valueOf(score1));
            scoreboard2.setText(String.valueOf(score2));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//Save the scores
        outState.putInt(STATE_SCORE_1, score1);
        outState.putInt(STATE_SCORE_2, score2);
        super.onSaveInstanceState(outState);
    }

    public void increaseScore(View v) {
        switch (v.getId()) {
            case R.id.imageButton2:
                score1++;
                scoreboard1.setText(Integer.toString(score1));
                break;
            case R.id.imageButton4:
                score2++;
                scoreboard2.setText(Integer.toString(score2));
                break;
        }
    }

    public void decreaseScore(View v) {
        switch (v.getId()) {
            case R.id.imageButton:
                score1--;
                scoreboard1.setText(Integer.toString(score1));
                break;
            case R.id.imageButton3:
                score2--;
                scoreboard2.setText(Integer.toString(score2));
                break;
        }
    }
}
