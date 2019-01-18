package com.example.maki.testapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by maki on 2018/12/06.
 */

public class ResultAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<QuestionList> questionLists;

    public ResultAdapter(Context context){
        this.context = context;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setQuestionLists(ArrayList<QuestionList> questionLists) {
        this.questionLists = questionLists;
    }

    @Override
    public int getCount(){
        return questionLists.size();
    }

    @Override
    public Object getItem(int position) {
        return questionLists.get(position);
    }

    @Override
    public long getItemId(int position) { return questionLists.get(position).GetId(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.list_result,parent,false);

        ((TextView)convertView.findViewById(R.id.Question02)).setText(String.valueOf(position) + " " + questionLists.get(position).GetQuestion());
        ((TextView)convertView.findViewById(R.id.Result)).setText(String.valueOf(questionLists.get(position).GetPoint()));

        return convertView;
    }

}
