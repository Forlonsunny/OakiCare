package com.theoakteam.sunny_pc.oakicare.ProfileDabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sunny_PC on 6/10/2015.
 */
public class DBhelper extends SQLiteOpenHelper {

    public  static final String DATABASE_NAME="profile.db";
    public  static final int DATABASE_VERSION=1;

    public static final String TABLE_PROFILE="profile";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_PROFLIE_NAME="profile_name";
    public static final String COLUMN_PROFLIE_HEGHT="height";
    public static final String COLUMN_PROFLIE_WEIGHT="weight";
    public static final String COLUMN_PROFLIE_BLOOD_GROUP="blood_group";

//    // SQL statement of the Employees table creation
//    private static final String SQL_CREATE_TABLE_EMPLOYEES = "CREATE TABLE " + TABLE_EMPLOYEES + "("
//            + COLUMN_EMPLOYEE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//            + COLUMN_EMPLOYEE_NAME + " TEXT NOT NULL, "
//            + COLUMN_EMPLOYEE_ADDRESS + " TEXT NOT NULL, "
//            + COLUMN_EMPLOYEES_WEBSITE + " TEXT NOT NULL, "
//            + COLUMN_EMPLOYEES_PHONE_NUMBER + " TEXT NOT NULL "
//            +");";
    private static final String SQL_CREATE_TABLE_PROFILE="CREATE TABLE "+TABLE_PROFILE+"("
            +COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_PROFLIE_NAME+" TEXT NOT NULL, "
            +COLUMN_PROFLIE_HEGHT+" TEXT NOT NULL, "
            +COLUMN_PROFLIE_WEIGHT+" TEXT NOT NULL, "
            +COLUMN_PROFLIE_BLOOD_GROUP+" TEXT NOT NULL "
            +")";

    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DBhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL(SQL_CREATE_TABLE_PROFILE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
