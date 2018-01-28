package com.semckinley.harknesstracker;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

import com.semckinley.harknesstracker.data.StudentContract;
import com.semckinley.harknesstracker.data.StudentDbHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HarkAdapter.HarkStudentClickListener{

    private static final int NUM_STUDENTS = 15;
    //Final form should not require this, but gets information from the data
    //Following the toy example they created this variable for the number of items in their list. With the variability of class sizes, may want to have this be set by user
    //TODO allow number of students to be input by user. Perhaps settings? Or data from a class file?
    private HarkAdapter mAdapter;

    private RecyclerView mStudentList;
    private String[] mStudentInfoList;
    StudentDbHelper mStudentDbHelper;
    SQLiteDatabase mDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
       // mStudentInfoList = intent.getStringArrayExtra("Student Names");
        mStudentDbHelper = new StudentDbHelper(this);
        //The above pretty much has to happen in all 'main activities' to get things rolling. At least as far as I know at this time

        mStudentList = (RecyclerView) findViewById(R.id.rv_students); //this creates the link between the java variable mStudentList and the Recyclerview in the layout xml file

        //below is the linearlayout manager set up that will help construct the recycler view?

        GridLayoutManager layoutManager= new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        mStudentList.setLayoutManager(layoutManager);
        //This links the recyclerview to the layoutmanager I've chosen at this time. Initially linear.


        mStudentList.setHasFixedSize(false);
        //going with true at first for simplicity sake, as it was in the example. However, classes can vary in size so may make this set to false in future
        mDb = mStudentDbHelper.getReadableDatabase();
        Cursor cursor = mDb.query(StudentContract.StudentEntry.TABLE_NAME, null, null, null, null, null,
                StudentContract.StudentEntry.COLUMN_COUNT);
        mAdapter = new HarkAdapter(cursor, this);
        mStudentList.setAdapter(mAdapter);

    }


    @Override
    public void onStudentClick(int clickedStudentIndex) {
        Context context = this;
        String name = mStudentInfoList[clickedStudentIndex].toString();

        Toast.makeText(context, name, Toast.LENGTH_LONG).show();
    }
}
