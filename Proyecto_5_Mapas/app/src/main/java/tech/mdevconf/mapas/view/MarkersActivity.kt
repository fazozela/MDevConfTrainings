package tech.mdevconf.mapas.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import tech.mdevconf.mapas.R

class MarkersActivity : AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_markers)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragMarkers) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        val coord = resources.getStringArray(R.array.coord_bol)
        val listaCoord = ArrayList<LatLng>()
        for(i in coord.indices) {
            val convertVect = coord[i].split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            listaCoord.add(LatLng(convertVect[0].toDouble(), convertVect[1].toDouble()))
        }

        for(i in listaCoord.indices) {
            val mark = MarkerOptions()
                .position(listaCoord[i])
                .title("Marcador en posición #${i+1}")
            googleMap?.addMarker(mark)
        }

        val markForeverAlone = MarkerOptions()
            .position(LatLng(-16.495665, -68.133504))
            .title("pero siempre")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
            .draggable(true)

        googleMap?.addMarker(markForeverAlone)

        val zoom = CameraUpdateFactory.zoomTo(5f)
        val centroMapa = CameraUpdateFactory.newLatLng(LatLng(-17.007528, -63.924866))

        googleMap?.moveCamera(centroMapa)
        googleMap?.animateCamera(zoom)
    }
}