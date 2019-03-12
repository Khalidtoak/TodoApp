package khalid.com.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import khalid.com.todoapp.database.TodoDatabase
import khalid.com.todoapp.database.TodoEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerViewClickHandler {
    private lateinit var todos : List<TodoEntity>
    override fun onViewClicked() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateRecyclerView()
        add_button.setOnClickListener {
            startAddTodoActivity()
        }
        swipeToDelete()
    }

    private fun updateRecyclerView() {
        todos = TodoDatabase.initializeDb(this)!!.getTodoDao().getAllTodos()
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = TodoAdapter(this@MainActivity, todos, this@MainActivity)
        }
    }

    private fun startAddTodoActivity(){
        startActivity(Intent(this@MainActivity, AddTodoActivity::class.java))
    }
    private fun deleteTodo(todoEntity: TodoEntity){
      TodoDatabase.initializeDb(this)!!.getTodoDao().deleteTodo(todoEntity)
    }
    private fun swipeToDelete(){
        ItemTouchHelper(object :  ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT ) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                deleteTodo(todos[viewHolder.adapterPosition])
                updateRecyclerView()

            }
        }).attachToRecyclerView(recycler_view)
    }

}
