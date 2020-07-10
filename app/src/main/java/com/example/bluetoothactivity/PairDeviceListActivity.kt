package com.example.bluetoothactivity

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.os.Build
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class PairDeviceListActivity : AppCompatActivity() {

    val list = ArrayList<Any>()

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pair_device_list)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        var bluetoothAdapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        var pairedDevices: Set<BluetoothDevice> = bluetoothAdapter.getBondedDevices()
         if(pairedDevices.size>0){
             for (device in pairedDevices) {
                 val devicename = device.name.toString()
                 //val macAddress = device.bondState
                 list.add("Pair Device: " + devicename)
             }

             val listView= findViewById<ListView>(R.id.device_id) as ListView
             var deviceAdapter= ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
             listView.setAdapter(deviceAdapter);
         }

    }
}