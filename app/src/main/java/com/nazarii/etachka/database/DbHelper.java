package com.nazarii.etachka.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.nazarii.etachka.database.Contract.Event;

/**
 * Created by nazik on 03.12.15.
 */
public class DbHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "etachki.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_EVENT_TABLE = "CREATE TABLE " + Contract.Event.TABLE_NAME + " (" +
                Event._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Event.COLUMN_DATE + " DATE," +
                Event.COLUMN_MILEAGE + " INTEGER," +
                Event.COLUMN_TYPE + " TEXT NOT NULL ON CONFLICT REPLACE);";
        sqLiteDatabase.execSQL(SQL_CREATE_EVENT_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Event.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
