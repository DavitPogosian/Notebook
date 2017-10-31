package com.example.davit.notebook;

/**
 * Created by Davit on 10/15/2017.
 */
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class DBtoTXT {
    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tutorial";


    public String[][] Import(){
        File file = new File (path + "/savedFile.txt");
        String [] loadText = Load(file);

        String finalString = "";

        String []input=null;
        for (int i = 0; i < loadText.length; i++)
        {
            //finalString += loadText[i] + System.getProperty("line.separator");
            Log.e("loaded i",""+loadText[i] + System.getProperty("line.separator"));
            input[i]=loadText[i] + System.getProperty("line.separator");
        }
        String[][] inputsplit=null;
        for(int i=0; i < loadText.length; i++)
        {
         //to do bajanel prabelnerov
        }
        //DBhelper mydb=new DBhelper(getApplicationContext());
        return inputsplit;
    }


    public boolean Export(String [] saveText )
    {
         //String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/NotebookDB";


        File dir = new File(path);
        dir.mkdirs();
        File file = new File (path + "/savedFile.txt");

        //Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

        boolean res=Save (file, saveText);

        return res;
    }
    public static boolean Save(File file, String[] data)
    {
        boolean res= true;
        FileOutputStream fos = null;
        try
        {

            fos = new FileOutputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace(); res=false;}
        try
        {
            try
            {
                for (int i = 0; i<data.length; i++)
                {

                        Log.e(""+i+"\t",""+data[i]);
                    //if (fos!=null)
                    fos.write(data[i].getBytes());
                    if (i < data.length-1)
                    {
                        //if(fos!=null)
                        fos.write("\n".getBytes());
                    }
                }
            }
            catch (IOException e) {e.printStackTrace();res=false;}
        }
        finally
        {
            try
            {
                fos.close();
            }
            catch (IOException e) {e.printStackTrace();res=false;}
        }

        return res;
    }


    public static String[] Load(File file)
    {
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String test;
        int anzahl=0;
        try
        {
            while ((test=br.readLine()) != null)
            {
                anzahl++;
            }
        }
        catch (IOException e) {e.printStackTrace();}

        try
        {
            fis.getChannel().position(0);
        }
        catch (IOException e) {e.printStackTrace();}

        String[] array = new String[anzahl];

        String line;
        int i = 0;
        try
        {
            while((line=br.readLine())!=null)
            {
                array[i] = line;
                i++;
            }
        }
        catch (IOException e) {e.printStackTrace();}
        return array;
    }

}
