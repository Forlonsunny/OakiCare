package com.theoakteam.sunny_pc.oakicare.ProfileDabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.theoakteam.sunny_pc.oakicare.CreateiCareProfile;
import com.theoakteam.sunny_pc.oakicare.Module.Profile;

import java.util.ArrayList;
import java.util.List;

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

    public ProfileDataBase(CreateiCareProfile createiCareProfile) {


    }


    private void open() throws SQLException{
        mSqLiteDatabase=mdDBhelper.getWritableDatabase();
    }

    public Profile creatNewProflie(String mName, String mHeigh, String mWeight, String mBlood) {
        ContentValues values = new ContentValues();


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





    public List<Profile>getAllProfiles(){
        List<Profile>listProfiles=new ArrayList<Profile>();
        Cursor cursor=mSqLiteDatabase.query(mdDBhelper.TABLE_PROFILE,mAllColumns,null,null,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                Profile profile=cursorToProfile(cursor);
                listProfiles.add(profile);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return listProfiles;


    }

//    public Employee getEmployeeById(long id) {
//        Cursor cursor = mDatabase.query(DBHelper.TABLE_EMPLOYEES, mAllColumns,
//                DBHelper.COLUMN_EMPLOYEE_ID + " = ?",
//                new String[]{String.valueOf(id)}, null, null, null);
//        if (cursor != null) {
//            cursor.moveToFirst();
//        }
//
//        Employee employee = cursorToEmployee(cursor);
//        return employee;
//    }



    
}
