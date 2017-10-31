package com.example.davit.notebook;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class TestActivity extends AppCompatActivity {
     DBhelper mydb;
     Context context=this;
    TextView en;
    TextView fr1;
    TextView fr2;
    TextView fr3;
    TextView fr4;
    Button next,back;
    Random r;
    int trueanswer;
    int wordID;
    int answer1ID;
    int answer2ID;
    int answer3ID;
    String answer1;
    String answer2;
    String answer3;
    String wordfr;
    String worden;
    int nr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        mydb = new DBhelper(context);
        en=(TextView) findViewById(R.id.en);
        fr1=(TextView) findViewById(R.id.fr1);
        fr2=(TextView) findViewById(R.id.fr2);
        fr3=(TextView) findViewById(R.id.fr3);
        fr4=(TextView) findViewById(R.id.fr4);
        next=(Button) findViewById(R.id.next);
        back=(Button) findViewById(R.id.back);
        Cursor res = mydb.GetNrOfWords();
        res.moveToFirst();
        Log.e("maximum nr","nr= "+res.getString(0));
        nr=Integer.parseInt(res.getString(0));
        if (nr<3)
        {
            fr1.setVisibility(View.GONE);
            fr2.setVisibility(View.GONE);
            fr3.setVisibility(View.GONE);
            fr4.setVisibility(View.GONE);
            next.setVisibility(View.GONE);
            en.setText("You need at least 3 words for test");
        }
        else{
            r = new Random();
            trueanswer = r.nextInt(4) + 1;//1-4 true answer place
            wordID=r.nextInt(nr)+1;
            do {
                 answer1ID = r.nextInt(nr) + 1;
            }while (answer1ID == wordID);
            do {
                 answer2ID = r.nextInt(nr) + 1;
            }while( (answer2ID == wordID) || (answer2ID == answer1ID));
            do {
                 answer3ID = r.nextInt(nr) + 1;
            }while( (answer3ID == wordID) || (answer2ID == answer3ID) || (answer3ID == answer1ID));

            res = mydb.GetWordByID(wordID);
            res.moveToFirst();
            worden=res.getString(1);
            wordfr=res.getString(2);

            res = mydb.GetWordByID(answer1ID);
            res.moveToFirst();
            answer1=res.getString(2);

            res = mydb.GetWordByID(answer2ID);
            res.moveToFirst();
            answer2=res.getString(2);

            res = mydb.GetWordByID(answer3ID);
            res.moveToFirst();
            answer3=res.getString(2);

            en.setText(worden);
            switch (trueanswer)
            {
                case 1:
                    fr1.setText(wordfr);
                    fr2.setText(answer2);
                    fr3.setText(answer3);
                    fr4.setText(answer1);
                    break;
                case 2:
                    fr1.setText(answer2);
                    fr2.setText(wordfr);
                    fr3.setText(answer3);
                    fr4.setText(answer1);
                    break;
                case 3:
                    fr1.setText(answer3);
                    fr2.setText(answer2);
                    fr3.setText(wordfr);
                    fr4.setText(answer1);
                    break;
                case 4:
                    fr1.setText(answer1);
                    fr2.setText(answer2);
                    fr3.setText(answer3);
                    fr4.setText(wordfr);
                    break;
            }



        }

        Log.e("random","trueanswer= "+trueanswer+"\nwordID="+wordID+"\nanswer1ID="+answer1ID+"\nanswer2ID="+answer2ID+"\nanswer3ID="+answer3ID);


    }

    public void Back (View v){
        Intent go = new Intent(TestActivity.this, MainActivity.class);
        startActivity(go);

    }
    public void Check(View v)
    {
        fr1.setClickable(false);
        fr2.setClickable(false);
        fr3.setClickable(false);
        fr4.setClickable(false);

        int trueId=0;
        switch (trueanswer)
        {
            case 1:
                trueId=fr1.getId();
                fr1.setBackgroundColor(getResources().getColor(R.color.yallow));
                break;
            case 2:
                trueId=fr2.getId();
                fr2.setBackgroundColor(getResources().getColor(R.color.yallow));
                break;
            case 3:
                trueId=fr3.getId();
                fr3.setBackgroundColor(getResources().getColor(R.color.yallow));
                break;
            case 4:
                trueId=fr4.getId();
                fr4.setBackgroundColor(getResources().getColor(R.color.yallow));
                break;
        }
        if( v.getId()!= trueId)
            v.setBackgroundColor(getResources().getColor(R.color.red));

    }
    public void Next(View v)
    {

        Intent go = new Intent(TestActivity.this, TestActivity.class);
        startActivity(go);
    }
}
