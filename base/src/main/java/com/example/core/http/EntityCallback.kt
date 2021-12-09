package com.example.core.http

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import java.lang.reflect.Type

interface EntityCallback<T> {

    fun onFailure(@Nullable message: String?)

    fun  onSuccess(@NonNull entity: T)
}