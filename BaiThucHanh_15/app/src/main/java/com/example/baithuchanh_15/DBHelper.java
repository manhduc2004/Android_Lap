package com.example.baithuchanh_15;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "qlsv.db";
    public static final int DB_VERSION = 1;

    public static final String TBL_LOP = "Lop";
    public static final String COL_MA = "MaLop";
    public static final String COL_TEN = "TenLop";
    public static final String COL_SISO = "SiSo";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TBL_LOP + " (" +
                COL_MA + " TEXT PRIMARY KEY," +
                COL_TEN + " TEXT NOT NULL," +
                COL_SISO + " INTEGER NOT NULL CHECK(" + COL_SISO + ">=0)" +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TBL_LOP);
        onCreate(db);
    }
}