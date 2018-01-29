package com.example.android.movieit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    boolean answer1, answer2, answer3, answer4, answer5, answerCheck;
    int score = 0;
    RadioGroup rg1;
    RadioButton rb1a;
    RadioButton rb1b;
    RadioButton rb1c;
    RadioButton rb1d;
    EditText answerField ;
    RadioButton rb3a;
    RadioButton rb3b ;
    RadioButton rb3c;
    RadioButton rb3d;
    CheckBox cb4a;
    CheckBox cb4b;
    CheckBox cb4c;
    CheckBox cb4d;
    RadioButton rb5a;
    RadioButton rb5b;
    RadioButton rb5c;
    RadioButton rb5d;
    CheckBox cb6a;
    CheckBox cb6b;
    CheckBox cb6c;
    CheckBox cb6d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        rg1 = findViewById(R.id.rg1);
        rb1a = findViewById(R.id.rb1a);
        rb1b = findViewById(R.id.rb1b);
        rb1c = findViewById(R.id.rb1c);
        rb1d = findViewById(R.id.rb1d);
        answerField = findViewById(R.id.answer_field);
        rb3a = findViewById(R.id.rb3a);
        rb3b = findViewById(R.id.rb3b);
        rb3c = findViewById(R.id.rb3c);
        rb3d = findViewById(R.id.rb3d);
        cb4a = findViewById(R.id.cb4a);
        cb4b = findViewById(R.id.cb4b);
        cb4c = findViewById(R.id.cb4c);
        cb4d = findViewById(R.id.cb4d);
        rb5a = findViewById(R.id.rb5a);
        rb5b = findViewById(R.id.rb5b);
        rb5c = findViewById(R.id.rb5c);
        rb5d = findViewById(R.id.rb5d);
        cb6a = findViewById(R.id.cb6a);
        cb6b = findViewById(R.id.cb6b);
        cb6c = findViewById(R.id.cb6c);
        cb6d = findViewById(R.id.cb6d);}


        private void answerRules() {

        }


    public void showResult (View view) {
        if (rb1c.isChecked()) {
            score++;
        }
        Log.v("Main Activity", "Text is: " + answerField.getText().toString());
        if (answerField.getText().toString().equals("1962")) {
            score++;

        } else if( answerField.getText().toString().length() == 0 ) {
            answerField.setError( "Please answer all questions." );
        }

        if (rb3b.isChecked()) {
            score++;
        }

        if (cb4a.isChecked() && cb4b.isChecked()) {
            score++;
        }

        if (rb5a.isChecked()) {
            score++;
        }

        if (cb6a.isChecked() && cb6c.isChecked()) {
            score++;
        }

        Log.v("Quiz Activity", "Score is: " + score);

    }


    }



