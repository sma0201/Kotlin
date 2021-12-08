package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient.get
import com.example.core.utils.toast
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.util.ArrayList

class LessonPresenter {

    companion object {
        private const val LESSON_PATH = "lessons"
    }

    private var activity: LessonActivity

    constructor(activity: LessonActivity) {
        this.activity = activity
    }

    private var lessons: List<Lesson> = ArrayList()

    private val type = object : TypeToken<List<Lesson?>?>() {}.type

    fun fetchData() {
        get<List<Lesson>>(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {


            override fun onFailure(message: String?) {
                activity.runOnUiThread(Runnable { toast(message!!) })
            }

            override fun onSuccess(entity: List<Lesson>) {
                lessons = lessons
                activity.runOnUiThread(Runnable { activity.showResult(lessons) })

            }
        })
    }

    fun showPlayback() {
        val playbackLessons: MutableList<Lesson> = ArrayList()
        for (lesson in lessons) {
            if (lesson.state === Lesson.State.PLAYBACK) {
                playbackLessons.add(lesson)
            }
        }
        activity.showResult(playbackLessons)
    }

}