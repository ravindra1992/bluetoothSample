package com.example.bluetoothactivity

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btntOn: Button = findViewById(R.id.btntOn) as Button
        val btnOf: Button = findViewById(R.id.btnOf) as Button
        val btndis:Button =findViewById(R.id.btndis) as Button
        val btnpair:Button =findViewById(R.id.btnpair) as Button

        var adapter: BluetoothAdapter  = BluetoothAdapter.getDefaultAdapter()

        btntOn.setOnClickListener {
            if (adapter == null) {
              showToast(this, "Bluetooth Not Supported")
            }else{
                if(!adapter.isEnabled){
                    startActivityForResult(Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE),1)
                    showToast(this, "Bluetooth Turned On")
                }
            }


        }


        btnOf.setOnClickListener {
            adapter.disable()
            showToast(this, "Bluetooth Turned Off")

        }

        btndis.setOnClickListener {
            if(!adapter.isDiscovering){
                startActivityForResult(Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE),1)
                showToast(this, "Making Device Discoverable")

            }
        }

        btnpair.setOnClickListener {

             startActivity(Intent(this,PairDeviceListActivity::class.java))
        }
    }
}