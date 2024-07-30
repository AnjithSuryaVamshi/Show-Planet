package com.example.planetsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.example.showplanet.R
import java.util.zip.Inflater

class My_custom_adapter(val context: Context,val planets : List<Planet>): BaseAdapter(){
    override fun getCount(): Int {
        return planets.size
    }

    override fun getItem(p0: Int): Any {
        return planets[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = context.getSystemService(
            Context.LAYOUT_INFLATER_SERVICE
        ) as LayoutInflater
        val view : View
        if(p1==  null){
            view = inflater.inflate(
                R.layout.my_custom_layout,
                p2,
                false)
        }
        else{
            view = p1
        }
        val item = getItem(p0) as Planet
        val titlePlanet = view.findViewById<TextView>(R.id.planetName)
        val mooncounts = view.findViewById<TextView>(R.id.moonCount)
        val img = view.findViewById<ImageView>(R.id.planetImg)
        titlePlanet.text = item.planet
        mooncounts.text = item.moon
        img.setImageResource(item.img)
        return view
    }

}