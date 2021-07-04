package jp.techacademy.yoshiya.aisatsuapp

import android.app.TimePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button3.setOnClickListener(this)
    }


    override fun onClick(v: View) {
        when(v.id){
            R.id.button1 -> textView.text = editText.text.toString()
            R.id.button3 -> showTimePickerDialog()
        }
    }

    open fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
                if(hour>=2 && hour<10) {
                    Log.d("UI_PARTS", "おはよう")
                    textView.text = "おはよう".toString()
                }else if (hour>=10 && hour<18){
                    Log.d("UI_PARTS", "こんにちは")
                    textView.text = "こんにちは".toString()
                }else if (hour>=18 ||hour<2){
                    Log.d("UI_PARTS", "こんばんは")
                    textView.text = "こんばんは".toString()
                }

            },
            13, 0, true)
        timePickerDialog.show()
    }


}