package ru.snowmaze.data.entity.homework

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class HomeworkEntity(val id: String, @SerialName("lesson_id") val lessonId: String, @SerialName("expire_time") val expireTime: String, val task: String)