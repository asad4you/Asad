package com.example.asadtheoryassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Add add;
    Divide divide;
    Subtract subtract;
    Multiply multiply;
    EditText etValueOne, etValueTwo;
    TextView tvValueOne, tvValueTwo,tvResult;
    Spinner spOptions;
    Button btnCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValueOne=findViewById(R.id.etValueOne);
        etValueTwo=findViewById(R.id.etValueTwo);
        tvValueOne=findViewById(R.id.tvValueOne);
        tvValueTwo=findViewById(R.id.tvValueTwo);
        tvResult=findViewById(R.id.tvResult);
        spOptions=findViewById(R.id.spOptions);
        btnCalculate=findViewById(R.id.btnCalculate);
        add=new Add();
        subtract=new Subtract();
        multiply=new Multiply();
        divide=new Divide();

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.spValues, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spOptions.setAdapter(adapter);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvValueOne.getText().toString().equals("") || tvValueTwo.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Value Missing", Toast.LENGTH_SHORT).show();
                } else {
                    process(Integer.parseInt(etValueOne.getText().toString()), Integer.parseInt(etValueTwo.getText().toString()), spOptions.getSelectedItem().toString());
                }
            }
        });
    }
    void process(int first, int second, String op){
        if(op.equals("Add")){
            tvResult.setText("Result: "+add.cal(first, second));
        }
        else if(op.equals("Subtract")){
            tvResult.setText("Result: "+subtract.cal(first, second));
        }
        else if(op.equals("Multiply")){
            tvResult.setText("Result: "+multiply.cal(first, second));
        }
        else if(op.equals("Divide") && second!=0){
            divide.cal(first, second);
            tvResult.setText("Result: "+"Quotient: "+divide.quotient+"  "+"Remainder: "+divide.remainder);
        }
        else if(second==0 && op.equals("Divide")){
            Toast.makeText(this, "Divide by 0 exception", Toast.LENGTH_SHORT).show();
        }
    }
}