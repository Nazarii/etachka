package com.nazarii.etachka.adapters;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.nazarii.etachka.R;
import com.nazarii.etachka.database.Contract;
import com.nazarii.etachka.database.DbHelper;
import com.nazarii.etachka.util.ValueHelper;

/**
 * Created by nazik on 03.12.15.
 */
public class EventAdapter extends CursorAdapter {

    private final LayoutInflater mInflater;

    public EventAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return mInflater.inflate(R.layout.list_item_event, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        String dateVal = cursor.getString(cursor.getColumnIndex(Contract.Event.COLUMN_DATE));
        String typeVal = cursor.getString(cursor.getColumnIndex(Contract.Event.COLUMN_TYPE));
        Integer mileageVal = cursor.getInt(cursor.getColumnIndex(Contract.Event.COLUMN_MILEAGE));

        TextView date = (TextView) view.findViewById(R.id.date);
        TextView type = (TextView) view.findViewById(R.id.type);
        TextView mileage = (TextView) view.findViewById(R.id.mileage);

//        date.setText(dateVal);
        type.setText(typeVal);
        mileage.setText(mileageVal.toString());
    }

    public static Cursor createFilteredCursor(Context context) {

        String[] columns = new String[]{
                Contract.Event._ID,
                Contract.Event.COLUMN_DATE,
                Contract.Event.COLUMN_TYPE,
                Contract.Event.COLUMN_MILEAGE
        };

        String sql = "SELECT "+ ValueHelper.join(columns, ", ")+
                " FROM "+ Contract.Event.TABLE_NAME +
                " ORDER BY "+ Contract.Event.COLUMN_MILEAGE+" DESC";

        SQLiteDatabase db = new DbHelper(context).getReadableDatabase();

        return db.rawQuery(sql, null);
    }
}

