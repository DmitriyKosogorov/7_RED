package com.example.a7red_0_0

import android.content.res.Resources
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout = findViewById<ConstraintLayout>(R.id.root)
        val r: Resources = resources

        val handsize = 7

        val screenwidth = Resources.getSystem().getDisplayMetrics().widthPixels
        var screenpart = screenwidth / handsize

        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
        val colors = listOf(
            "Red",
            "Orange",
            "Yellow",
            "Green",
            "LBlue",
            "DBlue",
            "Purple",
            "Black",
            "Brown",
            "Turquoise",
            "Pink",
            "White"
        )
        //val ru_colors=mapOf("Red" to "Красный", "Orange" to "Оранжевый", "Yellow" to "Жёлтый", "Green" to "Зелёный", "LBlue" to "Голубой", "DBlue" to "Синий", "Purple" to "Фиолетовый", "Black" to "Чёрный", "Brown" to "Коричневый","Turquoise" to "Бирюзовый", "Pink" to "Розовый", "White" to "Белый")

        //creating deck
        val deck = mutableListOf<Card_Class>()

        for (i in 0..6) {
            for (j in 1..7)
                deck.add(Card_Class(colors[i], j, "AAAAAA"))
        }
        var Shuffled_Deck = deck.shuffled()

        //creating first player's hand
        val hand_0 = mutableListOf<TextView>()
        for (i in 0..(handsize - 1)) {

            var card = Shuffled_Deck[i]

            hand_0.add(TextView(this))


            val width_px =
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, card.width, r.displayMetrics)
            val height_px = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                card.height,
                r.displayMetrics
            )
            Log.d("size", screenpart.toString())
            Log.d("size", width_px.toString())
            val params = ConstraintLayout.LayoutParams(
                //ViewGroup.LayoutParams.WRAP_CONTENT,
                //ViewGroup.LayoutParams.WRAP_CONTENT
                width_px.toInt(), height_px.toInt()
            )

            params.bottomToBottom = R.id.your_hand
            hand_0[i].setId(i)

            if (i > 0) {
                params.leftToRight = i - 1
                //if (screenpart < width_px)
                params.setMargins((screenpart - width_px).toInt(), 0, 0, 0)
            } else {
                params.leftToRight = R.id.your_hand
            }

            hand_0[i].layoutParams = params
            hand_0[i].setText(card.number.toString())
            hand_0[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 40f)
            hand_0[i].setBackgroundResource(card.backgrounder)
            hand_0[i].setTextColor(Color.WHITE)
            hand_0[i].setGravity(Gravity.CENTER)

            hand_0[i].setOnClickListener {
                val mBuilder = AlertDialog.Builder(this)
                val mLayout = LinearLayout(this)

                val card_image = TextView(this)

                val Color_txt = TextView(this)
                val Number_txt = TextView(this)
                val Rule_txt = TextView(this)

                card_image.setBackgroundResource(card.backgrounder)
                card_image.setGravity(Gravity.CENTER)
                card_image.setTextColor(Color.WHITE)
                card_image.setText(card.number.toString())
                card_image.setTextSize(TypedValue.COMPLEX_UNIT_SP, 80f)

                Color_txt.text = ("Цвет: " + card.ru_color)
                Number_txt.text = ("Число: " + card.number)
                Rule_txt.text = ("Правило: " + card.rule)
                mLayout.orientation = LinearLayout.VERTICAL
                mLayout.addView(card_image)
                mLayout.addView(Color_txt)
                mLayout.addView(Number_txt)
                mLayout.addView(Rule_txt)
                mLayout.setPadding(50, 40, 50, 10)

                mBuilder.setView(mLayout)

                mBuilder.setNeutralButton("Закрыть") { dialogInterface, i ->
                    dialogInterface.dismiss()
                }
                //show dialog
                mBuilder.create().show()
                //return@setOnLongClickListener true

            }

            layout?.addView(hand_0[i])

        }

        //Creating first player's palette
        val palette_0 = mutableListOf<TextView>()
        screenpart = screenwidth / 2
        var top_deck_index = 7
        for (i in 0..0) {

            var card = Shuffled_Deck[top_deck_index + i]

            palette_0.add(TextView(this))


            val width_px =
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, card.width, r.displayMetrics)
            val height_px = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                card.height,
                r.displayMetrics
            )
            val params = ConstraintLayout.LayoutParams(width_px.toInt(), height_px.toInt())

            palette_0[i].setId(top_deck_index + i)

            params.bottomToBottom = R.id.your_palette

            if (i > 0) {
                params.leftToRight = i - 1
                //if (screenpart < width_px)

            } else {
                params.leftToRight = R.id.your_palette
            }
            params.setMargins((screenpart - width_px).toInt(), 0, 0, 0)
            palette_0[i].layoutParams = params
            palette_0[i].setText(card.number.toString())
            palette_0[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 40f)
            palette_0[i].setBackgroundResource(card.backgrounder)
            palette_0[i].setTextColor(Color.WHITE)
            palette_0[i].setGravity(Gravity.CENTER)

            palette_0[i].setOnClickListener {
                val mBuilder = AlertDialog.Builder(this)
                val mLayout = LinearLayout(this)

                val card_image = TextView(this)

                val Color_txt = TextView(this)
                val Number_txt = TextView(this)
                val Rule_txt = TextView(this)

                card_image.setBackgroundResource(card.backgrounder)
                card_image.setGravity(Gravity.CENTER)
                card_image.setTextColor(Color.WHITE)
                card_image.setText(card.number.toString())
                card_image.setTextSize(TypedValue.COMPLEX_UNIT_SP, 80f)

                Color_txt.text = ("Цвет: " + card.ru_color)
                Number_txt.text = ("Число: " + card.number)
                Rule_txt.text = ("Правило: " + card.rule)
                mLayout.orientation = LinearLayout.VERTICAL
                mLayout.addView(card_image)
                mLayout.addView(Color_txt)
                mLayout.addView(Number_txt)
                mLayout.addView(Rule_txt)
                mLayout.setPadding(50, 40, 50, 10)

                mBuilder.setView(mLayout)

                mBuilder.setNeutralButton("Закрыть") { dialogInterface, i ->
                    dialogInterface.dismiss()
                }
                //show dialog
                mBuilder.create().show()
                //return@setOnLongClickListener true

            }

            layout?.addView(palette_0[i])

        }

        //creating opponent's palette
        val palette_1 = mutableListOf<TextView>()
        screenpart = screenwidth / 2
        top_deck_index = 8
        for (i in 0..0) {

            var card = Shuffled_Deck[top_deck_index + i]

            palette_1.add(TextView(this))


            val width_px =
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, card.width, r.displayMetrics)
            val height_px = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                card.height,
                r.displayMetrics
            )
            val params = ConstraintLayout.LayoutParams(width_px.toInt(), height_px.toInt())

            palette_1[i].setId(top_deck_index + i)

            params.bottomToBottom = R.id.opps_palette

            if (i > 0) {
                params.leftToRight = i - 1
                //if (screenpart < width_px)

            } else {
                params.leftToRight = R.id.opps_palette
            }
            params.setMargins((screenpart - width_px).toInt(), 0, 0, 0)
            palette_1[i].layoutParams = params
            palette_1[i].setText(card.number.toString())
            palette_1[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 40f)
            palette_1[i].setBackgroundResource(card.backgrounder)
            palette_1[i].setTextColor(Color.WHITE)
            palette_1[i].setGravity(Gravity.CENTER)

            palette_1[i].setOnClickListener {
                val mBuilder = AlertDialog.Builder(this)
                val mLayout = LinearLayout(this)

                val card_image = TextView(this)

                val Color_txt = TextView(this)
                val Number_txt = TextView(this)
                val Rule_txt = TextView(this)

                card_image.setBackgroundResource(card.backgrounder)
                card_image.setGravity(Gravity.CENTER)
                card_image.setTextColor(Color.WHITE)
                card_image.setText(card.number.toString())
                card_image.setTextSize(TypedValue.COMPLEX_UNIT_SP, 80f)

                Color_txt.text = ("Цвет: " + card.ru_color)
                Number_txt.text = ("Число: " + card.number)
                Rule_txt.text = ("Правило: " + card.rule)
                mLayout.orientation = LinearLayout.VERTICAL
                mLayout.addView(card_image)
                mLayout.addView(Color_txt)
                mLayout.addView(Number_txt)
                mLayout.addView(Rule_txt)
                mLayout.setPadding(50, 40, 50, 10)

                mBuilder.setView(mLayout)

                mBuilder.setNeutralButton("Закрыть") { dialogInterface, i ->
                    dialogInterface.dismiss()
                }
                //show dialog
                mBuilder.create().show()
                //return@setOnLongClickListener true

            }

            layout?.addView(palette_1[i])

        }


        //Creating opponent's hand
        screenpart = screenwidth / handsize
        val hand_1 = mutableListOf<TextView>()
        top_deck_index = 9
        for (i in 0..(handsize - 1)) {

            var card = Shuffled_Deck[top_deck_index + i]

            hand_1.add(TextView(this))


            val width_px =
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, card.width, r.displayMetrics)
            val height_px = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                card.height,
                r.displayMetrics
            )
            val params = ConstraintLayout.LayoutParams(
                //ViewGroup.LayoutParams.WRAP_CONTENT,
                //ViewGroup.LayoutParams.WRAP_CONTENT
                width_px.toInt(), height_px.toInt()
            )

            params.bottomToBottom = R.id.opps_hand
            hand_1[i].setId(top_deck_index + i)

            if (i > 0) {
                params.leftToRight = i - 1
                //if (screenpart < width_px)
                params.setMargins((screenpart - width_px).toInt(), 0, 0, 0)
            } else {
                params.leftToRight = R.id.opps_hand
            }

            hand_1[i].layoutParams = params
            hand_1[i].setBackgroundResource(R.drawable.backside)


        layout?.addView(hand_1[i])

        }
    }
}