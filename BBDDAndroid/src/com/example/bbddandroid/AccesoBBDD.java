package com.example.bbddandroid;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

@SuppressLint("NewApi")
public class AccesoBBDD extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acceso_bbdd);
		TextView txtcontactos = (TextView) findViewById(R.id.txtregistro);
		GestorBBDD usdbh =
	            new GestorBBDD(this, "DBUsuarios", null, 1);
	 
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
		getMenuInflater().inflate(R.menu.acceso_bbdd, menu);
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
}
