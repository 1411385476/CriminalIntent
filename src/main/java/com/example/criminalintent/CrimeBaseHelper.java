package com.example.criminalintent;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class CrimeBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimeBase.db";
    public CrimeBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crimeTable = "create table " + CrimeDbSchema.CrimeTable.NAME +
                "(" + "_id integer primary key autoincrement, "
                + CrimeDbSchema.CrimeTable.Cols.UUID + ", "
                + CrimeDbSchema.CrimeTable.Cols.TITLE +", "
                + CrimeDbSchema.CrimeTable.Cols.DATE +", "
                + CrimeDbSchema.CrimeTable.Cols.SOLVED +")";
        db.execSQL(crimeTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
