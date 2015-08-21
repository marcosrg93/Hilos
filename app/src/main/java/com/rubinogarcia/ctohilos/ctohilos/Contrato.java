package com.rubinogarcia.ctohilos.ctohilos;

import android.provider.BaseColumns;

/**
 * Created by marco on 21/08/2015.
 */
public class Contrato{

    private Contrato (){
    }

    public static abstract  class TablaJugador implements BaseColumns{
        public static final String TABLA = "jugador";
        public static final String NOMBRE = "nombre";
        public static final String TELEFONO = "telefono";
        public static final String VALORACION = "valoracion";
        public static final String FNAC = "fNacimiento";

    }
    public static abstract  class TablaHilos implements BaseColumns{
        public static final String TABLA = "anchortodmc";
        public static final String ANCHOR = "anchor";
        public static final String DMC = "dmc";
    }
}
