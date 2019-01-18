package com.example.maki.testapp;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
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

public class QuestionAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater = null;
    ArrayList<QuestionList> questionLists;

    public QuestionAdapter(Context context){
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
    public long getItemId(int position) {
        return questionLists.get(position).GetId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.list_list,parent,false);

        ((TextView)convertView.findViewById(R.id.Question01)).setText(questionLists.get(position).GetQuestion());
        RadioGroup radioGroup = (RadioGroup)convertView.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton radioButton = (RadioButton)radioGroup.getRootView().findViewById(checkedId);
                String text = radioButton.getText().toString();
                questionLists.get(position).SetResult(text);
                questionLists.get(position).SetPoint();
            }
        });
        return convertView;
    }
}
