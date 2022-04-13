package com.idn.alarmapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAlarmType()
        initTimeToday()
        initDateToday()
//        initRecyclerView()
    }

//    private fun initRecyclerView() {
//        alarmAdapter = AlarmAdapter()
//        rv_reminder_alarm.apply {
//            layoutManager = LinearLayoutManager(applicationContext)
//            adapter = alarmAdapter
//            swipeToDelete(this)
//        }
//    }
//
//    private fun swipeToDelete(recyclerView: RecyclerView) {
//        ItemTouchHelper(object :
//            ItemTouchHelper.SimpleCallback(
//                0,
//                ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
//            ) {
//            override fun onMove(
//                recyclerView: RecyclerView,
//                viewHolder: RecyclerView.ViewHolder,
//                target: RecyclerView.ViewHolder
//            ): Boolean {
//                return true
//            }
//
//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                // TODO Cancel alarm by type when item of RecyclerView onSwiped()
//                val typeOfAlarm = alarmAdapter.alarms[viewHolder.adapterPosition].type
//                alarmReceiver.cancelAlarm(this@MainActivity, typeOfAlarm)
//
//                val deletedItem = alarmAdapter.alarms[viewHolder.adapterPosition]
//                // delete item
//                CoroutineScope(Dispatchers.IO).launch {
//                    db.alarmDao().deleteAlarm(deletedItem)
//                }
//                alarmAdapter.notifyItemRemoved(viewHolder.adapterPosition)
//
//            }
//        }).attachToRecyclerView(recyclerView)
//    }

    private fun initAlarmType() {
        view_set_one_time_alarm.setOnClickListener {
            startActivity(Intent(this, OneTimeAlarmActivity::class.java))
        }

        view_set_repeating_alarm.setOnClickListener {
            startActivity(Intent(this, RepeatingAlarmActivity::class.java))
        }
    }

    private fun initDateToday() {
   // E = hari dd = tanggal MM = Bulan yyyy = Tahun
        val dateNow: Date = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("E, dd MMM yyyy", Locale.getDefault())
        val formattedDate: String = dateFormat.format(dateNow)
        tv_date_today.text = formattedDate
    }

    private fun initTimeToday() {
   // HH = hours mm = minute
        val timeNow = Calendar.getInstance()
        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val formattedTime = timeFormat.format(timeNow.time)
        tv_time_today.text = formattedTime
    }
}