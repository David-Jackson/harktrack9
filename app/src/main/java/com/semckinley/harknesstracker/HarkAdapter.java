package com.semckinley.harknesstracker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mordor on 1/20/2018.
 * See license statement in activity_main.xml
 */

public class HarkAdapter extends RecyclerView.Adapter<HarkAdapter.StudentViewHolder>{
    private static final String TAG = HarkAdapter.class.getSimpleName();
    private int mStudentItems;
    private  String[] mStudentNames;


     ArrayList<StudentInfo> mStudentInfoList = new ArrayList<>();

    public HarkAdapter(int nameOfStudent){
        mStudentItems = nameOfStudent;


        mStudentNames = new String[]{"Bob", "Jane", "Mary", "Stephen", "Ethan", "Linus", "Cherish", "Allen", "Baelfyre", "Catharine", "Daviana", "Sydney", "Nick", "Dakota", "Eleven"};
        for(int i = 0; i<15; i++){

            mStudentInfoList.add( new StudentInfo(mStudentNames[i], i, 0));
            Log.i(TAG, mStudentNames[i]);
        }

    }
    //This is called to create the viewholders


    @Override
    public HarkAdapter.StudentViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForStudentItem = R.layout.student_list;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForStudentItem, viewGroup, shouldAttachToParentImmediately);
        StudentViewHolder viewHolder = new StudentViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(HarkAdapter.StudentViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        StudentInfo studentName = mStudentInfoList.get(position);

        for (int j = 0; j < 15; j++){
            //Log.i(TAG, mStudentNames[j]);
        }
        holder.bind(position);
    }
    @Override
    public int getItemCount() {
        return mStudentInfoList.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView listStudentView;

        public StudentViewHolder(View itemView){
            super(itemView);

            listStudentView = itemView.findViewById(R.id.tv_item_student);

        }
        void bind(int listIndex){

            listStudentView.setText(mStudentInfoList.get(listIndex).getName());
            Log.i(TAG, "This is the " + listIndex + "attempt");
        }
    }

   /* public static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.card_text_view)
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }*/

}


