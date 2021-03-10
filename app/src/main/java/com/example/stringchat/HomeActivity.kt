package com.example.stringchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_home.*
import java.nio.charset.StandardCharsets

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        "https://jsonplaceholder.typicode.com/todos/".httpGet().response {
            request, response, result ->
            val type = object: TypeToken<List<TodoItem>>(){}.type
            val todoItems:List<TodoItem> = Gson().fromJson(result.get().toString(StandardCharsets.UTF_8), type)

            versionsRecyclerView.adapter = TodoItemsAdapter(todoItems)
            versionsRecyclerView.layoutManager = LinearLayoutManager(this)
        }


    }
}