package com.example.vari_monitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b1.setAlpha(0f);
        b1.animate().alpha(1f).setDuration(1500);
        b2.setAlpha(0f);
        b2.animate().alpha(1f).setDuration(1500);
        b3.setAlpha(0f);
        b3.animate().alpha(1f).setDuration(1500);
    }
}