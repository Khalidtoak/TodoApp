package khalid.com.todoapp

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_item.view.*

/**
 * Created by ${KhalidToak} on 3/4/2019.
 * TodoAdapter class connects the view holder to the exact layout that it will be using
 * for each item in the recycler view. We pass in the
 * context and the list of strings we want to display which will later be defined in the activity
 * make sure your TodoAdapter accepts recyclerview click handler as a parameter
 */
class TodoAdapter(val context: Context, val todos : MutableList<String>,
                 val recyclerViewClickHandler: RecyclerViewClickHandler
)
    : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    /**
     * The onCreate view holder is a method that creates new view holders when there are no existing view holders
     * to recycle. So for instance iif you recycler view can display 9 items at a time,
     * your view holder will create 9 - 10 viewHolders which will then be reused in the onBindViewHolder
     * **/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        //The attach to root parameter is set to false here will explain the meaning in class:)
        val view =  TodoViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_item,
            parent, false))
        return view
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
   inner class TodoViewHolder(private val view : View) : RecyclerView.ViewHolder(view)
    , View.OnClickListener{

        //get the text from the recycler view item layout
        val textView = view.text!!
        init {
            //inside the init block, set the click listener of the inflated layout to this
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            //call the onView clicked method in the onClick
            recyclerViewClickHandler.onViewClicked()

        }


    }
}