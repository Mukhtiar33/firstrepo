package com.example.votingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Votingresult extends AppCompatActivity {

    TextView resultTextView;
    int palestinecount = 0;
    int israelcount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votingresult);

        resultTextView = findViewById(R.id.voting_result);

        // Get the intent that started this activity
        Intent intent = getIntent();
        // Retrieve vote counts from the intent
        String palestineVotes = intent.getStringExtra("PalestineVotes");
        String israelVotes = intent.getStringExtra("IsraelVotes");

        try {
            if (palestineVotes != null && !palestineVotes.isEmpty()) {
                palestinecount = Integer.parseInt(palestineVotes);
            }
            if (israelVotes != null && !israelVotes.isEmpty()) {
                israelcount = Integer.parseInt(israelVotes);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        // Display the results
        if (palestinecount > israelcount) {
            resultTextView.setText("Palestine wins with " + palestinecount + " votes!");
        } else if (israelcount > palestinecount) {
            resultTextView.setText("Israel wins with " + israelcount + " votes!");
        } else {
            resultTextView.setText("It's a tie with " + palestinecount + " votes each!");
        }
    }
}
