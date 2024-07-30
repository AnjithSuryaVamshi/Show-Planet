package com.example.planetsapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import com.example.showplanet.R
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private var imageUri: Uri? = null
    val planetTxt : EditText = findViewById(R.id.planetTxt)
    val moonTxt :  EditText = findViewById(R.id.editText)
    val imgBtn : Button = findViewById(R.id.button)
    val addBtn : Button = findViewById(R.id.button2)
    val newPlanet = Planet("","",R.drawable.ic_launcher_background)
    val newp = planetTxt.text.toString()
    val newM = moonTxt.text.toString()
    val listOfPlanets = mutableListOf<Planet>()
    var myAdapter = My_custom_adapter(this,listOfPlanets)
    override fun onCreate(savedInstanceState: Bundle?)

    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listView : ListView= findViewById(R.id.ListView)
        val planet1 = Planet("mercury","0 Moons", R.drawable.mercury)
        val planet2 = Planet("venus","0 Moons",R.drawable.venus)
        val planet3 = Planet("Earth","1 Moon",R.drawable.earth)
        val planet4 = Planet("mars","3 Moons",R.drawable.mars)
        val p5 = Planet("Jupiter","76 Moons",R.drawable.jupiter)
        val p6 = Planet("Saturn","83 Moons",R.drawable.saturn)
        val p7 = Planet("Uranus","27 Moons",R.drawable.uranus)
        val p8 = Planet("Nepturn","14 Moons",R.drawable.neptune)




        imgBtn.setOnClickListener {
            val imgIntent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(imgIntent,101)
        }
        listOfPlanets.add(planet1)
        listOfPlanets.add(planet2)
        listOfPlanets.add(planet3)
        listOfPlanets.add(planet4)
        listOfPlanets.add(p5)
        listOfPlanets.add(p6)
        listOfPlanets.add(p7)
        listOfPlanets.add(p8)



        listView.adapter = myAdapter
        listView.setOnItemClickListener(object : OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                listOfPlanets.removeAt(position)
                myAdapter.notifyDataSetChanged()
            }
        })



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==101 && resultCode == RESULT_OK){
            imageUri = data?.data
            val NewPlanet = PlanetUriClass("$newp","$newM",imageUri!!)
            listOfPlanets.add(newPlanet)
            myAdapter.notifyDataSetChanged()





        }
    }
}