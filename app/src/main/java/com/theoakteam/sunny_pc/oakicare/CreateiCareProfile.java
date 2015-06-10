package com.theoakteam.sunny_pc.oakicare;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.theoakteam.sunny_pc.oakicare.Module.Profile;

/**
 * Created by Sunny_PC on 6/10/2015.
 */
public class CreateiCareProfile extends Activity {
    EditText getTxt_pName,getTxt_pHeight,getTxt_pweight,getTxt_pBloodGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createi_crea_profile_xml);
        intilizationOfViews();

    }

    private void intilizationOfViews() {
        getTxt_pName=(EditText)findViewById(R.id.et_p_name);
        getTxt_pHeight=(EditText)findViewById(R.id.et_p_height);
        getTxt_pweight=(EditText)findViewById(R.id.et_p_weight);
        getTxt_pBloodGroup=(EditText)findViewById(R.id.et_p_bloodgroup);
    }
    private void AddbtAction(View view){
        Editable prName=getTxt_pName.getText();
        Editable prHeight=getTxt_pHeight.getText();
        Editable prWeight=getTxt_pweight.getText();
        Editable prBloodgropup=getTxt_pBloodGroup.getText();
        if(!TextUtils.isEmpty(prName) && !TextUtils.isEmpty(prHeight) && !TextUtils.isEmpty(prWeight) &&
                !TextUtils.isEmpty(prBloodgropup) )
        {
            Profile creatNewProflie=mProfileData.creatNewProflie(prName);
        }
        else
        {
            Toast.makeText(this,"You Must Fill all Requirement  ", Toast.LENGTH_LONG).show();
        }
    }
}
