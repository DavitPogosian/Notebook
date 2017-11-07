package com.example.davit.notebook;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Davit on 10/13/2017.
 */

public class Adapter extends BaseAdapter {

    private Cursor dataArray;
    private Activity activity;
    public static LayoutInflater inflater = null;

    public Adapter(Cursor c, Activity a) {

        this.dataArray=c;
        this.activity=a;
        inflater = (LayoutInflater) this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

        try{
            return this.dataArray.getCount();
        }
        catch(Exception e){

            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ListCell cell;

        Cursor cursor = this.dataArray;


        Log.d("position","position ="+position);

        if(convertView == null)
        {
            convertView=inflater.inflate(R.layout.cell_layout,null);
            cell = new ListCell();
            cell.nameEN=(TextView) convertView.findViewById(R.id.nameen);
            cell.nameFR=(TextView) convertView.findViewById(R.id.namefr);
            convertView.setTag(cell);

        }
        else
        {
            cell= (ListCell) convertView.getTag();
        }

        int i=0;
        cursor.moveToFirst();
        cursor.move(position);
        cell.nameEN.setText(cursor.getString(1));
        cell.nameFR.setText(cursor.getString(2));
        cursor.moveToFirst();
        return convertView;
    }
    private class ListCell
    {

        private TextView nameEN;
        private TextView nameFR;
    }
}
