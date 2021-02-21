package com.example.unitcoverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unitcoverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button doConversion;
    private ActivityMainBinding binding;
    private EditText conversionInput;
    private TextView conversionOutput;
    private Title title = new Title("Conversion Tool");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fbtn = findViewById(R.id.convert_btn);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setTitle(title);

        ArrayAdapter<CharSequence> conversion_adapter =
                ArrayAdapter.createFromResource(this, R.array.conversions, android.R.layout.simple_spinner_item);
        Spinner conversion_spinner = findViewById(R.id.conversion_spinner);
        conversion_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        conversion_spinner.setAdapter(conversion_adapter);
        conversion_spinner.setOnItemSelectedListener(this);
        conversionInput = findViewById(R.id.input_field);
        conversionOutput = findViewById(R.id.output_text);
        Log.i("info", "Running");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.conversion_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        String selected = adapterView.getItemAtPosition(pos).toString();
        conversionInput.setText("");
        conversionOutput.setText("");
        Log.i("info", selected);
        switch(selected) {
            case "F to C":
                title.setTitle("Fahrenheit to Celcius");
                doConversion = findViewById(R.id.convert_btn);
                doConversion.setOnClickListener(v -> {
                    if (conversionInput.getText().length() == 0)
                        return;
                    double celcius = Converter.toCelcius(Float.parseFloat(conversionInput.getText().toString()));
                    conversionOutput.setText(String.format("%.2f ºC", celcius));
                });
                break;
            case "lb to kg":
                title.setTitle("Pounds to Kilograms");
                doConversion = findViewById(R.id.convert_btn);
                doConversion.setOnClickListener(v -> {
                    if (conversionInput.getText().length() == 0)
                        return;
                    double value = Converter.toKilogram(Float.parseFloat(conversionInput.getText().toString()));
                    conversionOutput.setText(String.format("%.2f kg", value));
                });
                break;
            case "oz to ml":
                title.setTitle("Ounces to Milliliters");
                doConversion = findViewById(R.id.convert_btn);
                doConversion.setOnClickListener(v -> {
                    if (conversionInput.getText().length() == 0)
                        return;
                    double value = Converter.toKilogram(Float.parseFloat(conversionInput.getText().toString()));
                    conversionOutput.setText(String.format("%.2f ml", value));
                });
                break;
            case "ft to m":
                title.setTitle("Feet to Meters");
                doConversion = findViewById(R.id.convert_btn);
                doConversion.setOnClickListener(v -> {
                    if (conversionInput.getText().length() == 0)
                        return;
                    double value = Converter.toMeter(Float.parseFloat(conversionInput.getText().toString()));
                    conversionOutput.setText(String.format("%.2f m", value));
                });
                break;
            default:
                Log.i("info", "Defaulted");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}