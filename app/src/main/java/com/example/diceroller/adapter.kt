package com.example.diceroller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.diceroller.data.Superhero
import com.squareup.picasso.Picasso

class adapter : RecyclerView.Adapter<adapter.ViewHolder>(){
    var superheros: MutableList<Superhero> = ArrayList()
    lateinit var context:Context

    fun adapter(superheros: MutableList<Superhero>,context: Context){
        this.superheros = superheros
        this.context    = context
    }

    override fun onBindViewHolder(holder: adapter.ViewHolder, position: Int) {
        val item = superheros.get(position)
        holder.bind(item,context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_superhero_list,parent,false))
    }

    override fun getItemCount(): Int {
        return superheros.size
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val superHeroName = view.findViewById(R.id.tvSuperhero) as TextView
        val realName = view.findViewById(R.id.tvRealName) as TextView
        val publisher = view.findViewById(R.id.tvPublisher) as TextView
        val avatar = view.findViewById(R.id.ivAvatar) as ImageView

        fun bind(superhero: Superhero, context: Context) {
            superHeroName.text = superhero.superhero
            realName.text = superhero.realName
            publisher.text = superhero.publisher
            avatar.loadUrl(superhero.photo)
        }
        fun ImageView.loadUrl(url: String){
            Picasso.with(context).load(url).into(this)
        }
    }
}