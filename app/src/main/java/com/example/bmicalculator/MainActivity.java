package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bmicalculator.R;

public class MainActivity extends AppCompatActivity {

    EditText weightEditText, heightEditText;
    TextView bmiTextView;
    Button calculateButton, resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = findViewById(R.id.weight_edittext);
        heightEditText = findViewById(R.id.height_edittext);
        bmiTextView = findViewById(R.id.bmi_textview);
        calculateButton = findViewById(R.id.calculate_button);
        resetButton = findViewById(R.id.reset_button);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetInputs();
            }
        });
    }

    private void calculateBMI() {
        String weightString = weightEditText.getText().toString();
        String heightString = heightEditText.getText().toString();

        if (weightString.isEmpty() || heightString.isEmpty()) {
            bmiTextView.setText("Please enter weight and height values");
            return;
        }

        float weight = Float.parseFloat(weightString);
        float height = Float.parseFloat(heightString);

        if (height == 0) {
            bmiTextView.setText("Height cannot be zero");
            return;
        }

        float bmi = weight / (height * height);

        String bmiString = String.format("%.2f", bmi);

        bmiTextView.setText("BMI: " + bmiString);
    }

    private void resetInputs() {
        weightEditText.setText("");
        heightEditText.setText("");
        bmiTextView.setText("BMI: ");
    }
}