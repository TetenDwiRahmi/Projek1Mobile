package com.mobile.tugas1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.mobile.tugas1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    double a, c, f, k;
    String pilihanTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.temp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pilihanTemp = binding.temp.getSelectedItem().toString();
                Log.d("tag", "PIL : " + pilihanTemp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        binding.hasil.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                switch (pilihanTemp) {
                    case "Celsius":
                        c = Double.parseDouble(binding.angka.getText().toString());
                        f = (double) (c * 9.0/5.0) + 32;
                        k = c +  273.15;

                        binding.celcius .setText(c + "\u2103");
                        binding.fahrenheit .setText(f + "\u2109");
                        binding.kelvin .setText(k + "K");

                        break;
                    case "Fahrenheit":
                        f = Double.parseDouble(binding.angka.getText().toString());
                        c = (f - 32) * (5.0/9.0);
                        k = (f - 32) * (5.0/9.0) + 273.15;

                        binding.celcius .setText(c + "\u2103");
                        binding.fahrenheit .setText(f + "\u2109");
                        binding.kelvin .setText(k + "K");

                        break;

                    case "Kelvin":
                        k = Double.parseDouble(binding.angka.getText().toString());
                        c = k - 273.15;
                        f = (k - 273.15) * (9.0/5.0) + 32;

                        binding.celcius .setText(c + "\u2103");
                        binding.fahrenheit .setText(f + "\u2109");
                        binding.kelvin .setText(k + "K");
                        break;
                }
            }
        });

    }
}