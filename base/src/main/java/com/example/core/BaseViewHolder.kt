package com.example.core

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class BaseViewHolder(itemView: View) : ViewHolder(itemView) {

    @SuppressLint("UseSparseArrays")
    var viewHashMap = HashMap<Int, View>()

    @SuppressWarnings("unchecked")
    fun <T : View> getView(@IdRes id: Int): T {
        var view = viewHashMap[id]
        if (view == null) {
            view = itemView.findViewById(id)
            viewHashMap[id] = view
        }
        return view as T
    }

    fun setText(@IdRes id: Int, @Nullable text: String) {
        getView<TextView>(id).text = text
    }
}

