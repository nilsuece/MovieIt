package com.example.android.movieit;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    int score = 0;
    String playerName;
    RadioGroup rg1;
    RadioButton rb1a;
    RadioButton rb1b;
    RadioButton rb1c;
    RadioButton rb1d;
    EditText answerField;
    RadioButton rb3a;
    RadioButton rb3b;
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

    private ArrayList<CheckBox> mChecks4;
    private ArrayList<CheckBox> mSelectedChecks4;

    private ArrayList<CheckBox> mChecks6;
    private ArrayList<CheckBox> mSelectedChecks6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        Intent nameIntent = getIntent();
        playerName = nameIntent.getStringExtra("player_name");

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
        mChecks4 = new ArrayList<CheckBox>();
        mSelectedChecks4 = new ArrayList<CheckBox>();
        cb4a = findViewById(R.id.cb4a);
        cb4b = findViewById(R.id.cb4b);
        cb4c = findViewById(R.id.cb4c);
        cb4d = findViewById(R.id.cb4d);
        rb5a = findViewById(R.id.rb5a);
        rb5b = findViewById(R.id.rb5b);
        rb5c = findViewById(R.id.rb5c);
        rb5d = findViewById(R.id.rb5d);
        mChecks6 = new ArrayList<CheckBox>();
        mSelectedChecks6 = new ArrayList<CheckBox>();
        cb6a = findViewById(R.id.cb6a);
        cb6b = findViewById(R.id.cb6b);
        cb6c = findViewById(R.id.cb6c);
        cb6d = findViewById(R.id.cb6d);

        mChecks4.add(cb4a);
        mChecks4.add(cb4b);
        mChecks4.add(cb4c);
        mChecks4.add(cb4d);

        mChecks6.add(cb6a);
        mChecks6.add(cb6b);
        mChecks6.add(cb6c);
        mChecks6.add(cb6d);

        for (CheckBox c4 : mChecks4) {
            c4.setOnClickListener(this);
        }

        for (CheckBox c6 : mChecks6) {
            c6.setOnClickListener(this);
        }
    }



    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.cb4a || view.getId() == R.id.cb4b || view.getId() == R.id.cb4c || view.getId() == R.id.cb4d) {
            CheckBox c4 = (CheckBox) view;
            if (mSelectedChecks4.contains(c4)) {
                mSelectedChecks4.remove(c4);
            } else {
                if (mSelectedChecks4.size() < 2) {
                    mSelectedChecks4.add(c4);
                } else {
                    mSelectedChecks4.remove(0);
                    mSelectedChecks4.add(c4);
                }
            }
        }

        if (view.getId() == R.id.cb6a || view.getId() == R.id.cb6b || view.getId() == R.id.cb6c || view.getId() == R.id.cb6d) {
            CheckBox c6 = (CheckBox) view;
            if (mSelectedChecks6.contains(c6)) {
                mSelectedChecks6.remove(c6);
            } else {
                if (mSelectedChecks6.size() < 2) {
                    mSelectedChecks6.add(c6);
                } else {
                    mSelectedChecks6.remove(0);
                    mSelectedChecks6.add(c6);
                }
            }
        }

        drawResults();
    }

    public void drawResults() {
        for (CheckBox c4 : mChecks4) {
            c4.setChecked(mSelectedChecks4.contains(c4));
        }
        for (CheckBox c6 : mChecks6) {
            c6.setChecked(mSelectedChecks6.contains(c6));
        }
    }


    public void validate() {
        if (rb1c.isChecked()) {
            score++;
        }

        if (answerField.getText().toString().equals("1962")) {
            score++;

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
        return;


    }


    public void showResult(View view) {
        validate();
        Intent intent = new Intent(this, LastActivity.class);
        intent.putExtra("score", score);
        intent.putExtra("player_name", playerName);
        startActivity(intent);
    }



}



