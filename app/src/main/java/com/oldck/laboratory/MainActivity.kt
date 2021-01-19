package com.oldck.laboratory

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.oldck.laboratory.flutter.HiFlutterActivity
import com.oldck.laboratory.flutter.HiFlutterCacheManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        HiFlutterCacheManager.instance?.preLoad(this)
        val intent  = Intent(this, HiFlutterActivity::class.java)

        goto_flutter.setOnClickListener {
            intent.putExtra("moduleName", "nativeView")
            startActivity(intent)
        }

        goto_flutter2.setOnClickListener {
            intent.putExtra("moduleName", "recommend")
            startActivity(intent)
        }

        goto_flutter3.setOnClickListener {
            intent.putExtra("moduleName", "main")
            startActivity(intent)
        }
    }
}