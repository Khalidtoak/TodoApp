package khalid.com.todoapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
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
        GetTodosAsyncTask().execute()
        add_button.setOnClickListener {
            startAddTodoActivity()
        }
        //swipe to delete
        swipeToDelete()
    }

    private fun updateRecyclerView(todoEntities : List<TodoEntity>) {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = TodoAdapter(this@MainActivity, todoEntities, this@MainActivity)
        }
    }

    private fun startAddTodoActivity(){
        startActivity(Intent(this@MainActivity, AddTodoActivity::class.java))
    }
    private fun deleteTodo(todoEntity: TodoEntity){
        //initialize db and delete atodo
      TodoDatabase.initializeDb(this)!!.getTodoDao().deleteTodo(todoEntity)
    }
    private fun swipeToDelete(){
        //ItemTouchhelper for swipe to delete
        ItemTouchHelper(object :  ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT ) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder
            ): Boolean {
                //we are not doing anything in onMove
                return false
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                //Delete when swiped by excecuting the async task
                DeleteTodo().execute(todos[viewHolder.adapterPosition])
                //query list again to get updated list
                GetTodosAsyncTask().execute()

            }
        }).attachToRecyclerView(recycler_view)
    }
    //Async task to get a list of todos
    @SuppressLint("StaticFieldLeak")
    inner class GetTodosAsyncTask : AsyncTask<Unit, Unit, List<TodoEntity>>(){
        override fun doInBackground(vararg params: Unit?): List<TodoEntity> {
            //initialize the db and get  the list of todos, this is the background operation
            todos =  TodoDatabase.initializeDb(this@MainActivity)!!.getTodoDao().getAllTodos()
            //return the todos
            return todos
        }

        override fun onPostExecute(result: List<TodoEntity>?) {
            super.onPostExecute(result)
            //update the recycler view
            updateRecyclerView(result!!)
        }

    }
    @SuppressLint("StaticFieldLeak")
    inner class DeleteTodo : AsyncTask<TodoEntity, Unit, Unit>(){
        override fun doInBackground(vararg params: TodoEntity?) {
            //delete the atodo in the background
            deleteTodo(params[0]!!)
        }

    }

}
