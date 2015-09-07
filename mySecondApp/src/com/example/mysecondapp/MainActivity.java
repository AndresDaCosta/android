package com.example.mysecondapp;

/*
 * @author: jorge andres da costa ribeiro
 * @alias: buskador007
 * 
 * date: 07/09/2015
 * 
 *  
 * */

import java.util.zip.Inflater;


import android.app.Activity;
import android.os.Bundle;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
	


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Toast t = null;
		switch (v.getId()) {
		case R.id.normal:
			
			t = Toast.makeText(getApplicationContext(),"hola", Toast.LENGTH_SHORT); //creo un toast cogiendoe el application context
			
			t.show();  //muestro el toast
			
			break;
			
		case R.id.gravity:
			
			t = Toast.makeText(getApplicationContext(), "hola", Toast.LENGTH_SHORT);
			
			//creo un objeto de tipo toast para setearle atributos.
			
				t.setGravity(Gravity.CENTER|Gravity.TOP, 0, 0);
				
				//le seteo la gravedad en el centro y arriba con el caracter especial "|" y dandole valores 0, 0.
				
				
			t.show();   //muestro el layout
			
			break;
			
		case R.id.perso:
			
			Toast t2 = new Toast(getApplicationContext()); 
			
			//creamos un objeto de toast cogindo el aplication context
			
			LayoutInflater inflater = getLayoutInflater();
			
			//creo un inflater de layaout y conjo el layout inflater
						
			View layout = inflater.inflate(R.layout.layout_default, (ViewGroup) findViewById(R.id.mylayout));
			
			//paso al objeto de layout la ruta del layout y le paso tambien su id
			
			TextView tv = (TextView) layout.findViewById(R.id.textView1);
			
			//cojo el text view del layout con id 
			
			t2.setView(layout);
			
			//al objeto toast le seteo la vista del layout 
			
			t2.show();
			
			//muestro el toast 
			
			break;
		default:
			break;
		}
		
	}

}
