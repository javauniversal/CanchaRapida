package zonaapp.co.cancharapida.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import zonaapp.co.cancharapida.DataBase.DBHelper;
import zonaapp.co.cancharapida.Entities.Usuarios;
import zonaapp.co.cancharapida.R;

public class ActRegistrarse extends AppCompatActivity {

    private EditText usuario;
    private EditText password;
    private EditText correo;
    private EditText telefono;
    private Button btnRegistrar;
    private DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_registrarse);

        mydb = new DBHelper(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        usuario = (EditText) findViewById(R.id.editUsuario);
        password = (EditText) findViewById(R.id.editContrasena);
        correo = (EditText) findViewById(R.id.editEmail);
        telefono = (EditText) findViewById(R.id.editTelCel);

        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidNumber(usuario.getText().toString())) {
                    usuario.setError("El usuario es un campo requerido");
                } else if (isValidNumber(password.getText().toString())) {
                    password.setError("El password es un campo requerido");
                } else if (isValidNumber(correo.getText().toString())){
                    correo.setError("la direccion de correo es un campo requerido");
                }else if(isValidNumber(telefono.getText().toString())) {
                    telefono.setError("El teléfono es un campo requerido");
                }else{
                    //Elimiar
                    mydb.deleteUsuarioAll();

                    //Guardar
                    Usuarios usuarios = new Usuarios();
                    usuarios.setUsuario(usuario.getText().toString());
                    usuarios.setPassword(password.getText().toString());
                    usuarios.setCorreo(correo.getText().toString());
                    usuarios.setTelefono(telefono.getText().toString());

                    if(mydb.insertUsuario(usuarios)){
                        Toast.makeText(ActRegistrarse.this, "El usuario fue registrado.", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(ActRegistrarse.this, ActMain.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }else {
                        Toast.makeText(ActRegistrarse.this, "Problemas al registrar el usuario.", Toast.LENGTH_LONG).show();
                        usuario.setText("");
                        password.setText("");
                        correo.setText("");
                        telefono.setText("");
                    }

                }
            }
        });

    }

    public boolean isValidNumber(String number){ return number == null || number.length() == 0; }


}
