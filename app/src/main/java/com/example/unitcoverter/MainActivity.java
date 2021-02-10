package com.example.unitcoverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fbtn = findViewById(R.id.convert_btn);

        EditText finput = findViewById(R.id.fahrenheit_input);
        TextView ctxt = findViewById(R.id.celcius_text);
        fbtn.setOnClickListener(v -> {
            if (finput.getText().length() == 0)
                return;
            double celcius = Converter.toCelcius(Float.parseFloat(finput.getText().toString()));
            ctxt.setText(String.format("%.2f ºC", celcius));
        });

        Button lbBtn = findViewById(R.id.pound_convert_btn);

        EditText lbInput = findViewById(R.id.pounds_input);
        TextView kgText = findViewById(R.id.kilograms_text);
        lbBtn.setOnClickListener(view -> {
            if (lbInput.getText().length() == 0)
                return;
            float kg = Converter.toKilogram(Float.parseFloat(lbInput.getText().toString()));
            kgText.setText(String.format("%.2f kg", kg));
        });

    }
}