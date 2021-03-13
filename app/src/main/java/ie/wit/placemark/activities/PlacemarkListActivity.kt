package ie.wit.placemark.activities

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ie.wit.placemark.R
import ie.wit.placemark.main.MainApp
import ie.wit.placemark.models.PlacemarkModel
import kotlinx.android.synthetic.main.activity_placemark_list.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivityForResult

class PlacemarkListActivity : AppCompatActivity(), PlacemarkListener {

    lateinit var app: MainApp

    override fun onPlacemarkClick(placemark: PlacemarkModel) {
        startActivityForResult(intentFor<PlacemarkActivity>().putExtra("placemark_edit", placemark), 0)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placemark_list)
        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = PlacemarkAdapter(app.placemarks.findAll(), this)

        //new_toolbar.title = title
//        setSupportActionBar(new_toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> startActivityForResult<PlacemarkActivity>(0)
        }
        return super.onOptionsItemSelected(item)
    }
}