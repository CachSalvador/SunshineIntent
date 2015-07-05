package com.example.salvador.sunshineintent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Salvador on 06/06/2015.
 */
public class IntentListItem extends Activity {

    private ImageView imagen;
    private TextView dia;
    private TextView clima;
    private TextView  temperatura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.intent_list_item);

        imagen = (ImageView)findViewById(R.id.imagen_intent);
        dia = (TextView)findViewById(R.id.dia_intent);
        clima = (TextView)findViewById(R.id.clima_intent);
        temperatura = (TextView)findViewById(R.id.temperatura_intent);

        Bundle bolsaR = getIntent().getExtras();
//        obtenemos el objeto serializado y lo pasamos a nuestra variable
        ClimaBean bolsitaSerializado = (ClimaBean)getIntent().getSerializableExtra("item");



        imagen.setImageResource(bolsaR.getInt("imagen"));
        dia.setText(bolsaR.getString("dia"));
        clima.setText(bolsaR.getString("clima"));
        temperatura.setText(bolsaR.getString("temperatura"));


    }
}
