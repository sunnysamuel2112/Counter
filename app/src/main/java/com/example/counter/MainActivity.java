package com.example.counter;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonStart, buttonStop, buttonReset;
    TextView textViewTime;
    int i=1;
    Handler customHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonStart = findViewById(R.id.buttonStart);
        buttonReset = findViewById(R.id.buttonReset);
        buttonStop = findViewById(R.id.buttonStop);
        textViewTime = findViewById(R.id.textViewtime);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customHandler.postDelayed(updateTimerThread,0);

            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customHandler.removeCallbacks(updateTimerThread);

            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customHandler.removeCallbacks(updateTimerThread);
                i=0;
                textViewTime.setText("");


            }
        });




    }

    private Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            textViewTime.setText(""+ i);
            customHandler.postDelayed(this,1000);
            i++;
        }
    };
}