package com.semckinley.harknesstracker;

/**
 * Created by Mordor on 1/21/2018.
 */

public class StudentInfo {
    static String name; //Student's name
    static int count; //How many times student spoke
    static float time;//The amount of time the student for which the student spoke

    public StudentInfo(String name, int count, float time){
        this.name = name;
        this.count = count;
        this.time = time;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setCount(int count){
        this.count = count;
    }
    public void setTime(float time){
        this.time = time;
    }

    public String getName()
    {

        return this.name;
    }
    public int getCount(){
        return this.count;
    }
    public float getTime(){
        return this.time;
    }
}
