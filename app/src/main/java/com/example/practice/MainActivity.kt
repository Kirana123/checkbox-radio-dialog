package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val android: CheckBox = findViewById(R.id.checkBox1)
        val ios: CheckBox = findViewById(R.id.checkBox2)
        val web: CheckBox = findViewById(R.id.checkBox3)
        val button: Button = findViewById(R.id.button)
        val male: RadioButton = findViewById(R.id.male)
        val female: RadioButton = findViewById(R.id.female)

        button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            var courseAmount: Int = 0
            val result = StringBuilder()
            result.append("Selected Courses -")
            if (android.isChecked) {
                result.append("\nAndroid - Rs 100.")
                Log.d("Android", "Course has been selected")
                courseAmount += 100
            }
            if (ios.isChecked) {
                result.append("\nIOS - Rs 200.")
                Log.d("IOS", "Course has been selected")
                courseAmount += 200
            }
            if (web.isChecked) {
                result.append("\nWeb - Rs 150.")
                Log.d("Web", "Course has been selected")
                courseAmount += 150
            }
            builder.setTitle("Course Alert!")
            builder.setMessage(result.toString()  +"\nTotal course amount: Rs "+ courseAmount + ".")
            builder.setPositiveButton("Yes") { dialogInterface, which ->
                Toast.makeText(applicationContext, "Successfully purchased!", Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Cancel") { dialogInterface, which ->
                Toast.makeText(applicationContext, "You have cancelled the deal!", Toast.LENGTH_LONG).show()
            }
            builder.setNegativeButton("No") { dialogInterface, which ->
                Toast.makeText(applicationContext, "You have disagreed!", Toast.LENGTH_LONG).show()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
    }

    fun onRadioButtonClicked(view: View) {
        val settext: TextView = findViewById(R.id.setText)
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.male ->
                    if (checked) {
                        settext.setText("Male is selcted!")
                        Toast.makeText(applicationContext, "Male is selected", Toast.LENGTH_SHORT)
                            .show()
                    }
                R.id.female ->
                    if (checked) {
                        settext.setText("Female is selcted!")
                        Toast.makeText(applicationContext, "Female is selected", Toast.LENGTH_SHORT)
                            .show()
                    }
            }
        }

    }
}