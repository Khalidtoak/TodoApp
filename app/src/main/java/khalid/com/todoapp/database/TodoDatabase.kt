package khalid.com.todoapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by ${KhalidToak} on 3/8/2019.
 */
const val DATABASE_NAME = "todo_db"
@Database(entities = [TodoEntity::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase(){
    abstract fun getTodoDao() : TodoDao


    companion object {
        private var databaseInstance : TodoDatabase? = null
        fun initializeDb(context: Context) : TodoDatabase? {
            if (databaseInstance == null) {
                databaseInstance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java, DATABASE_NAME
                ).allowMainThreadQueries().build()
            }
            return databaseInstance
        }
    }
    }