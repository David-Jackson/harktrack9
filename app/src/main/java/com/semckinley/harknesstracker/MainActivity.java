package com.semckinley.harknesstracker;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    private static final int NUM_STUDENTS = 15;
    //Final form should not require this, but gets information from the data
    //Following the toy example they created this variable for the number of items in their list. With the variability of class sizes, may want to have this be set by user
    //TODO allow number of students to be input by user. Perhaps settings? Or data from a class file?
    private HarkAdapter mAdapter;

    private RecyclerView mStudentList;
    private String[] mStudentInfoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        mStudentInfoList = intent.getStringArrayExtra("Student Names");

        //The above pretty much has to happen in all 'main activities' to get things rolling. At least as far as I know at this time

        mStudentList = (RecyclerView) findViewById(R.id.rv_students); //this creates the link between the java variable mStudentList and the Recyclerview in the layout xml file

        //below is the linearlayout manager set up that will help construct the recycler view?

        GridLayoutManager layoutManager= new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        mStudentList.setLayoutManager(layoutManager);
        //This links the recyclerview to the layoutmanager I've chosen at this time. Initially linear.


        mStudentList.setHasFixedSize(true);
        //going with true at first for simplicity sake, as it was in the example. However, classes can vary in size so may make this set to false in future
        Log.i("tag", mStudentInfoList[5]);
        mAdapter = new HarkAdapter(mStudentInfoList);
        mStudentList.setAdapter(mAdapter);

    }




}
