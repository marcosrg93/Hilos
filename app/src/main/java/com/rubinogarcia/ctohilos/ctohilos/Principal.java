package com.rubinogarcia.ctohilos.ctohilos;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    private GestorAnchorToDmc gh;
    private EditText etDmc, etAnchor;
    private Adaptador ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        gh = new GestorAnchorToDmc(this);
        etDmc = (EditText)findViewById(R.id.etDmc);
        etAnchor = (EditText)findViewById(R.id.etAnchor);

        final ListView lv = (ListView)findViewById(R.id.lvJugadores);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                return false;
            }
        });

        gh.open();

        Cursor c = gh.getCursor();

        ad = new Adaptador(this, c);

        lv.setAdapter(ad);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
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
        if (id == R.id.alta) {
            alta();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        gh.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gh.close();
    }




    public void alta(){
        String telefono, fecha;
        telefono = etDmc.getText().toString();
        fecha = etAnchor.getText().toString();
        AnchorToDmc j = new AnchorToDmc (telefono, fecha);
        long id = gh.insert(j);
        tostada("El Hilo  " + j + " se ha creado con un ID " + id);
        Cursor c = gh.getCursor();
        ad.changeCursor(c);
        vaciarCampos();
    }

    public void buscarDCM(View v){
        String DCM;
        DCM = etDmc.getText().toString();
        Cursor c = gh.getAnchor(DCM);
        ad.changeCursor(c);

    }


    public void buscarANCHOR(View v){
        String ANCHOR;
        ANCHOR = etDmc.getText().toString();
        Cursor c = gh.getDcm(ANCHOR);
        ad.changeCursor(c);

    }


    public void vaciarCampos(){
        etDmc.setText("");
        etAnchor.setText("");
    }


    public void tostada(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
