package me.anuraag.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Database.db";
    private static final String TABLE_NAME = "table";
    private static final String COLUMN_ID = "cid";
    private static final String NAME = "name";
    private static final String COST = "cost";

    private Context mContext;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF  NOT EXISTS " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY," + NAME + " TEXT," + COST + " INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertIntoDB(Item item){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, item.getId());
        contentValues.put(NAME, item.getName());
        contentValues.put(COST, item.getCost());
        db.insert(TABLE_NAME, null, contentValues);
    }

    public void getCount(){


    }
}