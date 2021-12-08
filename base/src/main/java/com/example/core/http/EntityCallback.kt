package com.example.core.http

import androidx.annotation.NonNull
import java.lang.reflect.Type

interface EntityCallback<T> {

    fun onFailure(@NonNull message: String?)

    fun onSuccess(@NonNull entity: T)
}