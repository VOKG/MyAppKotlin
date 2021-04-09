package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout


class MainActivity : AppCompatActivity() {


    private lateinit var titleField: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        // titleField = findViewById(R.id.crime_title)// ее нету



    /*    val currentFragment = supportFragmentManager.findFragmentById(R.id.FirstFragment)
        if (currentFragment == null) {
            val fragment = FirstFragment()
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.FirstFragment,
                            fragment)
                    .commit()
        }
*/



        val editText = EditText(this)

        editText.addTextChangedListener(
                object : TextWatcher {
                    override fun onTextChanged(
                            s: CharSequence,
                            start: Int,
                            before: Int,
                            count: Int) {
                        Log.d("MyTag", "onTextChanged: $s")
                    }

                    override fun beforeTextChanged(
                            s: CharSequence,
                            start: Int,
                            count: Int,
                            after: Int) {
                        Log.d("MyTag", "beforeTextChanged: $s")
                    }

                    override fun afterTextChanged(
                            s: Editable
                    ) {
                        Log.d("MyTag", "afterTextChanged: $s")
                    }
                })

//В виде лямбда-выражения:
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            view -> Snackbar.make(
                view, "Replace with your own action",
                Snackbar.LENGTH_LONG).
        setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)

        }
    }


}

