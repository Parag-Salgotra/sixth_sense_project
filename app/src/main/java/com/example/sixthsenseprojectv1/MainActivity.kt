package com.example.sixthsenseprojectv1

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sixthsenseprojectv1.ui.theme.SixthSenseProjectV1Theme
import android.content.Intent

//Communication protocol imports
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbDeviceConnection
import android.hardware.usb.UsbManager
import android.os.Handler
import android.util.Log
import com.example.sixthsenseprojectv1.teams.Teammates
import com.example.sixthsenseprojectv1.uiHelpers.DialogAlert
import com.felhr.usbserial.UsbSerialDevice
import com.felhr.usbserial.UsbSerialInterface
import java.io.IOException
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalVariable().addSensorsToArray()

        val handler: Handler = Handler()
        val task: Runnable = object : Runnable {
            override fun run() {
                Teammates().generateTeamData(this@MainActivity)
                handler.postDelayed(this, 5000)
            }
        }
        task.run()
        /**for (i in 0..5){
        Teammates().generateTeamData(this@MainActivity)
        }*/

        setContent {
            SixthSenseProjectV1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navigate = Intent(this@MainActivity, HomeActivity::class.java)
                    startActivity(navigate)
                }
            }
        }
    }
}