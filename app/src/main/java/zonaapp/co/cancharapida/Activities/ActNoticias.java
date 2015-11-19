package zonaapp.co.cancharapida.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import zonaapp.co.cancharapida.Adapters.BaseAdapterNoticias;
import zonaapp.co.cancharapida.Entities.Noticias;
import zonaapp.co.cancharapida.R;

public class ActNoticias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_noticias);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listViewNoticias = (ListView)findViewById(R.id.listViewNoticias);

        List<Noticias> noticias = new ArrayList<>();

        noticias.add(new Noticias("El día después de la derrota de Colombia","Las caras largas con las que la Selección Colombia se despidió de Barranquilla el martes, luego de la derrota 0-1 contra Argentina, se prolongaron durante todo el miércoles. El grupo intenta elaborar el duelo y enderezar el camino hacia Rusia 2018. Por ahora, lo hacen en silencio."));
        noticias.add(new Noticias("Santa Fe y Junior definirán este jueves el campeón","Precisamente, este jueves, a las 7 p. m. (Win Sports y RCN), podrán conseguir la primera de esas tres metas cuando reciban a Junior, en juego de vuelta de la final de la Copa."));
        noticias.add(new Noticias("Sería lindo volver a River, dice Teófilo Gutiérrez","\"Siempre que esté la posibilidad, en algún futuro sería lindo volver a River\", dijo Gutiérrez en diálogo con radio La Red."));
        noticias.add(new Noticias("Mario Yepes no seguirá en San Lorenzo","Yepes les comunicó a los dirigentes de San Lorenzo que no renovará el contrato con el club, que termina el 31 de diciembre de este año."));
        noticias.add(new Noticias("Definidas las diez sedes de la Copa América ","La Concacaf y la Conmebol anunciaron este jueves las diez ciudades que recibirán la Copa América Centenario."));
        noticias.add(new Noticias("Medellín le ganó 2-0 a Millonarios y lo eliminó","Independiente Medellín venció este sábado 2-0 a Millonarios, eliminó al cuadro ‘embajador’ y quedó a un paso de la clasificación a los ‘play-offs’. Christian Marrugo y Daniel Torres sellaron la victoria ‘poderosa’, que dejó con 32 unidades al equipo antioqueño."));
        noticias.add(new Noticias("En el Centenario de Armenia, Huila y Junior","En un partido disputado el cuadro opita con varios jugadores juveniles y el onceno barranquillero con una nómina mixta, igualaron 2-2 en la capital quindiana ante unos 300 espectadores que presenciaron el  compromiso."));

        BaseAdapterNoticias notiAdapter = new BaseAdapterNoticias(this,noticias);
        listViewNoticias.setAdapter(notiAdapter);

    }

}
