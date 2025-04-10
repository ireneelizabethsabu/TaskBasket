package app.ies.taskbasket.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
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

    fun convertDateToIsoString(date: String) : String{
        val fullDateTimeString = "$date 23:59:00"
        val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss")

        val localDateTime = LocalDateTime.parse(fullDateTimeString, formatter)
        val zonedDateTime = localDateTime.atZone(ZoneId.systemDefault())
        val isoString = zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ"))

        println(isoString)
        return isoString
    }
}