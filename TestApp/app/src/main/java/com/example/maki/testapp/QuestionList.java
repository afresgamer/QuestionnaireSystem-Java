package com.example.maki.testapp;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by maki on 2018/12/06.
 */

public class QuestionList {

    Long id;
    String time;
    String question;
    String result;
    int Point;
    RadioGroup radioGroup;

    public  QuestionList(){}

    public  QuestionList(String s){ this.question = s; }

    public  QuestionList(String s,RadioGroup radioGroup){
        this.question = s;
        this.radioGroup = radioGroup;
    }

    public String GetTime(){ return time; }

    public void SetTime(String time){ this.time = time; }

    public Long GetId(){
        return  id;
    }

    public void SetId(Long id){
        this.id = id;
    }

    public String GetQuestion(){
        return  question;
    }

    public void SetQuestion(String question){
        this.question = question;
    }

    public  String GetResult(){return result;}

    public  void SetResult(String result){this.result = result;}

    public int GetPoint(){ return Point; }

    public void SetPoint(){ this.Point = Integer.parseInt(GetResult()); }

    public RadioGroup GetRadioGroup(){
        return radioGroup;
    }

    public void SetRadioGroup(RadioGroup radioGroup){
        this.radioGroup = radioGroup;
    }

}
