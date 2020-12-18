package com.example.proyecto_41

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto_41.apapter.SpeakerAdapter
import com.example.proyecto_41.model.Speaker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SpeakerAdapter.OnSpeakerClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecycler()
    }

    private fun setupRecycler(){
        recyclerview.layoutManager = LinearLayoutManager(this)

        val speakers_list = listOf<Speaker>(
            Speaker("https://firebasestorage.googleapis.com/v0/b/mdevcamp-b122d.appspot.com/o/images%2Fpeople%2FIMG_20191219_121518%20-%20Miriam%20Rodriguez-min.jpg?alt=media&token=4b265a03-15e3-4540-a9ec-ff088049884b", "ALICIA TORRES", "Social Media"),
            Speaker("https://firebasestorage.googleapis.com/v0/b/mdevcamp-b122d.appspot.com/o/images%2Fpeople%2Fdescarga%20-%20Erwin%20M%C3%A9ndez-min.png?alt=media&token=a01061c5-c7b9-4778-8459-4330ef896242", "ERWIN MENDEZ", "Website"),
            Speaker("https://firebasestorage.googleapis.com/v0/b/mdevcamp-b122d.appspot.com/o/images%2Fpeople%2FGus%20-%20Gustavo%20Josu%C3%A9%20Liz%C3%A1rraga-min.jpg?alt=media&token=76ff669d-bf80-4969-b59c-9026079d51ef", "GUSTAVO LIZARRAGA", "Speakers & Sponsors"),
            Speaker("https://firebasestorage.googleapis.com/v0/b/mdevcamp-b122d.appspot.com/o/images%2Fpeople%2FIMG_20201114_003200%20-%20Wilma%20Limachi-min%20copia-min.jpg?alt=media&token=3aba0a44-9f65-4cbb-80e7-56f1097d64cf", "WILMA LIMACHI", "Social Media"),
            Speaker("https://firebasestorage.googleapis.com/v0/b/mdevcamp-b122d.appspot.com/o/images%2Fpeople%2Fphoto_2020-11-14_17-09-57%20-%20Felix%20Alejandro%20Zelaya%20Orellana-min.jpg?alt=media&token=388b7091-48cd-4b14-ace9-bedf9d3ac652", "FAZO", "Website - Design"),
            Speaker("https://firebasestorage.googleapis.com/v0/b/mdevcamp-b122d.appspot.com/o/images%2Fpeople%2FIMG_20200815_231120%20-%20Corali%20Diana%20Almanza%20Patzi-min.jpg?alt=media&token=c331ec1a-8e52-4469-9532-66d295ef84f4", "CORALI ALMANZA", "Merchandise"),
            Speaker("https://firebasestorage.googleapis.com/v0/b/mdevcamp-b122d.appspot.com/o/images%2Fpeople%2FIMG_20181019_123539%20-%20Limbert%20Leon-min.jpg?alt=media&token=4ca6f145-e4c0-41d3-a1fe-014d09873aef", "LIMBERT LEON", "Design"),
            Speaker("https://firebasestorage.googleapis.com/v0/b/mdevcamp-b122d.appspot.com/o/images%2Fpeople%2Fyo%20-%20Amancaya%20Iriarte%20Negron-min.jpg?alt=media&token=f7ca05d7-439c-4616-8534-bdd10323813e", "Amancaya Iriarte", "Sponsors, Speakers, Schedule"),
            Speaker("https://firebasestorage.googleapis.com/v0/b/mdevcamp-b122d.appspot.com/o/images%2Fpeople%2F86788689_3067676673277346_8325706421538652160_n%20-%20Reddy%20Abel%20Tintaya%20Conde-min.jpg?alt=media&token=90768c26-89d5-473c-96a9-71bcc024e3a7", "Reddy Tinataya", "Opening and Music"),
            Speaker("https://firebasestorage.googleapis.com/v0/b/mdevcamp-b122d.appspot.com/o/images%2Fpeople%2F20201107_123524%20-%20Laskar%20Israel%20Quisbert%20Torrez-min.jpg?alt=media&token=f8ddf139-0453-490c-bfd0-bd7e0408c946", "Laskar Torrez", "Social and Media")
        )

        recyclerview.adapter = SpeakerAdapter(this, speakers_list, this)
    }

    override fun onItemClick(item: Speaker) {
        val intent = Intent(this, SpeakerActivity::class.java)
        intent.putExtra("imgURL", item.img)
        startActivity(intent)
    }

}