package ru.snowmaze.data.entity.lesson

import kotlinx.serialization.Serializable

@Serializable
class LessonEntity(val id: String, val name: String, val description: String, val teacher: String, val time: String, val duration: String)