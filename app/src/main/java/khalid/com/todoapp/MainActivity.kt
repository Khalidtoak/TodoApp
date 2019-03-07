package khalid.com.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var todos: MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize array list
        todos = ArrayList()
        //add stuffs to the list
        addToList()
        //Set the layout manager to the linear layou manager with a vertical orientation
        recycler_view.layoutManager = LinearLayoutManager(this@MainActivity
        , RecyclerView.VERTICAL, false)
        //text.text = "rfuvakfbluelnnfv/"
        //viemodel.setcsjbd = 20
        

        /*set the adapter to the todoAdapter class
        //set the adapter to the todoAdapter and make sure you pass
        // the recycler view click handler as a parameter.
        here you will specify what the click handler should be doing*/
        recycler_view.adapter = TodoAdapter(this@MainActivity, todos, object  : RecyclerViewClickHandler{
            override fun onViewClicked() {
                Log.i("Tag", "Got here")
                Toast.makeText(this@MainActivity, "This is clicked", Toast.LENGTH_LONG).show()
            }

        })
    }
    private fun addToList(){
        //Add items to the list
        todos.addAll(Arrays.asList(
            "Brush","Bathe",
            "Eat", "Sleep",
            "Drink beer", "Meet Bae",
            "Code", "Even More Code",
            "More and more code", "Go to the gym"
        , "Sleep again", "Eat again","End:",
            "Brush","Bathe",
            "Eat", "Sleep",
            "Drink beer", "Meet Bae",
            "Code", "Even More Code",
            "More and more code", "Go to the gym"
            , "Sleep again", "Eat again","End:",
            "Brush","Bathe",
            "Eat", "Sleep",
            "Drink beer", "Meet Bae",
            "Code", "Even More Code",
            "More and more code", "Go to the gym"
            , "Sleep again", "Eat again","End:",
            "Brush","Bathe",
            "Eat", "Sleep",
            "Drink beer", "Meet Bae",
            "Code", "Even More Code",
            "More and more code", "Go to the gym"
            , "Sleep again", "Eat again","End:"
        ))
    }

    override fun onStart() {
        super.onStart()

    }

}
