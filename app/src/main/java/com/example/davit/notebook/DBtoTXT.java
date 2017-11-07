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
    String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/NotebookDB";
   // String[][] inputsplit;


    public String[]Import(){
        File file = new File (path + "/savedFile.txt");

        String [] loadText = Load(file);
        Log.e("all",loadText.toString());

//        String finalString = "";
//        for (int i = 0; i < loadText.length; i++)
//        {
//            inputsplit =new String[loadText.length][];
//            inputsplit[i]= loadText[i].split(" ");
//            for (int j = 0; j < 3; j++) {
//
//                Log.e("loaded" + i+" "+j,inputsplit[i][j]);
//            }
////            input[i]=loadText[i] + System.getProperty("line.separator");
//        }

        //String[] box=null;
//        for(int i=0; i < loadText.length; i++)
//        {
//            //Log.e("loadeddddddddddd"+i,""+loadText[i].split(" ")[0].toString());
//        //todo bajanel prabelnerov
//    if(loadText[i].split(" ")[0].toString()!=null)          inputsplit[i][0]= loadText[i].split(" ")[0].toString();
//    if(loadText[i].split(" ")[1].toString()!=null)          inputsplit[i][1]= loadText[i].split(" ")[1].toString();
//    if(loadText[i].split(" ")[2].toString()!=null)          inputsplit[i][2]= loadText[i].split(" ")[2].toString();
//        }
        for (int i = 0; i < loadText.length; i++)
        {
            //finalString += loadText[i] + System.getProperty("line.separator");
            for (int j = 0; j < 3; j++) {
//            Log.e("loaded i",""+inputsplit[i][j]);}
            }
        }
        return loadText;
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
