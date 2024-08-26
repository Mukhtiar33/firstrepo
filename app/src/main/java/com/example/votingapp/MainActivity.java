package com.example.votingapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView palestinetext;
    TextView israeltext;

    Button palestinebtn;
    Button israelbtn;

    Button submitbtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        palestinetext = findViewById(R.id.tv_palestine_count);
        israeltext = findViewById(R.id.israel_vote_count);

        palestinebtn = findViewById(R.id.vote_btn_palestine);
        israelbtn = findViewById(R.id.vote_btn_israel);

        submitbtn = findViewById(R.id.submit_btn);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String palestinecount = palestinetext.getText().toString().trim();
                String israelcount = israeltext.getText().toString().trim();

                Log.d("MainActivity", "Palestine votes: " + palestinecount);
                Log.d("MainActivity", "Israel votes: " + israelcount);

                Intent intent = new Intent(MainActivity.this, Votingresult.class);
                intent.putExtra("PalestineVotes", palestinecount);
                intent.putExtra("IsraelVotes", israelcount);

                startActivity(intent);
            }
        });
    }

    public void onPalestineClicked(View v) {
        String palestine_count = palestinetext.getText().toString().trim();
        int count = 0;
        if (!palestine_count.isEmpty()) {
            count = Integer.parseInt(palestine_count);
        }
        count++;
        palestinetext.setText(String.valueOf(count));
    }

    public void onIsraelClicked(View v) {
        String israel_count = israeltext.getText().toString().trim();
        int count = 0;
        if (!israel_count.isEmpty()) {
            count = Integer.parseInt(israel_count);
        }
        count++;
        israeltext.setText(String.valueOf(count));
    }
}
