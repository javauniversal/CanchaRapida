package zonaapp.co.cancharapida.Activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import zonaapp.co.cancharapida.Fregments.Fragment1;
import zonaapp.co.cancharapida.Fregments.Fragment2;
import zonaapp.co.cancharapida.Fregments.Fragment3;
import zonaapp.co.cancharapida.Fregments.Fragment4;
import zonaapp.co.cancharapida.R;

public class ActReservas extends AppCompatActivity {

    private Spinner tiposEquipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_reservas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cargarSpinner();
    }

    private void cargarSpinner() {
        new Thread(new Runnable() {
            String[] tiposPc = {"Cancha Santiago Bernabéu","Cancha Atanasio Girardot","Cancha Maracaná","Cancha San Siro"};
            public void run() {
                tiposEquipos = (Spinner) findViewById(R.id.spinnerTiposParte);
                ArrayAdapter<String> datosTipos = new ArrayAdapter<String>(ActReservas.this, R.layout.item_spinner, tiposPc);
                tiposEquipos.setAdapter(datosTipos);
                tiposEquipos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        Object item = parent.getSelectedItem();

                        FragmentManager fragmentManager = getFragmentManager();
                        switch (item.toString()){
                            case "Cancha Santiago Bernabéu":
                                fragmentManager.beginTransaction()
                                        .replace(R.id.contenedor, Fragment1.newInstance("", ""))
                                        .commit();
                                break;
                            case "Cancha Atanasio Girardot":
                                fragmentManager.beginTransaction()
                                        .replace(R.id.contenedor, Fragment2.newInstance("", ""))
                                        .commit();
                                break;
                            case "Cancha Maracaná":
                                fragmentManager.beginTransaction()
                                        .replace(R.id.contenedor, Fragment3.newInstance("", ""))
                                        .commit();
                                break;
                            case "Cancha San Siro":
                                fragmentManager.beginTransaction()
                                        .replace(R.id.contenedor, Fragment4.newInstance("", ""))
                                        .commit();

                                break;
                        }
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
            }
        }).start();
    }
}
