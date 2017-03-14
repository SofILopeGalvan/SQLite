package com.example.sofilop.sqliteejercicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import  android.content.Intent;
import android.database.Cursor;
import android.view.View;
import  android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import  android.widget.TextView;
public class MainActivity extends AppCompatActivity {
Button btnAgregarMiembro;
    ListView lista;
    SQLControlador dbConexion;
    TextView tv_miemID, tv_miemNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        dbConexion =new SQLControlador(this);
        dbConexion.abrirSBaseDeDatos();
        btnAgregarMiembro=(Button)findViewById(R.id.btnAgregarMiembro);
        lista=(ListView)findViewById(R.id.ListViewMiembro);

        //Accion del boton agregar Miembro
   btnAgregarMiembro.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {

           Intent agregar=new Intent(MainActivity.this,AgregarMiembro.class);
           startActivity(agregar);
       }
   });

        //Tomar los datos desde la base de datos para poner en el cursor
        Cursor cursor=dbConexion.leerDatos();

        String []from=new String []{
                DBhelper.MIEMBRO_id,DBhelper.MIEMBRO_NOMBRE
        };
        int [] to=new int[]{
R.id.et_miembro_id,R.id.miembro_nombre
        };
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(MainActivity.this,R.layout.formato_fila,cursor,from,to);
adapter.notifyDataSetChanged();

        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv_miemID=(TextView)view.findViewById(R.id.et_miembro_id);
                tv_miemNombre=(TextView)view.findViewById(R.id.miembro_nombre);

                String aux_miembroId=tv_miemID.getText().toString();
                String aux_miembroNombre=tv_miemNombre.getText().toString();

                Intent modify_inte=new Intent(getApplicationContext(),ModificarMiembro.class);
                modify_inte.putExtra("miembroId",aux_miembroId);
                modify_inte.putExtra("miembroNombre",aux_miembroNombre);
                startActivity(modify_inte);
            }
        });

    }
}
