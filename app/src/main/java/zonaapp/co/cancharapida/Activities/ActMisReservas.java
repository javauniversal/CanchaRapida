package zonaapp.co.cancharapida.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import zonaapp.co.cancharapida.Adapters.BaseAdapterReservas;
import zonaapp.co.cancharapida.DataBase.DBHelper;
import zonaapp.co.cancharapida.R;

public class ActMisReservas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.latout_mis_reservas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DBHelper mydb = new DBHelper(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listViewReservas = (ListView)findViewById(R.id.listViewReservas);

        BaseAdapterReservas notiAdapter = new BaseAdapterReservas(this, mydb.selectReservas());
        listViewReservas.setAdapter(notiAdapter);

    }

}
