package zonaapp.co.cancharapida.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import zonaapp.co.cancharapida.Entities.Reserva;
import zonaapp.co.cancharapida.Entities.Usuarios;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlUsuario = "CREATE TABLE usuario (id integer primary key AUTOINCREMENT, nombre text, password text, correo text, telefono text)";

        String sqlReserva = "CREATE TABLE reserva (id integer primary key AUTOINCREMENT, fechareserva text, horareserva text, idusuario int, cancha text )";

        String sqlCanchas = "CREATE TABLE cancha (id integer primary key AUTOINCREMENT, nombre text, jugadores int, metros text )";

        db.execSQL(sqlUsuario);
        db.execSQL(sqlReserva);
        db.execSQL(sqlCanchas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS usuario");
        db.execSQL("DROP TABLE IF EXISTS reserva");
        db.execSQL("DROP TABLE IF EXISTS cancha");
        this.onCreate(db);

    }

    public boolean insertReserva(Reserva data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        try {
            values.put("fechareserva",data.getFechaData());
            values.put("horareserva",data.getHoraData());
            values.put("idusuario",data.getIdUser());
            values.put("cancha",data.getCancha());

            db.insert("reserva", null, values);
        }catch (SQLiteConstraintException e){
            Log.d("data", "failure to insert word,", e);
            return false;
        }

        return true;
    }

    public List<Reserva> selectReservas(){

        ArrayList<Reserva> reservaArrayList = new ArrayList<>();

        String sql = "SELECT fechareserva, horareserva, usuario.nombre, cancha FROM reserva, usuario WHERE idusuario = usuario.id";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        Reserva reserva = null;
        if (cursor.moveToFirst()) {
            do {
                reserva = new Reserva();
                reserva.setFechaData(cursor.getString(0));
                reserva.setHoraData(cursor.getString(1));
                reserva.setNombreUsuario(cursor.getString(2));
                reserva.setCancha(cursor.getString(3));
                reservaArrayList.add(reserva);
            } while(cursor.moveToNext());
        }
        return reservaArrayList;
    }


    public boolean insertUsuario(Usuarios data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        try {
            values.put("nombre",data.getUsuario());
            values.put("password",data.getPassword());
            values.put("correo",data.getCorreo());
            values.put("telefono",data.getTelefono());

            db.insert("usuario", null, values);
        }catch (SQLiteConstraintException e){
            Log.d("data", "failure to insert word,", e);
            return false;
        }

        return true;
    }

    public boolean validateLogin(Usuarios data){

        SQLiteDatabase db;
        db = this.getWritableDatabase();
        Cursor cursor;
        String columns[] = {"nombre", "password", "correo", "telefono"};
        cursor = db.query("usuario", columns, "nombre = ? AND password = ?", new String[] {data.getUsuario(),data.getPassword()}, null, null, null, null);
        return cursor.getCount() <= 0;

    }

    public Usuarios selectUsuario(){

        String sql = "SELECT id, nombre, correo, telefono FROM usuario";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        Usuarios user = null;
        if (cursor.moveToFirst()) {
            do {
                user = new Usuarios();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setUsuario(cursor.getString(1));
                user.setCorreo(cursor.getString(2));
                user.setTelefono(cursor.getString(3));
            } while(cursor.moveToNext());
        }
        return user;
    }

    public boolean deleteUsuarioAll(){

        SQLiteDatabase db = this.getWritableDatabase();
        int p = db.delete("usuario", null, null);
        db.close();
        return p > 0;

    }

    public boolean validateUser(Usuarios data){

        return true;

    }




}
