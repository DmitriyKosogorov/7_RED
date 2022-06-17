package com.example.a7red_0_0

import android.util.Log

class Card_Class(Color:String="Red", Number:Int=7, Rule:String="greatest_all") {

    var color=Color
    var ru_color="Красный"
    var rule=Rule
    var number=Number
    var width=72f
    var height=100f
    var textSize=25
    var backgrounder=R.drawable.red

    init {
        if(number<8 && number>0)
            number=number
        else
            number=7
        Log.d("colors","change")
        when(color)
        {
            "Red"->backgrounder=R.drawable.red
            "Orange"->backgrounder=R.drawable.orange
            "Yellow"->backgrounder=R.drawable.yellow
            "Green"->backgrounder=R.drawable.green
            "LBlue"->backgrounder=R.drawable.lblue
            "DBlue"->backgrounder=R.drawable.dblue
            "Purple"->backgrounder=R.drawable.purple
            "Black"->backgrounder=R.drawable.black
            "Brown"->backgrounder=R.drawable.brown
            "Turquoise"->backgrounder=R.drawable.turquoise
            "Pink"->backgrounder=R.drawable.pink
            "White"->backgrounder=R.drawable.white
            else->backgrounder=R.drawable.red
        }
        when(color)
        {
            "Red"->ru_color="Красный"
            "Orange"->ru_color="Оранжевый"
            "Yellow"->ru_color="Жёлтый"
            "Green"->ru_color="Зелёный"
            "LBlue"->ru_color="Голубой"
            "DBlue"->ru_color="Синий"
            "Purple"->ru_color="Фиолетовый"
            "Black"->ru_color="Чёрный"
            "Brown"->ru_color="Коричневый"
            "Turquoise"->ru_color="Бирюзовый"
            "Pink"->ru_color="Розовый"
            "White"->ru_color="Белый"
            else->ru_color="Красный"
        }
    }
}