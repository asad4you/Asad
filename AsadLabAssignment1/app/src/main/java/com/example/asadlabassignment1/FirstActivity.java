package com.example.asadlabassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {


    TextView oncreateCount,onstartCount,onresumeCount,onrestartCount;
    Button shift_btn;

    static int create_c = 0;
    static int start_c = 0;
    static int resume_c = 0;
    static int restart_c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        oncreateCount = findViewById(R.id.oncreateCount);
        onstartCount = findViewById(R.id.onstartCount);
        onresumeCount = findViewById(R.id.onresumeCount);
        onrestartCount = findViewById(R.id.onrestartCount);
        shift_btn = findViewById(R.id.shift_btn);



        create_c++;
        oncreateCount.setText(String.valueOf(create_c));

        shift_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        start_c++;
        onstartCount.setText(String.valueOf(start_c));
    }

    @Override
    protected void onResume() {
        super.onResume();
        resume_c++;
        onresumeCount.setText(String.valueOf(resume_c));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        restart_c++;
        onrestartCount.setText(String.valueOf(restart_c));
    }

}