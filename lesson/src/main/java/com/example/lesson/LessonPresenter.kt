package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient.get
import com.example.core.utils.toast
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.util.ArrayList

class LessonPresenter constructor(var activity: LessonActivity) {

    companion object {
        private const val LESSON_PATH = "lessons"
    }

    private var lessons: List<Lesson> = ArrayList()

    private val type = object : TypeToken<List<Lesson?>?>() {}.type

    fun fetchData() {
        get<List<Lesson>>(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {

            override fun onFailure(message: String?) {
                activity.runOnUiThread { toast(message!!) }
            }

            override fun onSuccess(entity: List<Lesson>) {
                lessons = entity
                activity.runOnUiThread { activity.showResult(lessons) }

            }
        })
    }

    fun showPlayback() {
        activity.showResult(lessons.filter { it.state === Lesson.State.PLAYBACK })
    }

}