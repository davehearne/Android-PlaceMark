package ie.wit.placemark.main

import android.app.Application
import ie.wit.placemark.models.PlacemarkJSONStore
import ie.wit.placemark.models.PlacemarkStore
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class MainApp : Application(), AnkoLogger {

    lateinit var placemarks: PlacemarkStore

    override fun onCreate() {
        super.onCreate()
        placemarks = PlacemarkJSONStore(applicationContext)
        info("Start App From Here!")

//        placemarks.add(PlacemarkModel("One", "About one..."))
//        placemarks.add(PlacemarkModel("Two", "About two..."))
//        placemarks.add(PlacemarkModel("Three", "About three..."))
    }
}