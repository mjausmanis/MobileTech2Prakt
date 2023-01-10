package com.example.dialog

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToSecond = findViewById<Button>(R.id.buttonTo2nd)
        goToSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        val openDia = findViewById<Button>(R.id.openDialog)
        openDia.setOnClickListener {

            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("7. Group's Dialog")
            builder.setCancelable(false)

            val members = arrayOf(resources.getString(R.string.member1), resources.getString(R.string.member2), resources.getString(R.string.member3), resources.getString(R.string.member4))
            val checkedItems = booleanArrayOf(false, false, false, false)
            builder.setMultiChoiceItems(members, checkedItems) { dialog, which, isChecked ->

                checkedItems[which] = isChecked

                val currentItem = members[which]

                var checkText = when (isChecked) {
                    true -> "checked"
                    else -> "unchecked"
                }

                Toast.makeText(applicationContext, currentItem + " " + checkText, Toast.LENGTH_SHORT).show()
            }

            builder.setPositiveButton("OK", null )

            builder.setNeutralButton("Close") { dialog, which ->
                Toast.makeText(applicationContext, "You closed dialog", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }

            val dialog = builder.create()
            dialog.show()
            val positiveButton: Button = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            positiveButton.setOnClickListener {
                Toast.makeText(applicationContext, "You clicked OK", Toast.LENGTH_SHORT).show()
            }

        }

    }


}