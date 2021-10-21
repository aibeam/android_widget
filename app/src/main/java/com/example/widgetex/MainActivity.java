package com.example.widgetex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rbMale, rbFemale;
    RadioGroup rbGroup;
    CheckBox cbApple, cbGrape, cbPlum;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbMale = findViewById(R.id.radioButton);
        rbFemale = findViewById(R.id.radioButton2);
        rbMale.setOnClickListener(v -> {
            Toast.makeText(this, "남", Toast.LENGTH_SHORT).show();
        });

        //RadioButton, CheckBox : setOnClickListener 활용.
        //RadioGroup : setOnCheckedChangeListener 활용해서 체크변화를 감지.
        //CheckBox : setOnCheckedChangeListener 활용해서 해당 버튼의 상태를 파악.

        rbGroup = findViewById(R.id.radioGroup);
        rbGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRb = (RadioButton)group.findViewById(checkedId);
                Toast.makeText(getApplicationContext(), checkedRb.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        cbApple = findViewById(R.id.cbApple);
        cbApple.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),((CheckBox)v).getText(), Toast.LENGTH_SHORT).show();
        });
        cbApple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton v, boolean isChecked) {
                Toast.makeText(getApplicationContext(),v.getText()+"/"+isChecked,
                        Toast.LENGTH_SHORT).show();
            }
        });

        button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), TextActivity.class);
            startActivity(intent);
        });

    }
}