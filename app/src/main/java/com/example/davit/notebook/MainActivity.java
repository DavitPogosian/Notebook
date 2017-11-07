package com.example.davit.notebook;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
<<<<<<< HEAD
import java.lang.reflect.Array;
=======
<<<<<<< HEAD
import java.lang.reflect.Array;
=======
>>>>>>> 8a78fc6b1e887313cbd868d61eab0a502ad4f456
>>>>>>> 1f87da8a3fb9b0b6889f368539353488ed6f7e79
import java.util.Random;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public DBhelper mydb;
    public Context context = this;
    String s = null;
    TextView t;
    Random r;
    TextView wordr;
    int maxID=0;
    int IDr;
    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/NotebookDatabase";

//    public    String pathbd=context.getDatabasePath(DBhelper.DB_NAME).toString().substring(0,context.getDatabasePath(DBhelper.DB_NAME).toString().length()-11);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isStoragePermissionGranted();

<<<<<<< HEAD
=======

>>>>>>> 1f87da8a3fb9b0b6889f368539353488ed6f7e79

        mydb = new DBhelper(context);
        t = (TextView) findViewById(R.id.txt);
        wordr = (TextView) findViewById(R.id.wordr);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent go = new Intent(MainActivity.this, AddActivity.class);
                go.putExtra("Letter", "A");
                startActivity(go);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Log.e("database directory =  ", "" + Environment.getDataDirectory());
        //pathbd=context.getDatabasePath(DBhelper.DB_NAME).toString().substring(0,context.getDatabasePath(DBhelper.DB_NAME).toString().length()-11);
        Log.e("database directory =  ", "" + context.getDatabasePath(DBhelper.DB_NAME).toString().substring(0, context.getDatabasePath(DBhelper.DB_NAME).toString().length() - 11));
        ////data//nguyenvanquan7826.com.tut.demodatabase//databases//


        Cursor res = mydb.GetNrOfWords();
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 1f87da8a3fb9b0b6889f368539353488ed6f7e79
        res.getCount();
        res.moveToNext();
        maxID = res.getInt(0);
        if ( maxID == 0) {

            mydb.close();
        } else {

//            //// TODO: 10/25/2017  nerqevi toxeri nman ara
//            while (res.moveToNext()) {
//
//                Log.e("maxID", "maxID=" + maxID);
//            }
            r = new Random();

             IDr = r.nextInt(maxID) + 1;
<<<<<<< HEAD
        }
=======
        }


        res = mydb.GetAll();

        int i=0;
        while (res.moveToNext()) {
            i++;
            if (i==IDr)
            {
                s = res.getString(1)+" "+res.getString(2);
                t.setText(R.string.mainr);
                wordr.setText(s);
            }
        }
//        if (res.getCount() == 0) {
//
//            mydb.close();
//        } else {
//
//            while (res.moveToNext()) {
//              s = res.getString(1)+" "+res.getString(2);
//               // Log.e("maxID", "maxID=" + maxID);
//            }
//            t.setText(R.string.mainr);
//            wordr.setText(s);
//        }

//
//            res = mydb.GetAll();
//            if (res.getCount() == 0) {
//
//                mydb.close();
//            } else {
//
//
//                s = "";
//                while (res.moveToNext()) {
//                    s += res.getString(1).replaceAll(" ", "_");
//                    ;//en
//                    s += " " + res.getString(2).replaceAll(" ", "_");
//                    ;//fr
//                    //s += " " + res.getString(0);//id
//                    s += " " + res.getString(3).replaceAll(" ", "_");//dom
//                    s += "\n";
//
//
//                }
//
//
//                t.setText(R.string.mainr);
//                //t.setText(s);
//            }
=======
>>>>>>> 1f87da8a3fb9b0b6889f368539353488ed6f7e79

        if (res.getCount() == 0) {

            mydb.close();
        } else {

<<<<<<< HEAD
        res = mydb.GetAll();

        int i=0;
        while (res.moveToNext()) {
            i++;
            if (i==IDr)
            {
                s = res.getString(1)+" "+res.getString(2);
                t.setText(R.string.mainr);
                wordr.setText(s);
            }
        }
//        if (res.getCount() == 0) {
//
//            mydb.close();
//        } else {
//
//            while (res.moveToNext()) {
//              s = res.getString(1)+" "+res.getString(2);
//               // Log.e("maxID", "maxID=" + maxID);
//            }
//            t.setText(R.string.mainr);
//            wordr.setText(s);
//        }

//
//            res = mydb.GetAll();
//            if (res.getCount() == 0) {
//
//                mydb.close();
//            } else {
//
//
//                s = "";
//                while (res.moveToNext()) {
//                    s += res.getString(1).replaceAll(" ", "_");
//                    ;//en
//                    s += " " + res.getString(2).replaceAll(" ", "_");
//                    ;//fr
//                    //s += " " + res.getString(0);//id
//                    s += " " + res.getString(3).replaceAll(" ", "_");//dom
//                    s += "\n";
//
//
//                }
//
//
//                t.setText(R.string.mainr);
//                //t.setText(s);
//            }
=======
            while (res.moveToNext()) {
                maxID = res.getInt(0);
                Log.e("maxID", "maxID=" + maxID);
            }
            r = new Random();
             IDr = r.nextInt(maxID) + 1;
        }
        res = mydb.GetWordByID(IDr);

        if (res.getCount() == 0) {

            mydb.close();
        } else {

            while (res.moveToNext()) {
              s = res.getString(1)+" "+res.getString(2);
               // Log.e("maxID", "maxID=" + maxID);
            }
            t.setText(R.string.mainr);
            wordr.setText(s);
>>>>>>> 8a78fc6b1e887313cbd868d61eab0a502ad4f456
>>>>>>> 1f87da8a3fb9b0b6889f368539353488ed6f7e79
        }

//
//            res = mydb.GetAll();
//            if (res.getCount() == 0) {
//
//                mydb.close();
//            } else {
//
//
//                s = "";
//                while (res.moveToNext()) {
//                    s += res.getString(1).replaceAll(" ", "_");
//                    ;//en
//                    s += " " + res.getString(2).replaceAll(" ", "_");
//                    ;//fr
//                    //s += " " + res.getString(0);//id
//                    s += " " + res.getString(3).replaceAll(" ", "_");//dom
//                    s += "\n";
//
//
//                }
//
//
//                t.setText(R.string.mainr);
//                //t.setText(s);
//            }
        }

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

>>>>>>> 8a78fc6b1e887313cbd868d61eab0a502ad4f456
>>>>>>> 1f87da8a3fb9b0b6889f368539353488ed6f7e79
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.notebook) {//nav_camera
            Intent go = new Intent(MainActivity.this, WordsActivity.class);
            go.putExtra("Letter", "A");
            startActivity(go);
        } else if (id == R.id.test) {//nav_gallery
            Intent go = new Intent(MainActivity.this, TestActivity.class);
            //go.putExtra("Letter", "A");
            startActivity(go);

        } else if (id == R.id.serch) {//nav_slideshow
            Intent go = new Intent(MainActivity.this, SearchActivity.class);
            go.putExtra("request", "#3#");
            startActivity(go);
        } else if (id == R.id.insert) {//nav_manage

            DBtoTXT db=new DBtoTXT();
            ImportDB(db.Import());


        } else if (id == R.id.export) {//nav_share

            exportDB();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 1f87da8a3fb9b0b6889f368539353488ed6f7e79
    public void ImportDB(String[] inputsplit)
    {
        String[][] input =new String[inputsplit.length][];
        for (int i = 0; i < inputsplit.length; i++)
        {

            input[i]= inputsplit[i].split(" ");
            for (int j = 0; j < 3; j++) {
               // if(input[i][j]!=null)
//                    Log.e("loaded" + i+" "+j,input[i][j]);
            }
//            input[i]=loadText[i] + System.getProperty("line.separator");
        }

            for(int i=0; i < input.length; i++) {
                try {

                    // TODO: 10/26/2017  chi tpum stringi Matrix@
                    Log.e("going to import", input[i][1].replaceAll("_", " ") + " " + input[i][0].replaceAll("_", " ") + " " + input[i][2].replaceAll("_", " "));
                    mydb.AddWord(input[i][1].replaceAll("_", " ") , input[i][0].replaceAll("_", " ") , input[i][2].replaceAll("_", " "));//fr//en//dom
                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Error in loading", Toast.LENGTH_LONG).show();
                }
            }
    }
    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("Permission","Permission is granted");
                return true;
            } else {

                Log.v("Permission","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("Permission","Permission is granted");
            return true;
<<<<<<< HEAD
=======
=======
    public void ImportDB(String[][] inputsplit)
    {
        for(int i=0; i < inputsplit.length; i++)
        {
            mydb.AddWord(inputsplit[i][1].replaceAll("_", " "),inputsplit[i][0].replaceAll("_", " "),inputsplit[i][2].replaceAll("_", " "));//fr//en//dom
>>>>>>> 8a78fc6b1e887313cbd868d61eab0a502ad4f456
>>>>>>> 1f87da8a3fb9b0b6889f368539353488ed6f7e79
        }
    }

    public void exportDB() {

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 1f87da8a3fb9b0b6889f368539353488ed6f7e79

//        File dir = new File(path);
//        dir.mkdirs();
//        File file = new File(path + "/Database.txt");
        isStoragePermissionGranted();
        Cursor res = mydb.GetAll();
        if (res.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "No words in database", Toast.LENGTH_LONG).show();
        } else {
            String all;
            all = "";
                while (res.moveToNext()) {
                    all += res.getString(1).replaceAll(" ", "_");
                    ;//en
                    all += " " + res.getString(2).replaceAll(" ", "_");
                    ;//fr
                    //s += " " + res.getString(0);//id
                    all += " " + res.getString(3).replaceAll(" ", "_");//dom
                    all += "\n";


                }

            String[] saveText = all.split(System.getProperty("line.separator"));//new String[0];// = String.valueOf(editText.getText()).split(System.getProperty("line.separator"));
<<<<<<< HEAD
=======
=======
//        File dir = new File(path);
//        dir.mkdirs();
//        File file = new File(path + "/Database.txt");
        String[] saveText = s.split(System.getProperty("line.separator"));//new String[0];// = String.valueOf(editText.getText()).split(System.getProperty("line.separator"));
>>>>>>> 8a78fc6b1e887313cbd868d61eab0a502ad4f456
>>>>>>> 1f87da8a3fb9b0b6889f368539353488ed6f7e79
//        Cursor res = mydb.GetAll();
//        if (res.getCount() == 0) {
//
//            mydb.close();
//        } else {
//            int i = 0;
//            while (res.moveToNext()) {
//                saveText[i] = res.getString(1);//en
//                saveText[i] += " " + res.getString(2);//fr
//                saveText[i] += " " + res.getString(0);//id
//                saveText[i] += " " + res.getString(3);//dom
//                saveText[i] += "\n";
//                i++;
//
//            }

            //editText.setText("");
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 1f87da8a3fb9b0b6889f368539353488ed6f7e79
            for (int i = 0; i < saveText.length; i++)
                Log.e("" + i + "\t", "" + saveText[i]);
            DBtoTXT db = new DBtoTXT();
            db.Export(saveText);

            Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

            // Save(file, saveText);

        }
    }
<<<<<<< HEAD
=======
=======
        for(int i=0;i<saveText.length; i++)
        Log.e(""+i+"\t",""+saveText[i]);
        DBtoTXT db=new DBtoTXT();
        db.Export(saveText);

            Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

           // Save(file, saveText);

        }




>>>>>>> 8a78fc6b1e887313cbd868d61eab0a502ad4f456
>>>>>>> 1f87da8a3fb9b0b6889f368539353488ed6f7e79
}
