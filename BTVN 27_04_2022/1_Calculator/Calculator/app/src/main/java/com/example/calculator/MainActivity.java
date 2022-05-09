package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView_main, textView_second;
    private String input = "";
    private int result = 0;
    private int number_1, number_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_main = (TextView) findViewById(R.id.textView_main);
        textView_second = (TextView) findViewById(R.id.textView_second);
    }

    public boolean kiemTraBieuThuc(){
        if (input.split("\\+").length==2||input.split("\\-").length==2||input.split("\\*").length==2||input.split("\\/").length==2){
            return true;
        }
        return false;
    }
    public void calculate() {
        if (input.split("\\+").length==2){
            String numbers[] = input.split("\\+");
            number_1 = Integer.parseInt(numbers[0]);
            number_2 = Integer.parseInt(numbers[1]);
            result = number_1 + number_2;
            textView_second.setText(input);
            input = Integer.toString(result);
            return;
        }
        else if (input.split("\\-").length==2) {
            String numbers[] = input.split("\\-");
            number_1 = Integer.parseInt(numbers[0]);
            number_2 = Integer.parseInt(numbers[1]);
            result = number_1 - number_2;
            textView_second.setText(input);
            input = Integer.toString(result);
            return;
        }
        else if (input.split("\\*").length==2) {
            String numbers[] = input.split("\\*");
            number_1 = Integer.parseInt(numbers[0]);
            number_2 = Integer.parseInt(numbers[1]);
            result = number_1 * number_2;
            textView_second.setText(input);
            input = Integer.toString(result);
            return;
        }
        else if (input.split("\\/").length == 2) {
            String numbers[] = input.split("\\/");
            number_1 = Integer.parseInt(numbers[0]);
            number_2 = Integer.parseInt(numbers[1]);
            if (number_2==0){
                input = Integer.toString(number_1)+"/";
                textView_second.setText("Can not divide 0");
                return;
            }
            textView_second.setText(input);
            double temp = (double)number_1 / (double) number_2;
            input = Double.toString(temp);
        }
    }

    public void clickBtn(View view){
            Button btn = (Button) view;
            String data = btn.getText().toString();
            switch (data) {
                case "CE":
                    if (kiemTraBieuThuc()){
                        if (input.split("\\+").length==2){
                            String numbers[] = input.split("\\+");
                            number_1 = Integer.parseInt(numbers[0]);
                            number_2 = Integer.parseInt(numbers[1]);
                            input = Integer.toString(number_1)+"+";
                        }
                        else if (input.split("\\-").length==2) {
                            String numbers[] = input.split("\\-");
                            number_1 = Integer.parseInt(numbers[0]);
                            number_2 = Integer.parseInt(numbers[1]);
                            input = Integer.toString(number_1)+"-";
                        }
                        else if (input.split("\\*").length==2) {
                            String numbers[] = input.split("\\*");
                            number_1 = Integer.parseInt(numbers[0]);
                            number_2 = Integer.parseInt(numbers[1]);
                            input = Integer.toString(number_1)+"*";
                        }
                        else if (input.split("\\/").length == 2) {
                            String numbers[] = input.split("\\/");
                            number_1 = Integer.parseInt(numbers[0]);
                            number_2 = Integer.parseInt(numbers[1]);
                            input = Integer.toString(number_1)+"/";
                        }
                    }
                    break;
                case "C":
                    textView_second.setText("");
                    input = "0";
                    break;
                case "BS":
                    if (input.length() > 1) {
                        input = input.substring(0, input.length() - 1);
                    } else{
                        input ="0";
                    }
                    break;
                case "+":
                case "*":
                case "-":
                case "/":
                    if (input.charAt(input.length()-1)=='+'||input.charAt(input.length()-1)=='-'||input.charAt(input.length()-1)=='*'||input.charAt(input.length()-1)=='/'){
                        input = input.substring(0, input.length() - 1);
                    }
                    if (kiemTraBieuThuc()){
                        calculate();
                    }
                    input+=data;
                    break;
                case "=":
                    calculate();
                    break;
                default:
                    input += data;
            }
            if (input.length()>1 && Integer.parseInt(String.valueOf(input.charAt(0))) == 0){
                input = input.substring(1, input.length());
            }
            textView_main.setText(input);
    }
}