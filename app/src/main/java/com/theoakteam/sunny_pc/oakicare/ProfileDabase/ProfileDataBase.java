package com.theoakteam.sunny_pc.oakicare.ProfileDabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.theoakteam.sunny_pc.oakicare.Module.Profile;

/**
 * Created by Sunny_PC on 6/10/2015.
 */
public class ProfileDataBase {
    private DBhelper mdDBhelper;
    private SQLiteDatabase mSqLiteDatabase;
    private Context mContext;
    private String[] mAllColumns={mdDBhelper.COLUMN_ID,
            mdDBhelper.COLUMN_PROFLIE_NAME,mdDBhelper.COLUMN_PROFLIE_HEGHT,mdDBhelper.COLUMN_PROFLIE_WEIGHT,
            mdDBhelper.COLUMN_PROFLIE_BLOOD_GROUP

    };

    public ProfileDataBase(DBhelper mdDBhelper, Context mContext) {

        this.mContext = mContext;

        mdDBhelper = new DBhelper(mContext);
        // open the database
        try {
            open();
        } catch (SQLException e) {
           // Log.e(TAG, "SQLException on openning database " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void open() throws SQLException{
        mSqLiteDatabase=mdDBhelper.getWritableDatabase();
    }

    public Profile creatNewProflie(String mName, String mHeigh, String mWeight, String mBlood) {
        ContentValues values = new ContentValues();
//        values.put(DBHelper.COLUMN_EMPLOYEE_NAME, name);
//        values.put(DBHelper.COLUMN_EMPLOYEE_ADDRESS, address);
//        values.put(DBHelper.COLUMN_EMPLOYEES_WEBSITE, website);
//        values.put(DBHelper.COLUMN_EMPLOYEES_PHONE_NUMBER, phoneNumber);
//        long insertId = mDatabase
//                .insert(DBHelper.TABLE_EMPLOYEES, null, values);
//        Cursor cursor = mDatabase.query(DBHelper.TABLE_EMPLOYEES, mAllColumns,
//                DBHelper.COLUMN_EMPLOYEE_ID + " = " + insertId, null, null,
//                null, null);
//        cursor.moveToFirst();
//        Employee newEmployee = cursorToEmployee(cursor);
//        cursor.close();
//        return newEmployee;

        values.put(mdDBhelper.COLUMN_PROFLIE_NAME,mName);
        values.put(mdDBhelper.COLUMN_PROFLIE_HEGHT,mHeigh);
        values.put(mdDBhelper.COLUMN_PROFLIE_WEIGHT,mWeight);
        values.put(mdDBhelper.COLUMN_PROFLIE_BLOOD_GROUP,mBlood);
        long insertId=mSqLiteDatabase.insert(mdDBhelper.TABLE_PROFILE,null,values);

        Cursor cursor=mSqLiteDatabase.query(mdDBhelper.TABLE_PROFILE,mAllColumns,mdDBhelper.COLUMN_ID+" = "+insertId,null,null,null,null);
        cursor.moveToFirst();
        Profile newProfile = cursorToProfile(cursor);
        cursor.close();
       return newProfile;


    }
    protected Profile cursorToProfile(Cursor cursor) {
        Profile profile = new Profile();
         profile.setId(cursor.getLong(0));
        profile.setmName(cursor.getString(1));
        profile.setmHeigh(cursor.getString(2));
        profile.setmWeight(cursor.getString(3));
        profile.setmBlood(cursor.getString(4));
        return profile;
    }
}
