package com.example.suryamodulepractise.Menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.suryamodulepractise.Menu.DataModels.MenuItem
import com.example.suryamodulepractise.R

class ExpandableAdapter(
    private var items: List<MenuItem>,
    private val clickListener: (MenuItem) -> Unit
) : RecyclerView.Adapter<ExpandableAdapter.ViewHolder>() {

    // Base ViewHolder type
    abstract class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: MenuItem)
    }

    // Parent ViewHolder
    inner class ParentViewHolder(itemView: View) : ViewHolder(itemView) {
        private val parentLayout: LinearLayout = itemView.findViewById(R.id.parent_item_layout)
        private val textView: TextView = itemView.findViewById(R.id.parent_text_view)
        private val expandCollapseIcon: ImageView = itemView.findViewById(R.id.expandCollapseIcon)
        private val childRecyclerView: RecyclerView = itemView.findViewById(R.id.child_recycler_view)

        override fun bind(item: MenuItem) {
            textView.text = item.menu.menuName

            // Toggle expand/collapse icon
            if (item.isExpanded) {
                expandCollapseIcon.setImageResource(R.drawable.icon_close)
                childRecyclerView.visibility = View.VISIBLE
                parentLayout.setBackgroundResource(R.drawable.menu_card_selected_backview)
                textView.setTextColor(itemView.context.resources.getColor(R.color.white))
                expandCollapseIcon.setColorFilter(itemView.context.resources.getColor(R.color.white))

            } else {
                expandCollapseIcon.setImageResource(R.drawable.icon_open)
                childRecyclerView.visibility = View.GONE
                parentLayout.setBackgroundResource(R.drawable.menu_card_backview)
                textView.setTextColor(itemView.context.resources.getColor(R.color.textcolor))
                expandCollapseIcon.setColorFilter(itemView.context.resources.getColor(R.color.textcolor))
            }

            // Click listener for expand/collapse functionality
            textView.setOnClickListener {
                item.isExpanded = !item.isExpanded
                notifyItemChanged(adapterPosition)
            }

            // Set up child RecyclerView if expanded
            if (item.isExpanded) {
                childRecyclerView.layoutManager = LinearLayoutManager(itemView.context)
                val childAdapter = ExpandableAdapter(item.children, clickListener)
                childRecyclerView.adapter = childAdapter
            }
        }
    }

    // Child ViewHolder
    inner class ChildViewHolder(itemView: View) : ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.child_text_view)
        private val grandChildRecyclerView: RecyclerView = itemView.findViewById(R.id.grandchild_recycler_view)

        override fun bind(item: MenuItem) {
            textView.text = item.menu.menuName

            // Click listener for expand/collapse functionality
            textView.setOnClickListener {
                item.isExpanded = !item.isExpanded
                notifyItemChanged(adapterPosition)
            }

            // Set up grandchild RecyclerView if expanded
            if (item.isExpanded) {
                grandChildRecyclerView.visibility = View.VISIBLE
                val grandChildAdapter = ExpandableAdapter(item.children, clickListener)
                grandChildRecyclerView.adapter = grandChildAdapter
                grandChildRecyclerView.layoutManager = LinearLayoutManager(itemView.context)
            } else {
                grandChildRecyclerView.visibility = View.GONE
            }
        }
    }

    // Grandchild ViewHolder
    inner class GrandChildViewHolder(itemView: View) : ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.grandchild_text_view)

        override fun bind(item: MenuItem) {
            textView.text = item.menu.menuName

            // Handle click event for grandchild
            textView.setOnClickListener {
                clickListener(item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            items[position].menu.parentId == "0" -> 0 // Parent
            items[position].children.isNotEmpty() -> 1 // Child
            else -> 2 // Grandchild
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_parent, parent, false)
                ParentViewHolder(view)
            }

            1 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_child, parent, false)
                ChildViewHolder(view)
            }

            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grandchild, parent, false)
                GrandChildViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position]) // Call bind method on the correct ViewHolder
    }

    override fun getItemCount() = items.size
}
