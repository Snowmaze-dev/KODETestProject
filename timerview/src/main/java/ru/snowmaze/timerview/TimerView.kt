package ru.snowmaze.timerview

import android.content.Context
import android.os.CountDownTimer
import android.os.Handler
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import java.util.concurrent.TimeUnit

class TimerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val views = mutableListOf<TextView>()
    private var mTimer = 0
    var timer: Int
        set(value) {
            mTimer = value
            updateTimer()
        }
        get() = mTimer
    private val pieces = arrayOf("0", "0", "0", "0", "0", "0")

    private fun updateTimer() {
        if(timer == 0) return
         object : CountDownTimer(timer*60L, 1000) {

             override fun onTick(millisUntilFinished: Long) {
                 var seconds = mTimer.toLong()
                 val days: Long = TimeUnit.SECONDS
                     .toDays(seconds)
                 seconds -= TimeUnit.DAYS.toSeconds(days)


                 val hours: Long = TimeUnit.SECONDS
                     .toHours(seconds)
                 seconds -= TimeUnit.HOURS.toSeconds(hours)

                 val minutes: Long = TimeUnit.SECONDS
                     .toMinutes(seconds)
                 val daysStr = dateToString(days)
                 val hoursStr = dateToString(hours)
                 val minutesStr = dateToString(minutes)
                 pieces[0] = daysStr[0].toString()
                 pieces[1] = daysStr[1].toString()
                 pieces[2] = hoursStr[0].toString()
                 pieces[3] = hoursStr[1].toString()
                 pieces[4] = minutesStr[0].toString()
                 pieces[5] = minutesStr[1].toString()
                 mTimer--
                 updateTimerViews()
             }

             override fun onFinish() {
             }
         }.start()
    }

    private fun dateToString(date: Long): String {
        val str = date.toString()
        return if (str.length == 1) "0$str"
        else str
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        updateTimer()
    }

    private fun updateTimerViews() {
        if (views.isEmpty()) {
            val layoutInflater = LayoutInflater.from(context)
            pieces.forEachIndexed { index, piece ->
                val textView = layoutInflater.inflate(R.layout.text_view, this, false) as TextView
                textView.text = piece
                views.add(textView)
                addView(textView)
                if (pieces.size - 1 == index) return
                val divider = layoutInflater.inflate(R.layout.divider, this, false) as TextView
                addView(divider)
            }
        } else {
            pieces.forEachIndexed { index, piece ->
                val view = views[index]
                if(view.text != piece) views[index].text = piece
            }
        }
    }



}