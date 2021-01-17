package com.testappu.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button_calc = (Button) findViewById(R.id.button_calc);
        final EditText field_weight = (EditText) findViewById(R.id.field_weight);
        final EditText field_height = (EditText) findViewById(R.id.field_height);
        final TextView view_result = (TextView) findViewById(R.id.view_result);
        final TextView view_msg = (TextView) findViewById(R.id.view_msg);

        button_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double weight;
                double height;
                double bmi;
                String msg="";
                if(field_height.getText().toString().equals("") || field_weight.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"No valid values detected",Toast.LENGTH_LONG);

                }
                else {
                    weight = Double.parseDouble(field_weight.getText().toString());
                    height = Double.parseDouble(field_height.getText().toString());

                    bmi = height * height;
                    bmi = weight / bmi;
                    view_result.setText(String.valueOf(bmi));

                    if (bmi < 18.7) {
                        msg = "You are underweight !!";
                    } else if (bmi > 18.5 && bmi < 25) {
                        msg = "You are normal. Hooray :D";
                    } else if (bmi > 25) {
                        msg = "You are overweight !!";
                    }

                    view_msg.setText(msg);
                }
            }
        });
    }
}
