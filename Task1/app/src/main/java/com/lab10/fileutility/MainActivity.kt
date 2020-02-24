package com.lab10.fileutility

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        printAppsNumber()
    }

    private fun printAppsNumber(){
        val apps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
        val total = apps.size
        var user = 0
        for(app in apps){
           if (app.flags and ApplicationInfo.FLAG_SYSTEM == 0)
                user++
        }
        textView.append("Total apps number: $total\n" +
                "System apps number: ${total - user}\n" +
                "User apps number: $user")
    }
}
