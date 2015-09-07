package com.example.bbddandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class GestorBBDD extends SQLiteOpenHelper{
	
	private String sqlScript = "CREATE TABLE USUARIOS(codigo INTEGER, nombre TEXT )";
	
	public GestorBBDD(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL(sqlScript);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		
		
	}

}
