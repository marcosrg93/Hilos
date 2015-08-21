package com.rubinogarcia.ctohilos.ctohilos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by marco on 21/08/2015.
 */
public class Ayudante extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "anchortodcm.sqlite";
    public static final int DATABASE_VERSION = 1;

    public Ayudante(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql, sql1;

        sql1 = "create table " + Contrato.TablaHilos.TABLA + "( " +
                Contrato.TablaHilos._ID + " integer primary key autoincrement, " +
                Contrato.TablaHilos.ANCHOR + " text, " +
                Contrato.TablaHilos.DMC + " text " +
                ")";
        Log.v("CREA LA BD: ", sql1);
        db.execSQL(sql1);

        sql = "INSERT INTO \"anchortodmc\" VALUES('1','1','5200'),('2','2','Blanc'),('3','55','604');";



        Log.v("Insertamos valores: ", sql);
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Se elimina la version anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS "+Contrato.TablaHilos.TABLA+"");



    }//onUpgrade
}//Ayudante