package khalid.com.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import khalid.com.todoapp.database.TodoDatabase
import khalid.com.todoapp.database.TodoEntity
import kotlinx.android.synthetic.main.activity_add_todo.*

class AddTodoActivity : AppCompatActivity() {
    private  var mdatabase  : TodoDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)
        mdatabase = TodoDatabase.initializeDb(this)
        add_button.setOnClickListener {view ->
            val title  = title_text.text.toString()
            val content = content.text.toString()
            if (title.isEmpty() || content.isEmpty()){
                Snackbar.make(view, "This fields should't be empty", Snackbar.LENGTH_SHORT).show()
            }
            else{
                addTodo(title, content )
                Log.i("TAG", "TodoAdded")
            }

        }
    }
    private fun addTodo(title :String, content : String){
        mdatabase!!.getTodoDao().insertTodo(TodoEntity(title, content))
        startActivity(Intent(this@AddTodoActivity, MainActivity::class.java))
        finishAffinity()
    }
}
