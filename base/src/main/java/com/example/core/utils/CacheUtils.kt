package com.example.core.utils

import android.annotation.SuppressLint
import android.content.Context
import com.example.core.BaseApplication
import java.util.*

@SuppressLint("StaticFieldLeak")
object CacheUtils {
    @SuppressLint("StaticFieldLeak")
    val context = BaseApplication.currentApplication()

    val SP = context.getSharedPreferences("Hencode", Context.MODE_PRIVATE)

    fun save(key: String, value: String) {
        SP.edit().putString(key, value).apply()
    }

    fun get(key: String): String? {
        return SP.getString(key, null)
    }
}