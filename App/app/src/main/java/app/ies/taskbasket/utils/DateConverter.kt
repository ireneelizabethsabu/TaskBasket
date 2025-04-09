package app.ies.taskbasket.utils

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

object DateConverter {
    fun millisToDate(millis: Long) : String{
        val simpleDateFormat= SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH)
        simpleDateFormat.timeZone = TimeZone.getTimeZone("UTC")
        return simpleDateFormat.format(millis)
    }

    fun convertDateToMillis(date: String) : Long {
        val simpleDateFormat= SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH)
        simpleDateFormat.timeZone = TimeZone.getTimeZone("UTC")
        return simpleDateFormat.parse(date)?.time ?: 0
    }
}