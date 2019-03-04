package khalid.com.todoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_item.view.*

/**
 * Created by ${KhalidToak} on 3/4/2019.
 * TodoAdapter class connects the view holder to the exact layout that it will be using
 * for each item in the recycler view. We pass in the
 * context and the list of strings we want to display which will later be defined in the activity
 */
class TodoAdapter(private val context: Context, private val todos : MutableList<String>)
    : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    /**
     * The onCreate view holder is a method that creates new view holders when there are no existing view holders
     * to recycle. So for instance iif you recycler view can display 9 items at a time,
     * your view holder will create 9 - 10 viewHolders which will then be reused in the onBindViewHolder
     * **/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        //The attach to root parameter is set to false here will explain the meaning in class:)
        return TodoViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_item,
            parent, false))
    }
/**
 * returns the number of items in the list being displayed**/
    override fun getItemCount(): Int {
       return todos.size
    }
/**
 * Here we specify what we want to do with the vies in our viewHolder. The onBindView holder is the
 * one also responsible for recycling the viewHolder*/
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.textView.text = todos[position]
    }

    //The view holder is the class that holds the text view in the recycler view item list,
    // This class extends the viewholder class
    class TodoViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        //get the text from the recycler view item layout
        val textView = view.text!!
    }
}