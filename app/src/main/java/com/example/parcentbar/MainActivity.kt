package com.example.parcentbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ll = findViewById<LinearLayout>(R.id.ll)
        val yy = findViewById<TextView>(R.id.yy)
        val nn = findViewById<TextView>(R.id.nn)
        val noc = findViewById<TextView>(R.id.non)
        val res = findViewById<TextView>(R.id.tvRes)
        val y = 339f;
        val n = 39f;
        val nc = 13f;
        val total = y + n + nc
        val yp = y / total * 100
        val np = n / total * 100
        val ncp = nc / total * 100

        yy.text = "${yp.toInt()}%"
        nn.text = "${np.toInt()}%"
        noc.text = "${ncp.toInt()}%"
        res.text="y:${yp.toInt()}%, n:${np.toInt()}%, nc:${ncp.toInt()}%"
        Timer("tmr", false).schedule(500) {
            this@MainActivity.runOnUiThread {
                val totalWidth = ll.measuredWidth
                yy.width = (y / total * totalWidth).toInt()
                nn.width = (n / total * totalWidth).toInt()
                noc.width = (nc / total * totalWidth).toInt()
                val h=60
                yy.height = h
                nn.height = h
                noc.height = h
            }
        }
    }


}