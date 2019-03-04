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
        todos = ArrayList()
        addToList()
        recycler_view.layoutManager = LinearLayoutManager(this@MainActivity
        , RecyclerView.VERTICAL, false)
        recycler_view.adapter = TodoAdapter(this@MainActivity, todos)
    }
    private fun addToList(){
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
