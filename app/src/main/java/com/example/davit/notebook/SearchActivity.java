package com.example.davit.notebook;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    Button b;
    EditText editrequest;
     ListView Word;
     Context context=this;
    DBhelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        Word= (ListView)  findViewById(R.id.wordsearch);
        editrequest= (EditText) findViewById(R.id.editrequest);
        mydb = new DBhelper(context);
        String request=null;
            request=getIntent().getExtras().getString("request",null);
        Log.e("this is sparta","request= "+request);
        final Cursor res = mydb.Search(request);
        Word.setAdapter(new Adapter (res,this));
    }


    public void find (View v)
    {
        if (editrequest.getText().toString().length()==0)
        {
            Context context = getApplicationContext();
            CharSequence text = "Please provide input";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }
        else
        {
            Intent go = new Intent(SearchActivity.this, SearchActivity.class);
            go.putExtra("request",editrequest.getText().toString());
            startActivity(go);
        }
    }
}
