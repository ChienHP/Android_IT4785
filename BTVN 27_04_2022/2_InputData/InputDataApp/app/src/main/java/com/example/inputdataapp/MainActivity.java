package com.example.inputdataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText editTextMSSV, editTextName, editTextCCCD, editTextPhone, editTextEmail;
    EditText editTextDateOfBirth, editTextPlaceOfOrigin, editTextAddress;
    TextView textViewMajor, textViewProgramLanguage;
    ImageView imageViewCalendar;
    RadioGroup radioGroup;
    RadioButton radioButton, radioButton2;
    CheckBox checkBox, checkBox2, checkBox3;
    CheckBox checkBoxDieuKhoan;
    Button buttonOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMSSV = (EditText) findViewById(R.id.editTextMSSV);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextCCCD = (EditText) findViewById(R.id.editTextCCCD);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextDateOfBirth = (EditText) findViewById(R.id.editTextDateOfBirth);
        textViewMajor = (TextView) findViewById(R.id.textViewMajor);
        textViewProgramLanguage = (TextView) findViewById(R.id.textViewProgramLanguage);
        imageViewCalendar = (ImageView) findViewById(R.id.imageViewCalendar);
        editTextPlaceOfOrigin = (EditText) findViewById(R.id.editTextPlaceOfOrigin);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButton =  (RadioButton) findViewById(R.id.radioButton);
        radioButton2 =  (RadioButton) findViewById(R.id.radioButton2);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBoxDieuKhoan = (CheckBox) findViewById(R.id.checkBoxDieuKhoan);
        buttonOK = (Button) findViewById(R.id.buttonOK);

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check()){
                    showToast(view);
                }
            }
        });
        imageViewCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectDate();
            }
        });

    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, "Nhập dữ liệu thành công.", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void selectDate(){
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i,i1,i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                editTextDateOfBirth.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR));
        datePickerDialog.show();
    }

    public boolean check(){
        boolean flag =true;
        String MSSV = editTextMSSV.getText().toString();
        if (MSSV.isEmpty()){
            editTextMSSV.setHintTextColor(Color.RED);
            flag=false;
        }
        String name = editTextName.getText().toString();
        if (name.isEmpty()){
            editTextName.setHintTextColor(Color.RED);
            flag=false;

        }
        String CCCD = editTextCCCD.getText().toString();
        if (CCCD.isEmpty()){
            editTextCCCD.setHintTextColor(Color.RED);
            flag=false;

        }
        String phoneNumber = editTextPhone.getText().toString();
        if (phoneNumber.isEmpty()){
            editTextPhone.setHintTextColor(Color.RED);
            flag=false;

        }
        String email = editTextEmail.getText().toString();
        if (email.isEmpty()){
            editTextEmail.setHintTextColor(Color.RED);
            flag=false;

        }
        String dateOfBirth = editTextDateOfBirth.getText().toString();
        if (dateOfBirth.isEmpty()){
            editTextDateOfBirth.setHintTextColor(Color.RED);
            flag=false;

        }
        String placeOfOrigin = editTextPlaceOfOrigin.getText().toString();
        if (placeOfOrigin.isEmpty()){
            editTextPlaceOfOrigin.setHintTextColor(Color.RED);
            flag=false;

        }
        String address = editTextAddress.getText().toString();
        if (address.isEmpty()){
            editTextAddress.setHintTextColor(Color.RED);
            flag=false;

        }
        if (!radioButton.isChecked()&&!radioButton2.isChecked()) {
            textViewMajor.setTextColor(Color.RED);
            flag = false;
        } else {
            textViewMajor.setTextColor(Color.WHITE);
        }
        if (!checkBox.isChecked()&&!checkBox2.isChecked()&&!checkBox3.isChecked()){
            textViewProgramLanguage.setTextColor(Color.RED);
            flag=false;
        }
        else {
            textViewProgramLanguage.setTextColor(Color.WHITE);
        }
        if (!checkBoxDieuKhoan.isChecked()){
            checkBoxDieuKhoan.setTextColor(Color.RED);
            flag=false;
        } else{
            checkBoxDieuKhoan.setTextColor(Color.WHITE);
        }
        return flag;
    }
}
