package khalid.com.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        //set the adapter to the todoAdapter class
        recycler_view.adapter = TodoAdapter(this@MainActivity, todos)
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
}
