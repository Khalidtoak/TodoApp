package khalid.com.todoapp.database
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by ${KhalidToak} on 3/8/2019.
 * TodoEntity defines how our table will look like
 */
@Entity(tableName = "todo")
data class TodoEntity(
    val title:String?,
    val content : String?,
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0
)