package com.example.yoann.waterlife;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int  RUN_ACTIVITY = 12;
    public static final String RESULT_ACTIVITY = "ResultSetting";
    public static final String ADDRESS = "Address";
    private String address = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BluetoothAdapter myBluetooth = BluetoothAdapter.getDefaultAdapter();

        if(myBluetooth == null)
        {
            //Show a message. that the device has no bluetooth adapter
            Toast.makeText(getApplicationContext(), "Bluetooth Device Not Available", Toast.LENGTH_LONG).show();

            //finish apk
            finish();
        }
        else if(!myBluetooth.isEnabled())
        {
            //Ask to the user turn the bluetooth on
            Intent turnBTon = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnBTon,1);
        }


    }

    public void runScan(View view){
        if (address == null) {
            Toast.makeText(getApplicationContext(), "Please select a Bluetooth First", Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(MainActivity.this, LoadScreen.class);
            //Change the activity.
            //this will be received at ledControl (class) Activity
            i.putExtra(ADDRESS, address);
            startActivity(i);
        }
    }

    public void runSettings(View view) {
        Intent i = new Intent(this,SettingActivity.class);
        startActivityForResult(i, RUN_ACTIVITY);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (RUN_ACTIVITY) : {
                if (resultCode == Activity.RESULT_OK) {
                    address = data.getStringExtra(RESULT_ACTIVITY);
                    Toast.makeText(getApplicationContext(), address, Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }

}
