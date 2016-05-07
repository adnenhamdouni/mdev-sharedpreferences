package tn.itskills.android.sharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import tn.itskills.android.sharedpreferences.helper.MyPreferencesHelper;

public class MainActivity extends AppCompatActivity {


    private long mId;
    private String mName;
    private boolean mStatus;

    private MyPreferencesHelper mPreferencesHelper;

    private EditText mEtId, mEtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String readId = mEtId.getText().toString().trim();
                String readName = mEtName.getText().toString().trim();


                if (!readId.equals("") && !readId.equals("")){

                    mId = Integer.parseInt(readId);
                    mName = readName;

                    if (mStatus == true){
                        mStatus = false;
                    } else {
                        mStatus = true;
                    }

                    updateSharedPreferences(mId, mName, mStatus);
                    loadPreferences();
                } else {
                    Toast.makeText(MainActivity.this, "champs vide", Toast.LENGTH_LONG).show();
                }


            }
        });

        mEtId = (EditText) findViewById(R.id.editText_id);
        mEtName = (EditText) findViewById(R.id.editText_name);

        mPreferencesHelper = MyPreferencesHelper.getInstance(this);

        loadPreferences();
    }

    private void loadPreferences() {
        mId = mPreferencesHelper.getId();
        mName = mPreferencesHelper.getName();
        mStatus = mPreferencesHelper.getStatus();

        Toast.makeText(MainActivity.this, "id = "+mId+ " & name = "+mName+ " & status = "+mStatus, Toast.LENGTH_LONG).show();
    }

    private void updateSharedPreferences(long mId, String mName, boolean mStatus) {
        mPreferencesHelper.setId(mId);
        mPreferencesHelper.setName(mName);
        mPreferencesHelper.setStatus(mStatus);
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
