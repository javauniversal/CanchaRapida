package zonaapp.co.cancharapida.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import zonaapp.co.cancharapida.R;

public class ActMain extends AppCompatActivity implements View.OnClickListener {

    private Button registrar;
    private Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        registrar = (Button) findViewById(R.id.btnRegistrar);
        registrar.setOnClickListener(this);
        ingresar = (Button) findViewById(R.id.btnIngresar);
        ingresar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnIngresar:
                break;

            case R.id.btnRegistrar:
                startActivity(new Intent(ActMain.this, ActRegistrarse.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
        }
    }
}
