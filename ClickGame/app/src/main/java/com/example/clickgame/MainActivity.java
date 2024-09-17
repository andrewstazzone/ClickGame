package com.example.clickgame;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    Button clickbtn, startbtn, clickbtn2;
    TextView tvremainTime, tvnoOfclicks;

    int timeremaining=20;
    int numofclicks=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickbtn2=findViewById(R.id.clickbtn2);
        clickbtn=findViewById(R.id.clickbtn);
        startbtn=findViewById(R.id.startbtn);
        tvremainTime=findViewById(R.id.tvtimeleft);
        tvnoOfclicks=findViewById(R.id.tvnumofclicks);

        clickbtn2.setEnabled(false);
        clickbtn.setEnabled(false);

        CountDownTimer timer=new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long l) {
                timeremaining--;
                tvremainTime.setText("Seconds Left: "+timeremaining);
            }

            @Override
            public void onFinish() {
                clickbtn.setEnabled(false);
                clickbtn2.setEnabled(false);
                startbtn.setEnabled(true);
            }
        };


        clickbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numofclicks++;
                tvnoOfclicks.setText("Number of clicks: "+numofclicks);
                clickbtn.setEnabled(false);
                clickbtn2.setEnabled(true);
            }
        });
        clickbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numofclicks++;
                tvnoOfclicks.setText("Number of clicks: "+numofclicks);
                clickbtn2.setEnabled(false);
                clickbtn.setEnabled(true);
            }
        });


        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                timer.start();
                startbtn.setEnabled(false);
                clickbtn.setEnabled(true);
                clickbtn2.setEnabled(true);
                timeremaining=20;
                numofclicks=0;
                tvremainTime.setText("Seconds Left: "+timeremaining);
                tvnoOfclicks.setText("Number of clicks: "+numofclicks);

            }
        });

    }
}