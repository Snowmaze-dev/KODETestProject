package ru.snowmaze.domain

import java.util.*

class Lesson(val id: Int, val name: String, val time: Long = Date().time, val duration: Int = 1000*60*45)