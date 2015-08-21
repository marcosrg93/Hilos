package com.rubinogarcia.ctohilos.ctohilos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by marco on 21/08/2015.
 */
public class GestorAnchorToDmc {

    private Ayudante abd;
    private SQLiteDatabase bd;

    public GestorAnchorToDmc(Context c) {
        abd = new Ayudante(c);
    }
    public void open() {
        bd = abd.getWritableDatabase();
    }


    public void close() {
        abd.close();
    }


    public long insert(AnchorToDmc objeto) {
        ContentValues valores = new ContentValues();
        valores.put(Contrato.TablaHilos.ANCHOR, objeto.getAnchor());
        valores.put(Contrato.TablaHilos.DMC, objeto.getDmc());

        long id = bd.insert(Contrato.TablaHilos.TABLA, null, valores);

        return id;
    }


    public int delete(AnchorToDmc objeto) {
        String condicion = Contrato.TablaHilos._ID + " = ?";
        String[] argumentos = { objeto.getId() + "" };
        int cuenta = bd.delete(Contrato.TablaHilos.TABLA, condicion, argumentos);
        return cuenta;
    }

    public static AnchorToDmc getRow(Cursor c) {
        AnchorToDmc objeto = new AnchorToDmc();
        objeto.setAnchor(c.getString(1));
        objeto.setDmc(c.getString(2));
        return objeto;
    }


    public Cursor getCursor() {
        Cursor cursor = bd.query(Contrato.TablaHilos.TABLA, null, null, null, null, null, null);
        return cursor;
    }



    public Cursor getAnchor(String anchor){
        //Seleccionamos todas las filas de la tabla en las que se encuentra el parametro
        return bd.rawQuery(
                "select * from " +Contrato.TablaHilos.TABLA+ " WHERE "+Contrato.TablaHilos.ANCHOR+"= "+anchor, null);
    }

    public Cursor getDcm(String dmc){
        //Seleccionamos todas las filas de la tabla en las que se encuentra el parametro
        return bd.rawQuery(
                "select * from " +Contrato.TablaHilos.TABLA+ " WHERE "+Contrato.TablaHilos.DMC+"= "+dmc, null);
    }

}
