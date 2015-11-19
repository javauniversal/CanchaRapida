package zonaapp.co.cancharapida.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import zonaapp.co.cancharapida.DataBase.DBHelper;
import zonaapp.co.cancharapida.Entities.Usuarios;
import zonaapp.co.cancharapida.R;

public class ActMain extends AppCompatActivity implements View.OnClickListener {

    private Button registrar;
    private Button ingresar;
    private DBHelper mydb;
    private EditText usuario;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        mydb = new DBHelper(this);

        registrar = (Button) findViewById(R.id.btnRegistrar);
        registrar.setOnClickListener(this);
        ingresar = (Button) findViewById(R.id.btnIngresar);
        ingresar.setOnClickListener(this);

        usuario = (EditText)findViewById(R.id.editUsuario);
        password = (EditText)findViewById(R.id.editPassword);

    }

    public boolean isValidNumber(String number){ return number == null || number.length() == 0; }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnIngresar:

                if (isValidNumber(usuario.getText().toString())) {
                    usuario.setError("El usuario es un campo requerido");
                } else if (isValidNumber(password.getText().toString())) {
                    password.setError("El password es un campo requerido");
                } else {
                    Usuarios usuarios = new Usuarios();
                    usuarios.setUsuario(usuario.getText().toString());
                    usuarios.setPassword(password.getText().toString());

                    if (!mydb.validateLogin(usuarios)) {
                        startActivity(new Intent(ActMain.this, ActMenu.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }else{
                        Toast.makeText(ActMain.this, "USUARIO/PASSWORD INCORRECTO", Toast.LENGTH_LONG).show();
                    }

                }

                break;

            case R.id.btnRegistrar:
                startActivity(new Intent(ActMain.this, ActRegistrarse.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
        }
    }
}
