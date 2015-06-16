package com.theoakteam.sunny_pc.oakicare;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.theoakteam.sunny_pc.oakicare.Module.Profile;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
   public static final int REQUEST_CODE_ADD_PROFILE=40;
    public static final String EXTRA_ADDED_PROFILE = "extra_key_added_profile";
    private ListView mListView;
    private List<Profile>mProfileList;
    private ListProfileAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView=(ListView)findViewById(R.id.list_item_forProfile);
    }
    void CreaNewProfile(View view){
        Intent newIntent=new Intent(MainActivity.this,CreateiCareProfile.class);
        startActivityForResult(newIntent,REQUEST_CODE_ADD_PROFILE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE_ADD_PROFILE){
            Profile createdProfile=(Profile) data.getSerializableExtra(EXTRA_ADDED_PROFILE);
            mProfileList=new ArrayList<Profile>();
            mProfileList.add(createdProfile);

            if (mListView.getVisibility() != View.VISIBLE) {
                mListView.setVisibility(View.VISIBLE);

            }

            if (mAdapter == null) {
                mAdapter = new ListProfileAdapter(this, mProfileList);
                mListView.setAdapter(mAdapter);
            } else {
               // mAdapter.setItems(mListEmployess);
                //mAdapter.notifyDataSetChanged();
            }
        }
        else {

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
