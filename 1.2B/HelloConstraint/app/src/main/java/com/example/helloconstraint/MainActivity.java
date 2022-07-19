package com.example.helloconstraint;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private Button buttonCount;
    private Button buttonZero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        buttonCount = (Button) findViewById(R.id.button_count);
        buttonZero = (Button) findViewById(R.id.button_zero);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount!=null){
            mShowCount.setText(Integer.toString(mCount));
        }
        if (mCount%2==0){
            buttonCount.setBackgroundColor(Color.parseColor("green"));
            mShowCount.setBackgroundColor(Color.parseColor("black"));
            mShowCount.setTextColor(Color.parseColor("white"));
            String name = (String) mShowCount.getText()
        } else {
            buttonCount.setBackgroundColor(Color.parseColor("purple"));
        }
        buttonZero.setBackgroundColor(Color.parseColor("red"));
    }

    public void toZero(View view) {
        mCount = -1;
        buttonCount.callOnClick();
        buttonZero.setBackgroundColor(Color.parseColor("gray"));
    }
}