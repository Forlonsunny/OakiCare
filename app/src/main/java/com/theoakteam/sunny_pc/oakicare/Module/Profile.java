package com.theoakteam.sunny_pc.oakicare.Module;

import java.io.Serializable;

/**
 * Created by Sunny_PC on 6/10/2015.
 */
public class Profile implements Serializable {
    private static final long serialVersionUID = -7406082437623008161L;
   private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String mName;
    private String mHeigh;
    private String mWeight;
    private String mBlood;

    public Profile() {

    }

    public Profile(String mName, String mHeigh, String mWeight, String mBlood) {
        this.mName = mName;
        this.mHeigh = mHeigh;
        this.mWeight = mWeight;
        this.mBlood = mBlood;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmHeigh() {
        return mHeigh;
    }

    public void setmHeigh(String mHeigh) {
        this.mHeigh = mHeigh;
    }

    public String getmWeight() {
        return mWeight;
    }

    public void setmWeight(String mWeight) {
        this.mWeight = mWeight;
    }

    public String getmBlood() {
        return mBlood;
    }

    public void setmBlood(String mBlood) {
        this.mBlood = mBlood;
    }



}
