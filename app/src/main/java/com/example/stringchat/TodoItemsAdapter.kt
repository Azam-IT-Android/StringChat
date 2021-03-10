package com.example.stringchat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.android_version_item_layout.view.*
import kotlinx.android.synthetic.main.todo_item_layout.view.*

class TodoItemsAdapter(val todoItems: List<TodoItem>): RecyclerView.Adapter<TodoItemsAdapter.TodoItemsViewHolder>() {

    class TodoItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.todo_item_layout, parent, false)
        return TodoItemsViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoItemsViewHolder, position: Int) {
        val todoItem = todoItems[position]
        holder.itemView.todoItemTitle.text = todoItem.title
        holder.itemView.tickImage.isVisible = todoItem.completed
    }

    override fun getItemCount(): Int {
        return todoItems.size
    }
}