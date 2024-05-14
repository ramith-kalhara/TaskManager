package com.example.taskmanager


import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.databinding.ActivityViewBinding

class Adapter(private var data:List<CardInfo>) : RecyclerView.Adapter<Adapter.viewHolder>() {
    class viewHolder(val binding: ActivityViewBinding): RecyclerView.ViewHolder(binding.root){
        val title=binding.title
        val priority=binding.priority
        val layout=binding.mylayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var binding = ActivityViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val currentItem = data[position]

        when (currentItem.priority.toLowerCase()) {
            "1" -> holder.layout.setBackgroundColor(Color.parseColor("#EA526F"))
            "2" -> holder.layout.setBackgroundColor(Color.parseColor("#FCD581"))
            else -> holder.layout.setBackgroundColor(Color.parseColor("#f9b2b3"))
        }

        holder.title.text=currentItem.title
        holder.priority.text=currentItem.priority

        holder.itemView.setOnClickListener{
            val intent=Intent(holder.itemView.context, Update::class.java)
            intent.putExtra("id", position)
            holder.itemView.context.startActivity(intent)
        }

    }
}