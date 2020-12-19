package tech.mdevconf.mapas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import tech.mdevconf.mapas.view.CustomMapActivity
import tech.mdevconf.mapas.view.MapaActivity
import tech.mdevconf.mapas.view.MarkersActivity
import tech.mdevconf.mapas.view.PolylinesActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMapa.setOnClickListener {
            startActivity(Intent(this, MapaActivity::class.java))
        }

        btnPolylines.setOnClickListener {
            startActivity(Intent(this, PolylinesActivity::class.java))
        }

        btnMarkers.setOnClickListener {
            startActivity(Intent(this, MarkersActivity::class.java))
        }

        btnCustom.setOnClickListener {
            startActivity(Intent(this, CustomMapActivity::class.java))
        }
    }
}