package dev.alexmorgan.unbearable2.main_activity

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.alexmorgan.unbearable2.R
import kotlinx.android.synthetic.main.bear_list_item.view.*
import javax.inject.Inject

class BearAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var bears: List<Bear> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BearViewHolder(parent.context)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val bear = bears[position]
        holder.itemView.bear_list_item_name.text = bear.name
        Glide.with(holder.itemView).load(bear.imageUrl).into(holder.itemView.bear_list_item_pic)
    }

    override fun getItemCount() = bears.size

    class BearViewHolder(context: Context) : RecyclerView.ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.bear_list_item, null, false)
    ) {}
}
