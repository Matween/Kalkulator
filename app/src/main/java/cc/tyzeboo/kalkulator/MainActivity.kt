package cc.tyzeboo.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    private var lastNumInput: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onPress(btn0)
        onPress(btn1)
        onPress(btn2)
        onPress(btn3)
        onPress(btn4)
        onPress(btn5)
        onPress(btn6)
        onPress(btn7)
        onPress(btn8)
        onPress(btn9)
        onPress(btnPlus)
        onPress(btnMinus)
        onPress(btnTimes)
        onPress(btnDividedBy)
        onPress(btnEquals)
        onPress(btnClear)
        onPress(btnClearAll)
        onPress(btnDel)
        onPress(btnDot)


    }

    private fun onPress(button: Button) {
        button.setOnClickListener {
            val textHistory = findViewById<TextView>(R.id.textHistory)
            val sb = StringBuilder()
            when(button.text) {
                "del" -> {
                    textHistory.text = backspace(textHistory.text.toString())
                }
                "C" -> {

                }
                "CE" -> {

                }
                "=" -> {

                }
                "+" -> {

                }
                "-" -> {

                }
                "×" -> {

                }
                "." -> {
                    if (textHistory.text.contains('.').not()) {
                        lastInput(button, sb)
                    }
                }
                else -> {
                    lastInput(button, sb)
                }
            }

        }
    }

    private fun backspace(currentTxt: String): String {
        Log.v("before", lastNumInput)
        var backspaceTxt: String = currentTxt
        if (backspaceTxt.isNotEmpty()) {
            backspaceTxt = currentTxt.substring(0, currentTxt.length - lastNumInput.length)
        }
        Log.v("after", currentTxt)
        return backspaceTxt
    }

    private fun lastInput(button: Button, sb: StringBuilder) {
        lastNumInput = button.text.toString()
        sb.append(textHistory.text.toString()).append(lastNumInput)
        textHistory.text = sb.toString()
    }
}
