package com.nazarii.etachka;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.nazarii.etachka.database.DbHelper;

public class EventActivity extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.db = new DbHelper(getApplicationContext()).getWritableDatabase();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        EditText date = (EditText) findViewById(R.id.date);
        final EditText type = (EditText) findViewById(R.id.type);
        final EditText mileage = (EditText) findViewById(R.id.mileage);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                ContentValues values = new ContentValues();
                values.put("type", type.getText().toString());
                values.put("mileage", Integer.valueOf(mileage.getText().toString()));
                db.insert("event", null, values);
                db.close();
                finish();
            }
        });
    }

}
