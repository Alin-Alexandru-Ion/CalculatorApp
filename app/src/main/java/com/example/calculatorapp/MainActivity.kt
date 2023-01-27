package com.example.calculatorapp

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.snackbar.Snackbar
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputText = findViewById<TextView>(R.id.typeBox)
        val bufferText = findViewById<TextView>(R.id.bufferBox)

        var buffer : Double
        var aux = 0.0
        var auxM = 1.0
        var equalStatus = ""
        var decStatus = true
        var stringBuffer = ""
        var auxBuffer: String
        var divPass = true
        var plusAccess = true
        var minusAccess = true
        var timesAccess = true
        var byAccess = true

        val df = DecimalFormat("#.######")
        df.roundingMode = RoundingMode.CEILING

        val buttonZero: Button = findViewById(R.id.zeroButton)
        val buttonOne: Button = findViewById(R.id.oneButton)
        val buttonTwo: Button = findViewById(R.id.twoButton)
        val buttonThree: Button = findViewById(R.id.threeButton)
        val buttonFour: Button = findViewById(R.id.fourButton)
        val buttonFive: Button = findViewById(R.id.fiveButton)
        val buttonSix: Button = findViewById(R.id.sixButton)
        val buttonSeven: Button = findViewById(R.id.sevenButton)
        val buttonEight: Button = findViewById(R.id.eightButton)
        val buttonNine: Button = findViewById(R.id.nineButton)
        val buttonClear: Button = findViewById(R.id.clearButton)
        val buttonDecimal: Button = findViewById(R.id.decimalButton)
        val buttonEqual: Button = findViewById(R.id.equalButton)
        val buttonBackSpace: Button = findViewById(R.id.backSpaceButton)
        val buttonPlus: Button = findViewById(R.id.plusButton)
        val buttonMinus: Button = findViewById(R.id.minusButton)
        val buttonTimes: Button = findViewById(R.id.timesButton)
        val buttonBy: Button = findViewById(R.id.byButton)

        @Suppress("KotlinConstantConditions")
        fun snacks(str: String) {
            val snack: Snackbar = Snackbar.make(findViewById(android.R.id.content), str, 750)
            val view = snack.view
            val params = view.layoutParams as FrameLayout.LayoutParams
            params.gravity = Gravity.TOP
            view.layoutParams = params
            val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            val myCustomFont : Typeface? = ResourcesCompat.getFont(this, R.font.cabin)
            when (currentNightMode) {
                Configuration.UI_MODE_NIGHT_NO -> {
                    snack.view.setBackgroundColor(Color.parseColor("#DDDDDD"))
                    snack.setTextColor(Color.parseColor("#333333"))
                }
                Configuration.UI_MODE_NIGHT_YES -> {
                    snack.view.setBackgroundColor(Color.parseColor("#333333"))
                    snack.setTextColor(Color.parseColor("#DDDDDD"))
                }
            }
            val tv = view.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
            tv.typeface = myCustomFont
            tv.textSize = 18f
            snack.show()
        }

        fun skipZero() {
            if (stringBuffer == "0") {
                stringBuffer = stringBuffer.substring(1)
            }
        }

        @Suppress("KotlinConstantConditions")
        buttonZero.setOnClickListener {

            stringBuffer = inputText.text.toString()
            if (stringBuffer != "0") {
                stringBuffer += "0"
                inputText.text = stringBuffer
            }
            else if (stringBuffer == "0") {
                snacks("Can't type any more 0")
            }
        }

        buttonOne.setOnClickListener {
            stringBuffer = inputText.text.toString()
            skipZero()
            stringBuffer += "1"
            inputText.text = stringBuffer
        }

        buttonTwo.setOnClickListener {
            stringBuffer = inputText.text.toString()
            skipZero()
            stringBuffer += "2"
            inputText.text = stringBuffer
        }

        buttonThree.setOnClickListener {
            stringBuffer = inputText.text.toString()
            skipZero()
            stringBuffer += "3"
            inputText.text = stringBuffer
        }

        buttonFour.setOnClickListener {
            stringBuffer = inputText.text.toString()
            skipZero()
            stringBuffer += "4"
            inputText.text = stringBuffer
        }

        buttonFive.setOnClickListener {
            stringBuffer = inputText.text.toString()
            skipZero()
            stringBuffer += "5"
            inputText.text = stringBuffer
        }

        buttonSix.setOnClickListener {
            stringBuffer = inputText.text.toString()
            skipZero()
            stringBuffer += "6"
            inputText.text = stringBuffer
        }

        buttonSeven.setOnClickListener {
            stringBuffer = inputText.text.toString()
            skipZero()
            stringBuffer += "7"
            inputText.text = stringBuffer
        }

        buttonEight.setOnClickListener {
            stringBuffer = inputText.text.toString()
            skipZero()
            stringBuffer += "8"
            inputText.text = stringBuffer
        }

        buttonNine.setOnClickListener {
            stringBuffer = inputText.text.toString()
            skipZero()
            stringBuffer += "9"
            inputText.text = stringBuffer
        }

        buttonClear.setOnClickListener {
            inputText.text = ""
            bufferText.text = ""
            buffer = 0.0
            aux = 0.0
            auxM = 1.0
            equalStatus = ""
            decStatus = true
            plusAccess = true
            minusAccess = true
            timesAccess = true
            byAccess = true
        }

        buttonDecimal.setOnClickListener {
            if (!decStatus)
                snacks("Invalid operation")
            else {
                stringBuffer = inputText.text.toString()
                stringBuffer += "."
                inputText.text = stringBuffer
                decStatus = false
            }
        }

        @Suppress("KotlinConstantConditions")
        buttonEqual.setOnClickListener {
            when (equalStatus) {
                "plus" -> {
                    if (aux != 0.0) {
                        stringBuffer = inputText.text.toString()
                        if (stringBuffer != "") {
                            buffer = stringBuffer.toDouble()
                            aux += buffer
                            buffer = 0.0
                            inputText.text = df.format(aux)
                            bufferText.text = ""
                            aux = 0.0
                        }
                    }
                    if (aux == 0.0) {
                        auxBuffer = bufferText.text.toString()
                        if (auxBuffer != "") {
                            stringBuffer = inputText.text.toString()
                            if (stringBuffer != "") {
                                inputText.text = stringBuffer
                                bufferText.text = ""
                                aux = 0.0
                            }
                        }
                    }
                    minusAccess = true
                    timesAccess = true
                    byAccess = true
                }
                "minus" -> {
                    if (aux != 0.0) {
                        stringBuffer = inputText.text.toString()
                        if (stringBuffer != "") {
                            buffer = stringBuffer.toDouble()
                            aux -= buffer
                            buffer = 0.0
                            inputText.text = df.format(aux)
                            bufferText.text = ""
                            aux = 0.0
                        }
                    }
                    if (aux == 0.0) {
                        auxBuffer = bufferText.text.toString()
                        if (auxBuffer != "") {
                            stringBuffer = inputText.text.toString()
                            if (stringBuffer != "") {
                                inputText.text = "-$stringBuffer"
                                bufferText.text = ""
                                aux = 0.0
                            }
                        }
                    }
                    plusAccess = true
                    timesAccess = true
                    byAccess = true
                }
                "times" -> {
                    if (aux != 0.0) {
                        stringBuffer = inputText.text.toString()
                        if (stringBuffer != "") {
                            buffer = stringBuffer.toDouble()
                            aux = auxM * buffer
                            inputText.text = df.format(aux)
                            bufferText.text = ""
                            aux = 0.0
                            auxM = 1.0
                        }
                    }
                    if (aux == 0.0) {
                        auxBuffer = bufferText.text.toString()
                        if (auxBuffer != "") {
                            inputText.text = "0"
                            bufferText.text = ""
                            aux = 0.0
                            auxM = 1.0
                        }
                    }
                    plusAccess = true
                    minusAccess = true
                    byAccess = true
                }
                "by" -> {
                    if (aux != 0.0) {
                        stringBuffer = inputText.text.toString()
                        if (stringBuffer != ""){
                            buffer = stringBuffer.toDouble()
                            aux /= buffer
                            inputText.text = df.format(aux)
                            bufferText.text = ""
                            aux = 0.0
                            decStatus = true
                            divPass = true
                        }
                    }
                    else if (aux == 0.0) {
                        auxBuffer = bufferText.text.toString()
                        if (auxBuffer != "") {
                            divPass = true
                            snacks("Invalid operation")
                        }
                    }
                    plusAccess = true
                    minusAccess = true
                    timesAccess = true
                }
                else -> snacks("Invalid operation")
            }
        }

        buttonBackSpace.setOnClickListener {
            stringBuffer = inputText.text.toString()
            if(stringBuffer != "") {
                stringBuffer = inputText.text.toString().dropLast(1)
                inputText.text = stringBuffer
            }
            else {
                snacks("Already empty")
            }
        }

        buttonPlus.setOnClickListener {
            if (plusAccess) {
                stringBuffer = inputText.text.toString()
                if (stringBuffer != "") {
                    buffer = stringBuffer.toDouble()
                    aux += buffer
                    buffer = 0.0
                    inputText.text = ""
                    bufferText.text = df.format(aux) + " +"
                    equalStatus = "plus"
                    decStatus = true
                    minusAccess = false
                    timesAccess = false
                    byAccess = false
                }
            }
            else {
                snacks("Another operation in course")
            }
        }

        buttonMinus.setOnClickListener {
            if (minusAccess) {
                stringBuffer = inputText.text.toString()
                if (stringBuffer == "-") {
                    snacks("Type in a negative number")
                }
                else if (stringBuffer != "") {
                    buffer = stringBuffer.toDouble()
                    aux += buffer
                    buffer = 0.0
                    inputText.text = ""
                    bufferText.text = df.format(aux) + " -"
                    equalStatus = "minus"
                    decStatus = true
                    plusAccess = false
                    timesAccess = false
                    byAccess = false
                }
                if (stringBuffer == "") {
                    auxBuffer = bufferText.text.toString()
                    inputText.text = "-"
                    if (auxBuffer != "") {
                        equalStatus = "minus"
                    }
                }
            }
            else {
                snacks("Another operation in course")
            }
        }

        buttonTimes.setOnClickListener {
            if (timesAccess) {
                stringBuffer = inputText.text.toString()
                if (stringBuffer != "") {
                    buffer = stringBuffer.toDouble()
                    aux = auxM * buffer
                    inputText.text = ""
                    bufferText.text = df.format(aux) + " x"
                    equalStatus = "times"
                    decStatus = true
                    auxM = aux
                    plusAccess = false
                    minusAccess = false
                    byAccess = false
                }
            }
            else {
                snacks("Another operation in course")
            }
        }

        buttonBy.setOnClickListener {
            if (byAccess) {
                stringBuffer = inputText.text.toString()
                if (stringBuffer != "") {
                    buffer = stringBuffer.toDouble()
                    if (divPass) {
                        aux = buffer
                        divPass = false
                        inputText.text = ""
                        bufferText.text = df.format(aux) + " ÷"
                        equalStatus = "by"
                        decStatus = true
                        plusAccess = false
                        minusAccess = false
                        timesAccess = false
                    } else {
                        aux /= buffer
                        inputText.text = ""
                        bufferText.text = df.format(aux) + " ÷"
                        equalStatus = "by"
                        decStatus = true
                        plusAccess = false
                        minusAccess = false
                        timesAccess = false
                    }
                }
            }
            else {
                snacks("Another operation in course")
            }
        }
    }
}