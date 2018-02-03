package com.example.android.movieit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LastActivity extends AppCompatActivity {

        String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        Intent mIntent = getIntent();
        int score = mIntent.getIntExtra("score", 0);
        playerName = mIntent.getStringExtra("player_name");
        TextView totalScore = findViewById(R.id.score_field);
        totalScore.setText(getString(R.string.score_text, score));

    }

    private String createQuizSummary() {
        Intent mIntent = getIntent();
        int score = mIntent.getIntExtra("score", 0);
        playerName = mIntent.getStringExtra("player_name");

        String resultMessage = getString(R.string.score_owner, playerName, score);
        resultMessage += "\n" + getString(R.string.confident, playerName);
        return resultMessage;
    }

    public void shareResult(View view) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.check_my_result));
        intent.putExtra(Intent.EXTRA_TEXT, createQuizSummary());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void restart(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed(); commented this line in order to disable back press
        Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }


}
