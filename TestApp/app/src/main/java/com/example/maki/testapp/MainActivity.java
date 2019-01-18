package com.example.maki.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<QuestionList> questionLists;
    QuestionList questionList;

    private  static  final  String[] Questions =
            {
                    "襷坂46", "MONGOL800" ,"THE ORAL CIGARETTES","キュウソネコカミ","クリープハイプ"
                    ,"UVERWORLD","10-FEET","BIGMAMA","BaseBallBear","竹原ピストル","175R","THE BAWDIES","東京スカパラダイスオーケストラ"
                    ,"Aqua Timez","go!go!vanillas","LiSA","dustbox","フジファブリック","coldrain","SUPER BEAVER","m-flo","エレファントカシマシ"
                    ,"Yogee New Waves","SHE'S","SPECIAL OTHERS","大森靖子","筋肉少女帯","雨のパレード","CAPSULE/中田ヤスタカ","DJ'TEKINA//SOMETHIMG a.k.a ゆよゆっぺ"
                    ,"RO JACK","シシド・カフカ","め組","NGT48","Takaryu","あいみょん","HUSKING BEE","DJやついいちろう(エレキコミック)","banvox"
                    ,"おめでたい頭でなにより","CREAM","バンドハラスメント","PENGUIN RESEARCH","NAMBA69","BURNOUT SYNDROMES","SAKANAMON","パノラマパナマタウン"
                    ,"Lenny code fiction","Survive Said The Prophet","サニーデイ・サービス","鈴木愛理","Saucy Dog"
            };


    private  RadioGroup[] radioGroups = new RadioGroup[52];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStartView();
    }

    public void setStartView(){
        setContentView(R.layout.activity_main);
        listView =(ListView)findViewById(R.id.ListView01);

        questionLists = new ArrayList<>();
        QuestionAdapter questionAdapter = new QuestionAdapter(MainActivity.this);

        questionAdapter.setQuestionLists(questionLists);
        listView.setAdapter(questionAdapter);

        for (int i = 0; i < Questions.length; i++){
            questionList = new QuestionList();
            questionList.SetQuestion(Questions[i]);
            questionList.SetRadioGroup(radioGroups[i]);
            questionLists.add(questionList);
        }
        questionAdapter.notifyDataSetChanged();

        //ボタンイベント処理
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //結果発表画面へ遷移
                setResultView();
            }
        });
    }

    public void setResultView(){
        setContentView(R.layout.activity_result);
        listView = (ListView)findViewById((R.id.ListView02));

        ResultAdapter resultAdapter = new ResultAdapter(MainActivity.this);
        resultAdapter.setQuestionLists(questionLists);
        listView.setAdapter(resultAdapter);

        for (int i = 0; i < Questions.length; i++){
            questionList.SetQuestion(Questions[i]);
            questionList.SetResult(questionLists.get(i).GetResult());
            questionLists.add(questionList);
        }
        resultAdapter.notifyDataSetChanged();

        //ボタンイベント処理
        Button button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setStartView();
            }
        });
    }
 }
