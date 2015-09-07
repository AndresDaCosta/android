package com.example.bbddandroid;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*GestorBBDD gddbb = new GestorBBDD(this, "DBUSER", null, 1);
		
		SQLiteDatabase SQL = null;
		
		SQL = gddbb.getWritableDatabase();
		
		if(SQL != null){
			
			for(int i = 0; i<3; i++){
				
					SQL.execSQL("INSERT INTO Usuarios (CODIGO,NOMBRE) VALUES("+i+",'Usuario"+i+"')");
			}
			SQL.close();
		}*/
		
		TextView txtcontactos = (TextView) findViewById(R.id.textView1);
		GestorBBDD usdbh =
	            new GestorBBDD(this, "DBUSER", null, 1);
	 
	        SQLiteDatabase db = usdbh.getWritableDatabase();
		
		Cursor c = db.rawQuery(" SELECT * FROM Usuarios ", null);
		
		Log.d("Ndatos", c.getCount()+"");
		StringBuffer datos = new StringBuffer();
		
		if (c.moveToFirst()) {
		     //Recorremos el cursor hasta que no haya más registros
		     do {
		          String codigo= c.getString(0);
		          String nombre = c.getString(1);
		          datos.append("codigo y nombre ");
					datos.append(codigo + " " + nombre);
					datos.append("\n");
		     } while(c.moveToNext());
		}
		
		c.close();
		txtcontactos.setText(datos);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void redireccion(){
		Toast.makeText(getApplicationContext(), "se mostrara los datos de la bbdd", 1);
		Intent intent_registro = new Intent(this,AccesoBBDD.class);
		startActivity(intent_registro);
		
		
	}
}
