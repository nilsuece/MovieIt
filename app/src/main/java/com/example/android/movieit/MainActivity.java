package com.example.android.movieit;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText playerName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerName = findViewById(R.id.name_field);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }


    public void startQuiz(View view){
        if (playerName.getText().toString().length() == 0) {
            playerName.setError("Please enter a valid name.");
        } else
            {Intent intent = new Intent(this, QuizActivity.class);
            intent.putExtra("player_name", playerName.getText().toString());
            startActivity(intent);

                }
    }
}

