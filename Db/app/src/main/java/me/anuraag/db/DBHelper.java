package me.anuraag.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;


public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "TTEvents.db";
    public static final String CATEGORIES_TABLE_NAME = "categories";
    public static final String EVENTS_TABLE_NAME = "events";
    public static final String FAV_EVENTS_TABLE_NAME = "favevents";
    public static final String COLUMN_ID = "id";
    public static final String CATEGORY_ID = "cid";
    public static final String EVENT_ID = "eid";
    public static final String DESCRIPTION = "description";
    public static final String NAME = "name";
    public static final String EVENT_MAX_NO = "maxno";
    private Context mContext;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF  NOT EXISTS " + CATEGORIES_TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY," + CATEGORY_ID
                + " INTEGER," + NAME + " TEXT," + DESCRIPTION + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CATEGORIES_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + EVENTS_TABLE_NAME);
        onCreate(db);
    }

}