package com.nazarii.etachka.database;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by nazik on 03.12.15.
 */
public class Contract {

    public static final class Event implements BaseColumns {

        public static final String TABLE_NAME = "event";

        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_MILEAGE = "mileage";
    }
}
