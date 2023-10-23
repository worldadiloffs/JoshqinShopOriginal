package uz.itschool.joshqinshoporiginal.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import uz.itschool.joshqinshoporiginal.R
import uz.itschool.joshqinshoporiginal.model.Comment

class CommentAdapter(var commentList: MutableList<Comment>) :
    RecyclerView.Adapter<CommentAdapter.CustomAdapter>() {

    class CustomAdapter(item: View) : RecyclerView.ViewHolder(item) {
        val userName: TextView = itemView.findViewById(R.id.username)
        val text: TextView = itemView.findViewById(R.id.text)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_commment, parent, false)

        return CustomAdapter(view)
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    override fun onBindViewHolder(holder: CustomAdapter, position: Int) {
        val itemsViewModel = commentList[position]
        if (position % 2 == 0) {
            holder.userName.text = itemsViewModel.user.username
            holder.text.text = itemsViewModel.body
            holder.cardView.setCardBackgroundColor(Color.parseColor("#CCCCCC"))
        }
        else{
            holder.userName.text = itemsViewModel.user.username
            holder.text.text = itemsViewModel.body
            holder.cardView.setCardBackgroundColor(Color.parseColor("#00BCD4"))
        }

    }
}