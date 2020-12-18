package com.example.proyecto_41.apapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyecto_41.R
import com.example.proyecto_41.model.Speaker
import kotlinx.android.synthetic.main.item_speaker.view.*
import java.lang.IllegalArgumentException

class SpeakerAdapter(val context: Context, val speakers_list: List<Speaker>, val itemClickListener: OnSpeakerClickListener) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnSpeakerClickListener{
        fun onItemClick(item: Speaker)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return SpeakerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_speaker, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is SpeakerViewHolder -> holder.bind(speakers_list[position], position)
            else -> throw IllegalArgumentException("No se reconoce el holder")
        }
    }

    override fun getItemCount(): Int {
        return speakers_list.size
    }

    inner class SpeakerViewHolder(itemView: View) : BaseViewHolder<Speaker>(itemView){
        override fun bind(item: Speaker, position: Int) {

            itemView.setOnClickListener { itemClickListener.onItemClick(item) }

            Glide.with(context).load(item.img).into(itemView.imgItemSpeaker)
            itemView.txtSpeakerName.text = item.name
            itemView.txtSpeakerDescription.text = item.description
        }

    }

}