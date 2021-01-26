package com.oldck.laboratory.flutter

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.oldck.laboratory.R
import kotlinx.android.synthetic.main.activity_flutter.*
import kotlinx.android.synthetic.main.fragment_flutter.*


class HiFlutterActivity : AppCompatActivity() {

    var moduleName: String? = ""
    var flutterFragment: MFlutterFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_flutter)

        val bundle = intent.extras
        if (bundle != null) {
            moduleName = bundle.getString("moduleName", "")
        }
        initFragment()
        send_flutter.setOnClickListener {
            HiFlutterBridge.instance!!.fire("onFun", mapOf(
                "boarding-pass" to "123凄凄切切群群群群群群群",
                "auth-token" to "456"
            ))
        }
    }

    private fun initFragment() {
        flutterFragment = MFlutterFragment(moduleName!!)
        supportFragmentManager.beginTransaction().add(R.id.root_view, flutterFragment!!)
            .commit()
    }

    class MFlutterFragment(private val moduleName: String) : HiFlutterFragment(moduleName) {
        override fun onDestroy() {
            super.onDestroy()
            //销毁Flutter引擎
            HiFlutterCacheManager.instance?.destroyCached(moduleName)
        }

        override fun getPageName(): String {
            return "MFlutterFragment"
        }
    }
}