package com.semckinley.harknesstracker.data;

import android.provider.BaseColumns;

/**
 * Created by Mordor on 1/27/2018.
 * This Class is being used to replace StudentInfo class
 * Moving from using arraylist of StudentInfo to a more persistent data type
 * the SQLiteDatabase so that the data for the class remains once the app is closed
 * This hopefully will allow for the creation of mulitple class files that may be referenced in the future
 */

public class StudentContract {

    public static final class StudentEntry implements BaseColumns{

        public static final String TABLE_NAME = "Student Discussion Information";
        //Used internally as the name of the database table
        public static final String COLUMN_STUDENT_NAME = "student_name";
        //Used internally as the name of the column containing the student name
        public static final String COLUMN_COUNT = "How many times spoken";
        //Used internally as the name of the column containing the number of times the student has spoken during the discussion
        public static final String COLUMN_TIME = "How long the student spoke";
        //Used internally as the name of the column containing the amount of time the student spoke during the discussion
    }
}
