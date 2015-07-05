package com.example.salvador.sunshineintent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Salvador on 27/05/2015.
 */
public class ListAdapterItem<Object> extends ArrayAdapter<Object>{

    TextView dia;
    TextView temperatura;
    TextView clima;
    ImageView imagen;

    public ListAdapterItem(Context context, int resource, List<Object> objects) {
        super(context, resource, objects);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        Object clima1 = getItem(position);

        String diaItem= ((ClimaBean)clima1).getDia();
        String temperaturaItem=((ClimaBean) clima1).getTemperatura();
        String climitaItem=((ClimaBean) clima1).getClima();
        int imagensita=((ClimaBean) clima1).getImagen();


        if (convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        dia = (TextView) convertView.findViewById(R.id.dia_item);
        temperatura= (TextView) convertView.findViewById(R.id.temperatura);
        clima= (TextView) convertView.findViewById(R.id.clima);
        imagen= (ImageView) convertView.findViewById(R.id.imagenClima);

            dia.setText(diaItem);
            temperatura.setText(temperaturaItem);
            clima.setText(climitaItem);
            imagen.setImageResource(imagensita);

        return convertView;

    }

}
