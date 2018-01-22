package com.semckinley.harknesstracker;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_STUDENTS = 15;
    //Final form should not require this, but gets information from the data
    //Following the toy example they created this variable for the number of items in their list. With the variability of class sizes, may want to have this be set by user
    //TODO allow number of students to be input by user. Perhaps settings? Or data from a class file?
    private HarkAdapter mAdapter;

    private RecyclerView mStudentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //The above pretty much has to happen in all 'main activities' to get things rolling. At least as far as I know at this time

        mStudentList = (RecyclerView) findViewById(R.id.rv_students); //this creates the link between the java variable mStudentList and the Recyclerview in the layout xml file

        //below is the linearlayout manager set up that will help construct the recycler view?

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mStudentList.setLayoutManager(layoutManager);
        //This links the recyclerview to the layoutmanager I've chosen at this time. Initially linear.
        //TODO change from linearlayout to gridlayout. May be a better layout choice.
        //TODO Possibly make layout a settings choice for user preferences?
        mStudentList.setHasFixedSize(true);
        //going with true at first for simplicity sake, as it was in the example. However, classes can vary in size so may make this set to false in future

        mAdapter = new HarkAdapter(NUM_STUDENTS); //The argument will not be needed once reading from data is accomplished
        mStudentList.setAdapter(mAdapter);

    }


}
