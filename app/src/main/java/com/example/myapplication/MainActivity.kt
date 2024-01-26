package com.example.myapplication




import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    var peopleCount = 0
    lateinit var tekst: TextView
    lateinit var button: Button
    lateinit var resetButton: Button
    lateinit var layout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(16, 0, 16, 0)

        tekst = TextView(this)
        tekst.text = "Aantal personen: 0"
        tekst.textSize = 24F
        tekst.setPadding(0, 0, 0, 48)
        tekst.gravity = Gravity.CENTER
        layout.addView(tekst)

        button = createButton("Persoon Toevoegen", this::addPerson)
        button.setPadding(16, 0, 16, 0)
        layout.addView(button)

        resetButton = createButton("Reset", this::resetCounter)
        resetButton.isEnabled = false
        layout.addView(resetButton)

        setContentView(layout)
    }

    fun createButton(text: String, onClick: (View) -> Unit): Button {
        val button = Button(this)
        button.text = text
        button.height = 40
        button.setOnClickListener(onClick)
        return button
    }

    fun addPerson(view: View) {
        peopleCount++
        updateText()
        checkBackgroundColor()
        resetButton.isEnabled = true
    }

    fun resetCounter(view: View) {
        peopleCount = 0
        updateText()
        resetButton.isEnabled = false
        layout.setBackgroundColor(Color.WHITE)
    }

    fun updateText() {
        tekst.text = "People count : $peopleCount"
    }

    fun checkBackgroundColor() {
        if (peopleCount % 10 == 0) {
            val randomColor = Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
            layout.setBackgroundColor(randomColor)
        }
    }
}
