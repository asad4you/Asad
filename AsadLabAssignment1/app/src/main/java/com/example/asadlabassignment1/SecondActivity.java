package com.example.asadlabassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    TextView oncreateCountSecondActivity,onstartCountSecondActivity,onresumeCountSecondActivity,onrestartCountSecondActivity;
    Button shift_back_btn;

    static int create_c = 0;
    static int start_c = 0;
    static int resume_c = 0;
    static int restart_c = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        oncreateCountSecondActivity = findViewById(R.id.oncreateCountSecondActivity);
        onstartCountSecondActivity = findViewById(R.id.onstartCountSecondActivity);
        onresumeCountSecondActivity = findViewById(R.id.onresumeCountSecondActivity);
        onrestartCountSecondActivity = findViewById(R.id.onrestartCountSecondActivity);
        shift_back_btn = findViewById(R.id.shift_back_btn);



        create_c++;
        oncreateCountSecondActivity.setText(String.valueOf(create_c));

        shift_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        start_c++;
        onstartCountSecondActivity.setText(String.valueOf(start_c));
    }

    @Override
    protected void onResume() {
        super.onResume();
        resume_c++;
        onresumeCountSecondActivity.setText(String.valueOf(resume_c));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        restart_c++;
        onrestartCountSecondActivity.setText(String.valueOf(restart_c));
    }

}