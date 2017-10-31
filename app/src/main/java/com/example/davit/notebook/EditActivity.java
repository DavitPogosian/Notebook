package com.example.davit.notebook;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class EditActivity extends AppCompatActivity {

    EditText fr;
    EditText en;
    EditText dom;
    public Context context=this;
    DBhelper mydb;
    TextToSpeech ttsFR;
    TextToSpeech ttsEN;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        fr= (EditText) findViewById(R.id.addfr);
        en= (EditText) findViewById(R.id.adden);
        dom= (EditText) findViewById(R.id.dom);
        mydb = new DBhelper(context);
        id = getIntent().getExtras().getInt("ID");
        Cursor res = mydb.GetWordByID(id);
        res.moveToFirst();
        Log.e("id ","id= "+res.getString(0));
        fr.setText(res.getString(2));
        en.setText(res.getString(1));
        dom.setText(res.getString(3));
        ttsFR = new TextToSpeech(getApplicationContext(),new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status) {
                if(status!= TextToSpeech.ERROR)
                {
                    ttsFR.setLanguage(Locale.FRANCE);
                }

            }
        });

        ttsEN = new TextToSpeech(getApplicationContext(),new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status) {
                if(status!= TextToSpeech.ERROR)
                {
                    ttsFR.setLanguage(Locale.UK);
                }

            }
        });
    }
    public void onPause()
    {
        if(ttsFR!=null) {
            ttsFR.stop();
            ttsFR.shutdown();
        }
        if(ttsEN!=null) {
            ttsEN.stop();
            ttsEN.shutdown();
        }
        super.onPause();
    }


    public void speek(View v)
    {
        if(v.getId()==R.id.imageView2) {
            String toSpeack = fr.getText().toString();
            ttsFR.speak(toSpeack, TextToSpeech.QUEUE_FLUSH, null);
        }else if (v.getId()==R.id.imageView5)
        {
            String toSpeack = en.getText().toString();
            ttsEN.speak(toSpeack, TextToSpeech.QUEUE_FLUSH, null);
        }

    }
    public void edit(View v)
    {
        boolean ok = true;
        if (en.getText().toString().length()==0)
        {
            Context context = getApplicationContext();
            CharSequence text = "Word in english is required!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            ok=false;
        }
        else if (fr.getText().toString().length()==0)
        {
            Context context = getApplicationContext();
            CharSequence text = "Word in french is required!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            ok=false;
        }
        if(ok){
           mydb.EditWordByID(id,fr.getText().toString(),en.getText().toString(),dom.getText().toString());
            Intent go = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(go);
        }

    }
    }
