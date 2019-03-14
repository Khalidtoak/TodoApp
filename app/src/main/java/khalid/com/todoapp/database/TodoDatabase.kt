package khalid.com.todoapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by ${KhalidToak} on 3/8/2019.
 *todoDb is the class that extends room database and annotated with @Database
 * this class will be used to initialize the room database with a database name
 * Here you also specify the entities, database versions and an export schema
 */
const val DATABASE_NAME = "todo_db"
@Database(entities = [TodoEntity::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase(){
    //abstract function that returns  the todoDao
    abstract fun getTodoDao() : TodoDao

//inside this companion object , we initialize the database
    companion object {
        private var databaseInstance : TodoDatabase? = null
        fun initializeDb(context: Context) : TodoDatabase? {
            if (databaseInstance == null) {
                databaseInstance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java, DATABASE_NAME
                ).build()
            }
            return databaseInstance
        }
    }
    }