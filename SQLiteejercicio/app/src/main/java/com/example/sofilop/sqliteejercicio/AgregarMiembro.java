package com.example.sofilop.sqliteejercicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AgregarMiembro extends AppCompatActivity  implements  OnClickListener{
EditText et;
    Button btnAgregar;
    SQLControlador dbconexion ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_miembro);

        et=(EditText)findViewById(R.id.et_miembro_id);
        btnAgregar=(Button)findViewById(R.id.btnAgrgar);
        dbconexion=new SQLControlador(this);
        dbconexion.abrirSBaseDeDatos();
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.btnAgrgar:
        String name=et.getText().toString();
        dbconexion.insertarDatos(name);
        Intent main=new Intent(AgregarMiembro.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(main);
        break;
    default:
        break;
}
    }
}
