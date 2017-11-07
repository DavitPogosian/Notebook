    package com.example.davit.notebook;

    import android.content.Context;
    import android.content.Intent;
    import android.database.Cursor;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ListView;
    import android.widget.TextView;

    public class WordsActivity extends AppCompatActivity {

        TextView t;
        Button b;
        private ListView Word;
        public Context context=this;
        DBhelper mydb;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.words);
            t = (TextView) findViewById(R.id.txt);
            Word = (ListView) findViewById(R.id.word);
            mydb = new DBhelper(context);
            //String s=getIntent().getExtras().getString("Letter");
            String letter = getIntent().getExtras().getString("Letter");
            Log.e("tis is sparta", "l= " + letter);

            final Cursor res = mydb.GetWordByLetterInEn(letter);
            //final Cursor res = mydb.GetAll();

    //        t.setText(letter);
            //Log.e("this","a"+getIntent().getExtras().getInt("Button"));

            if (getIntent().getExtras().getInt("Button") > 0) {
                b = (Button) findViewById(getIntent().getExtras().getInt("Button"));
                b.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            } else {
                b = (Button) findViewById(R.id.bA);
                b.setBackgroundColor(getResources().getColor(R.color.colorAccent));

            }
            Word.setAdapter(new Adapter(res, this));
            this.Word.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    res.move(position);
                    Log.d("ProductID", res.getString(0));
                    Intent go = new Intent(getApplicationContext(), EditActivity.class);
                    go.putExtra("ID", res.getInt(0));
                    res.moveToFirst();
                    startActivity(go);
                }
            });
        }

        public void NeweLtter(View v)
        {
            Button b = (Button)v;
            String buttonText = b.getText().toString();
            Intent go = new Intent(WordsActivity.this, WordsActivity.class);
            go.putExtra("Letter", buttonText);
            go.putExtra("Button", b.getId());
            startActivity(go);
        }
    }
