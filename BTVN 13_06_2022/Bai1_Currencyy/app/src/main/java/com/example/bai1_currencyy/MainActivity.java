package com.example.bai1_currencyy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String input = "0";
    private TextView textView_1, textView_2;
    final double DOLLAR = 1;
    final double DONG = 23000;
    final double YUAN = 6.7457;
    final double YEN = 134.96;
    final double WON = 1287.44;
    final double SOM = 11000.03;
    final double PESO = 53.25;
    double tien1 = DONG, tien2 = DONG;
    public double loaiTienTe(String country){
        switch (country){
            case "Vietnam - Dong":
                return DONG;
            case "China - Yuan":
                return YUAN;
            case "Japan - Yen":
                return YEN;
            case "Korean - Won":
                return WON;
            case "United States - Dollar":
                return DOLLAR;
            case "Uzbekistan - Som":
                return SOM;
            case "Philippines - Peso":
                return PESO;
            default:
                return 1;
        }
    }

    public void change(){
        double tien = Double.valueOf(input);
        double result = tien * (tien2/tien1);
        result = (double)Math.round(result * 1000) / 1000;
        textView_2.setText(String.valueOf(result));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_1 = (TextView) findViewById(R.id.textView_1);
        textView_2 = (TextView) findViewById(R.id.textView_2);
        textView_1.setText(input);
        Spinner spinner_1 = findViewById(R.id.spinner_1);
        ArrayAdapter<CharSequence> adapter_1 = ArrayAdapter.createFromResource(this,
                R.array.countries, android.R.layout.simple_spinner_item);
        adapter_1.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        if (spinner_1 != null) {
            spinner_1.setAdapter(adapter_1);
        }
        if (spinner_1 != null) {
            spinner_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String spinner_item = adapterView.getItemAtPosition(i).toString();
    //                Toast toast = Toast.makeText(MainActivity.this, "Spinner_1" + spinner_item, Toast.LENGTH_SHORT);
    //                toast.show();
                    tien1 = loaiTienTe(spinner_item);
                    change();
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }

        Spinner spinner_2 = findViewById(R.id.spinner_2);
        ArrayAdapter<CharSequence> adapter_2 = ArrayAdapter.createFromResource(this,
                R.array.countries, android.R.layout.simple_spinner_item);
        adapter_2.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        if (spinner_2 != null) {
            spinner_2.setAdapter(adapter_2);
        }
        if (spinner_2 != null) {
            spinner_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String spinner_item = adapterView.getItemAtPosition(i).toString();
                    tien2 = loaiTienTe(spinner_item);
                    change();
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
    }

    public void clickBtn(View view){
        Button btn = (Button) view;
        String data = btn.getText().toString();
        switch (data) {
            case "C":
                input = "0";
                break;
            case "BS":
                if (input.length() > 1) {
                    input = input.substring(0, input.length() - 1);
                } else{
                    input ="0";
                }
                break;
            default:
                if (input.charAt(0) == '0') {
                    input = data;
                    break;
                }
                input += data;
        }
        textView_1.setText(input);
        change();
    }
}