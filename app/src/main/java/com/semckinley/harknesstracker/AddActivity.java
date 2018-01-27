package com.semckinley.harknesstracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by stephen.mckinley on 1/26/18.
 */

public class AddActivity extends AppCompatActivity {

    private EditText mStudentName;
    private Button mAddButton;

    private String[] mStudentNameList;
        int num = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addclass_info);
        mStudentNameList = new String[15];
        mStudentName = (EditText) findViewById(R.id.et_student_name);
        mAddButton = (Button) findViewById(R.id.add_button);
        mAddButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (num<15){
                    mStudentNameList[num]= mStudentName.getText().toString();
                    num++;
                }

                  else {
                    Intent intent = new Intent(AddActivity.this, MainActivity.class);
                    intent.putExtra("Student Names", mStudentNameList);
                    startActivity(intent);

                }

                Toast.makeText(AddActivity.this, mStudentName.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
