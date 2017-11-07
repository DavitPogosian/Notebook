package com.example.davit.notebook;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText en;
    EditText dom;
    EditText fr;
    public DBhelper mydb;
    public Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        en = (EditText) findViewById(R.id.adden);
        dom = (EditText) findViewById(R.id.dom);
        fr = (EditText) findViewById(R.id.addfr);
        mydb = new DBhelper(context);
    }

    public void GoToMain(View v)
    {
        Intent go = new Intent(AddActivity.this, MainActivity.class);
        startActivity(go);
    }



    public void Add (View v)
    {
        boolean ok = true;
        boolean addbd = false;
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
        }else if (dom.getText().toString().length()==0)
        {
            Context context = getApplicationContext();
            CharSequence text = "Domain is required!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            ok=false;
        }

        if(ok){
            addbd= mydb.AddWord(fr.getText().toString(),en.getText().toString(),dom.getText().toString());
            if (addbd) {
                fr.setText("");
                en.setText("");
                dom.setText("");
            }
            else
            {
                Toast toast = Toast.makeText(getApplicationContext(), "errore in adding", Toast.LENGTH_SHORT);
                toast.show();

            }

        }

    }

}
