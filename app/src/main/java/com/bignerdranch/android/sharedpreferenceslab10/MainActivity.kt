package com.bignerdranch.android.sharedpreferenceslab10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    private lateinit var setName: Button
    private lateinit var editName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setName = findViewById(R.id.setName)
        editName = findViewById(R.id.editName)


        val Names = getSharedPreferences("Names", MODE_PRIVATE)

        if(Names.contains("str")){
            val getNames = Intent(this, names_activity::class.java)
            getNames.putExtra("Names", Names.getString("str","why?").toString())
            startActivity(getNames)
        }

        setName.setOnClickListener{
            val edit = Names.edit()
            edit.putString("str",editName.text.toString())
            val getNames = Intent(this, names_activity::class.java)
            edit.apply()
            getNames.putExtra("Names", Names.getString("str","wgy?").toString())
            Log.d("Names","Имя записано ${Names.getString("str","why?")}" )
            startActivity(getNames)

        }
    }
}