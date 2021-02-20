package ie.wit.placemark.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ie.wit.placemark.R
import ie.wit.placemark.main.MainApp
import ie.wit.placemark.models.PlacemarkModel
import kotlinx.android.synthetic.main.activity_placemark.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class PlacemarkActivity : AppCompatActivity(), AnkoLogger {

    var placemark = PlacemarkModel()
    lateinit var app : MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placemark)
        app = application as MainApp

        btnAdd.setOnClickListener() {
            placemark.title = placemarkTitle.text.toString()
            placemark.description = placemarkDescription.text.toString()
            //check if title is empty
            if (placemark.title.isNotEmpty() && placemark.description.isNotEmpty()) {
                app.placemarks.add(placemark.copy())
                app.placemarks.forEach { info("add Button Pressed: ${it.title}, ${it.description}")}
            }
            else {
                toast ("Please Enter content")
            }
        }
    }
}