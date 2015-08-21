package com.rubinogarcia.ctohilos.ctohilos;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by marco on 21/08/2015.
 */
public class Adaptador extends CursorAdapter {

    public Adaptador(Context context, Cursor c) {
        super(context, c, true);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater i = LayoutInflater.from(parent.getContext());
        View v = i.inflate(R.layout.detalle_color, parent, false);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView  tv3, tv4;
        tv3 = (TextView)view.findViewById(R.id.tvAnchor);
        tv4 = (TextView)view.findViewById(R.id.tvDcm);
        AnchorToDmc j = GestorAnchorToDmc.getRow(cursor);
        tv4.setText(j.getAnchor());
        tv3.setText(j.getDmc());
    }
}
