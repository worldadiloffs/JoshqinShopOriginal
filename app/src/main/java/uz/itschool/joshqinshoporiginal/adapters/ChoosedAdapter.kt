package uz.itschool.joshqinshoporiginal.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import uz.itschool.joshqinshoporiginal.R
import uz.itschool.joshqinshoporiginal.model.Product
import uz.itschool.joshqinshoporiginal.networking.MySharedPreferences

class ChoosedAdapter(var onBuy: OnBuy, var context: Context, var onPressed: OnPressed) : RecyclerView.Adapter<ChoosedAdapter.MyViewHolder>(){
    val mySharedPreferences = MySharedPreferences.newInstance(context)
    var b = mySharedPreferences.getSelectedCarsList()
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var rasm = view.findViewById<ImageView>(R.id.choosed_image)
        var title = view.findViewById<TextView>(R.id.choosed_title)
        var reyting = view.findViewById<TextView>(R.id.choosed_rating)
        var buy = view.findViewById<ImageView>(R.id.buy_choosed)
        var korzina = view.findViewById<ImageView>(R.id.choosed_basket)
        var narx = view.findViewById<TextView>(R.id.choosed_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.choosed_product, parent, false))
    }

    override fun getItemCount(): Int {
        return b.size
    }


    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val a = b[position]
        holder.narx.text = "$ " + a.price.toString() + ".00"
        holder.title.text = a.title
        holder.reyting.text = a.rating.toString()
        holder.rasm.load(a.thumbnail)
        holder.korzina.setOnClickListener {
            Log.d("Wishlist", "onBindViewHolder: $b")
            b.remove(a)
            mySharedPreferences.setSelectedCarsList(b)
            notifyDataSetChanged()
        }
        holder.buy.setOnClickListener {
            onBuy.onBuy(a)
        }

        holder.itemView.setOnClickListener {
            onPressed.onPressed(a)
        }
    }

    interface OnBuy{
        fun onBuy(product: Product)
    }

    interface OnPressed{
        fun onPressed(product: Product)
    }
}