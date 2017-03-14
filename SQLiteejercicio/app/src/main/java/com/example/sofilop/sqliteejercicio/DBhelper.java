package com.example.sofilop.sqliteejercicio;

/**
 * Created by sofilop on 28/02/2017.
 */

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteOpenHelper;
import  android.database.sqlite.SQLiteDatabase;
public class DBhelper   extends  SQLiteOpenHelper{

    //Informacion de la tabla
    public  static final String TABLE_MEMBER="miembros";
    public  static final String MIEMBRO_id="_id";
    public static  final  String MIEMBRO_NOMBRE="nombre";

    //Informacion de a base de datos
    static final String DB_NAME="DBMIEMBRO";
    static  final int DB_VERSION=1;

    //informacion de la base de datos
    private  static final String CREATE_TABLE="create table "+TABLE_MEMBER+"("+MIEMBRO_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            MIEMBRO_NOMBRE+" TEXT NOT NULL);";

    public DBhelper(Context context) {


        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MEMBER);
        onCreate(db);
    }
}
