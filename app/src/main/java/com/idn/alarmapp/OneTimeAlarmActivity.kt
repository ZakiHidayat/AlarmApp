package com.idn.alarmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.idn.alarmapp.databinding.ActivityMainBinding
import com.idn.alarmapp.fragment.DatePickerFragment
import com.idn.alarmapp.fragment.TimePickerFragment
import kotlinx.android.synthetic.main.activity_one_time_alarm.*

class OneTimeAlarmActivity : AppCompatActivity() , View.OnClickListener, DatePickerFragment.DialogDateListener, TimePickerFragment.DialogTimeListener{

//    private var binding: ActivityMainBinding? = null
//    private lateinit var alarmReceiver: AlarmReceiver
//    private val db by lazy {AlarmDB (this)}

    companion object {
        private const val DATE_PICKER_TAG = "DatePicker"
        private const val TIME_PICKER_ONCE_TAG = "TimePickerOnce"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_time_alarm)

        btn_set_date_one_time.setOnClickListener(this)
        btn_set_time_one_time.setOnClickListener(this)
//        btn_add_set_one_time_alarm.setOnClickListener(this)
//        btn_cancel_set_one_time_alarm.setOnClickListener(this)
//
//        alarmReceiver = AlarmReceiver()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_set_date_one_time -> {
                val datePickerFragment = DatePickerFragment()
                datePickerFragment.show(supportFragmentManager, DATE_PICKER_TAG)
            }
            R.id.btn_set_time_one_time -> {
                val timePickerFragmentOneTime = TimePickerFragment()
                timePickerFragmentOneTime.show(supportFragmentManager, TIME_PICKER_ONCE_TAG)
            }
    }
   }

    override fun onDialogDateSet(tag: String?, year: Int, month: Int, dayOfMonth: Int) {
        TODO("Not yet implemented")
    }

    override fun onDialogTimeSet(tag: String?, hourOfDay: Int, minute: Int) {
        TODO("Not yet implemented")
    }
}