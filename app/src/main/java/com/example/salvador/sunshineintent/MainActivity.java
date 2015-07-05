package com.example.salvador.sunshineintent;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        private ListAdapterItem<Object> adapterItem;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ListView listView = (ListView) rootView.findViewById(R.id.listview_fragment);
            //   listView.setAdapter(adapter);

            ClimaBean clima1 = new ClimaBean("lunes","22º/18º","Medio nublado",R.drawable.mediosoleado);
            ClimaBean clima2 = new ClimaBean("Martes","22º/18º","Medio nublado",R.drawable.mediosoleado);
            ClimaBean clima3 = new ClimaBean("Miercoles","22º/18º","Medio nublado",R.drawable.mediosoleado);
            ClimaBean clima4 = new ClimaBean("Jueves","25º/18º","Medio nublado",R.drawable.mediosoleado);
            ClimaBean clima5 = new ClimaBean("Viernes", "27º/18º","Soleado",R.drawable.soleado);
            ClimaBean clima6 = new ClimaBean("Sabado", "19º/18º","Nublado",R.drawable.nublado);
            ClimaBean clima7 = new ClimaBean("Domingo","19º/18º","Nublado",R.drawable.nublado);

            ArrayList<Object> objetos = new ArrayList<Object>();
            objetos.add(clima1);
            objetos.add(clima2);
            objetos.add(clima3);
            objetos.add(clima4);
            objetos.add(clima5);
            objetos.add(clima6);
            objetos.add(clima7);

             adapterItem = new ListAdapterItem<Object>(getActivity(),
                    R.layout.list_item,
                    objetos);
            listView.setAdapter(adapterItem);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    ClimaBean item  =(ClimaBean) adapterItem.getItem(position);

                    //Agregar los valores del item en un array de integer
//                    ArrayList<Integer> datos = new ArrayList<Integer>();
//                    datos.add(Integer.parseInt(item.getDia()));
//                    datos.add(Integer.parseInt(item.getClima()));
//                    datos.add(Integer.parseInt(item.getTemperatura()));
//                    datos.add(item.getImagen());


//                    Desglosando los valores del item para pasarlos uno por uno
                    String dia = item.getDia().toString();
                    String clima = item.getClima().toString();
                    String  temperatura = item.getTemperatura().toString();
                    int imagen = item.getImagen();

//                    Toast t = Toast.makeText(getActivity(),item.getDia().toString(), Toast.LENGTH_SHORT);
//                    t.show();
//                    INTENT EXPLICITO

                    Intent intent = new Intent("com.example.salvador.sunshine.IntentListItem");
                    Bundle bolsita= new Bundle();
                    bolsita.putString("dia",dia);
                    bolsita.putString("clima",clima);
                    bolsita.putString("temperatura",temperatura);
                    bolsita.putInt("imagen",imagen);
                    intent.putExtras(bolsita);
//                    Volver serializable mi objeto clima(item) para enviar un objeto en lugar de datos uno por uno. En el bean hay
//                    que implementar de serializable.
                    Bundle bolsitaSerializado = new Bundle();
                    bolsitaSerializado.putSerializable("item", item);

                    startActivity(intent);


                    /*INTENT IMPLICITO
                    Intent intentImplicito= new Intent(Intent.ACTION_VIEW);
                    intentImplicito.setData(Uri.parse("9981919447"));
                    startActivity(intentImplicito);*/
                }
            });





            return rootView;
        }
    }
}
