package com.example.davit.notebook;

<<<<<<< HEAD
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
=======
import android.content.Context;
>>>>>>> 8a78fc6b1e887313cbd868d61eab0a502ad4f456
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
<<<<<<< HEAD
                    ttsEN.setLanguage(Locale.UK);
=======
                    ttsFR.setLanguage(Locale.UK);
>>>>>>> 8a78fc6b1e887313cbd868d61eab0a502ad4f456
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
<<<<<<< HEAD
        else if (dom.getText().toString().length()==0)
        {
            Context context = getApplicationContext();
            CharSequence text = "Word in Domain is required!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            ok=false;
        }
=======
>>>>>>> 8a78fc6b1e887313cbd868d61eab0a502ad4f456
        if(ok){
           mydb.EditWordByID(id,fr.getText().toString(),en.getText().toString(),dom.getText().toString());
            Intent go = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(go);
        }

    }
<<<<<<< HEAD
    public void delete(View v)
    {
        showDialog(1);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == 1) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
                    adb.setTitle("Delete");
                    adb.setMessage("Are you sure you want to delete this word?");
                    adb.setPositiveButton("Yes", myClickListener);
                    adb.setNegativeButton("No", myClickListener);
            adb.setIcon(android.R.drawable.ic_dialog_info);
            return adb.create();
        } return super.onCreateDialog(id);
    }
    DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case Dialog.BUTTON_POSITIVE:
                    deleteWord();
                    break;
                case Dialog.BUTTON_NEGATIVE:
                    break;
            }
        }
    };
    public void deleteWord()
    {
        mydb.DeletWord(id);
        Intent go = new Intent(this,MainActivity.class);
        startActivity(go);
    }


=======
>>>>>>> 8a78fc6b1e887313cbd868d61eab0a502ad4f456
    }
