package com.example.unitcoverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fbtn = findViewById(R.id.convert_btn);
        ArrayAdapter<CharSequence> conversion_adapter =
                ArrayAdapter.createFromResource(this, R.array.conversions, android.R.layout.simple_spinner_item);
        Spinner conversion_spinner = findViewById(R.id.conversion_spinner);
        conversion_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        conversion_spinner.setAdapter(conversion_adapter);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.conversion_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        return true;
    }
}