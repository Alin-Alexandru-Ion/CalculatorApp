package com.example.calculatorapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buffer : Double = 0.0
        var aux : Double = 0.0

        var equalStatus : String = ""
        var decStatus : Boolean = true

        var inputText = findViewById<TextView>(R.id.typeBox)
        var bufferText = findViewById<TextView>(R.id.bufferBox)
        var stringBuffer : String = ""
        var stringAux: String = ""

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

        if (inputText.text == "") {
            Log.e("Error: ", "Invalid operation")
        }
        else if (inputText.text != "") {
            println("Toate functiile plus minus blablabla")
        }

        buttonZero.setOnClickListener() {
            if (stringBuffer != "0") {
                stringBuffer = inputText.text.toString()
                stringBuffer += "0"
                inputText.text = stringBuffer
            }
            else if (stringBuffer == "0"){
                stringBuffer = inputText.text.toString()
                stringBuffer += "0"
                inputText.text = stringBuffer.drop(1)
            }
        }

        buttonOne.setOnClickListener() {
            stringBuffer = inputText.text.toString()
            stringBuffer += "1"
            inputText.text = stringBuffer
        }

        buttonTwo.setOnClickListener() {
            stringBuffer = inputText.text.toString()
            stringBuffer += "2"
            inputText.text = stringBuffer
        }

        buttonThree.setOnClickListener() {
            stringBuffer = inputText.text.toString()
            stringBuffer += "3"
            inputText.text = stringBuffer
        }

        buttonFour.setOnClickListener() {
            stringBuffer = inputText.text.toString()
            stringBuffer += "4"
            inputText.text = stringBuffer
        }

        buttonFive.setOnClickListener() {
            stringBuffer = inputText.text.toString()
            stringBuffer += "5"
            inputText.text = stringBuffer
        }

        buttonSix.setOnClickListener() {
            stringBuffer = inputText.text.toString()
            stringBuffer += "6"
            inputText.text = stringBuffer
        }

        buttonSeven.setOnClickListener() {
            stringBuffer = inputText.text.toString()
            stringBuffer += "7"
            inputText.text = stringBuffer
        }

        buttonEight.setOnClickListener() {
            stringBuffer = inputText.text.toString()
            stringBuffer += "8"
            inputText.text = stringBuffer
        }

        buttonNine.setOnClickListener() {
            stringBuffer = inputText.text.toString()
            stringBuffer += "9"
            inputText.text = stringBuffer
        }

        buttonClear.setOnClickListener() {
            inputText.text = ""
            bufferText.text = ""
            buffer = 0.0
            aux = 0.0
            equalStatus = ""
            decStatus = true
        }

        buttonDecimal.setOnClickListener() {
            if (decStatus == false)
                Log.e("Error: ", "Invalid operation")
            else {
                stringBuffer = inputText.text.toString()
                stringBuffer += "."
                inputText.text = stringBuffer
                decStatus = false
            }
        }

        buttonEqual.setOnClickListener() {
            when (equalStatus) {
                "plus" -> {
                    if (aux != 0.0) {
                        stringBuffer = inputText.text.toString()
                        buffer = stringBuffer.toDouble()
                        aux += buffer
                        buffer = 0.0
                        inputText.text = df.format(aux)
                        bufferText.text = ""
                    }
                    else{

                    }
                }
                "minus" -> {
                    aux -= buffer
                }
                "times" -> {
                    aux *= buffer
                }
                "by" -> {
                    aux /= buffer
                }
                else -> Log.e("Error: ", "Invalid operation")
            }
        }

        buttonBackSpace.setOnClickListener() {
            if(inputText.text != "") {
                stringBuffer = inputText.text.toString().dropLast(1)
                inputText.text = stringBuffer
            }
            else println("already blank")
        }

        buttonPlus.setOnClickListener() {
            stringBuffer = inputText.text.toString()
            buffer = stringBuffer.toDouble()
            aux += buffer
            buffer = 0.0
            inputText.text = ""
            //bufferText.text = aux.toString()
            bufferText.text = df.format(aux)
            equalStatus = "plus"
            decStatus = true
        }

        buttonMinus.setOnClickListener() {
            stringBuffer = inputText.text.toString()
            buffer = stringBuffer.toDouble()
            aux -= buffer
            inputText.text = ""
            bufferText.text = stringBuffer
            equalStatus = "minus"
            decStatus = true
        }

        buttonTimes.setOnClickListener() {
            stringBuffer = inputText.text.toString()
            buffer = stringBuffer.toDouble()
            aux *= buffer
            inputText.text = ""
            bufferText.text = stringBuffer
            equalStatus = "times"
            decStatus = true
        }

        buttonBy.setOnClickListener() {
            stringBuffer = inputText.text.toString()
            buffer = stringBuffer.toDouble()
            aux /= buffer
            inputText.text = ""
            bufferText.text = stringBuffer
            equalStatus = "by"
            decStatus = true
        }

    }
}