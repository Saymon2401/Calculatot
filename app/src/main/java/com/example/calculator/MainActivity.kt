package com.example.calculator

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    lateinit var binding: ActivityMainBinding
    var numberText:String? = null
    var number1:Int? = null
    var number2:Int? = null
    var implName:String? = null
    var result:Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.oneBtn.setOnClickListener(this)
        binding.twoBtn.setOnClickListener(this)
        binding.threeBtn.setOnClickListener(this)
        binding.fourBtn.setOnClickListener(this)
        binding.fiveBtn.setOnClickListener(this)
        binding.sixBtn.setOnClickListener(this)
        binding.sevenBtn.setOnClickListener(this)
        binding.eightBtn.setOnClickListener(this)
        binding.nineBtn.setOnClickListener(this)
        binding.zeroBtn.setOnClickListener(this)

        binding.acBtn.setOnClickListener(this)
        binding.deleteBtn.setOnClickListener(this)
        binding.deleniyeBtn.setOnClickListener(this)
        binding.xBtn.setOnClickListener(this)
        binding.minusBtn.setOnClickListener(this)
        binding.plusBtn.setOnClickListener(this)
        binding.equalBtn.setOnClickListener(this)

    }
    override fun onClick(p0: View?) {

        val id = p0?.id
        if (binding.edit.text.toString() == "0"){
            numberText = ""
        }
        when(id){
            R.id.one_btn -> {
               numberText += "1"
               binding.edit.setText(numberText)
            }
            R.id.two_btn -> {
                numberText += "2"
                binding.edit.setText(numberText)
            }
            R.id.three_btn -> {
                numberText += "3"
                binding.edit.setText(numberText)
            }
            R.id.four_btn -> {
                numberText += "4"
                binding.edit.setText(numberText)
            }
            R.id.five_btn -> {
                numberText += "5"
                binding.edit.setText(numberText)
            }
            R.id.six_btn -> {
                numberText += "6"
                binding.edit.setText(numberText)
            }
            R.id.seven_btn -> {
                numberText += "7"
                binding.edit.setText(numberText)
            }
            R.id.eight_btn -> {
                numberText += "8"
                binding.edit.setText(numberText)
            }
            R.id.nine_btn -> {
                numberText += "9"
                binding.edit.setText(numberText)
            }
            R.id.zero_btn -> {
                numberText += "0"
                binding.edit.setText(numberText)
            }


            R.id.ac_btn -> {
                if (numberText?.length == 0){
                    binding.edit.setText("0")
                }else{
                    numberText = ""
                    binding.edit.setText("")
                }
            }
            R.id.delete_btn -> {
                if (numberText?.length == 1 || numberText?.length == 0){
                    binding.edit.setText("0")
                }else{
                    numberText = numberText?.dropLast(1)
                    binding.edit.setText(numberText)
                }
            }
            R.id.deleniye_btn -> {
                number1 = numberText?.toInt()
                numberText = ""
                binding.edit.setText("")
                implName = "div"
            }
            R.id.x_btn -> {
                number1 = numberText?.toInt()
                numberText = ""
                binding.edit.setText("")
                implName = "multi"
            }
            R.id.minus_btn -> {
                number1 = numberText?.toInt()
                numberText = ""
                binding.edit.setText("")
                implName = "minus"
            }
            R.id.plus_btn -> {
                number1 = numberText?.toInt()
                numberText = ""
                binding.edit.setText("")
                implName = "plus"
            }
            R.id.equal_btn -> {
                number2 = numberText?.toInt()
                numberText = ""
                binding.edit.setText("")
                when(implName){
                    "div" -> {
                        result = number1?.div(number2!!)
                        numberText = result.toString()
                        binding.edit.setText(result!!.toString())
                    }
                    "multi" -> {
                        result = number1?.times(number2!!)
                        numberText = result.toString()
                        binding.edit.setText(result!!.toString())
                    }
                    "minus" -> {
                        result = number1?.minus(number2!!)
                        numberText = result.toString()
                        binding.edit.setText(result!!.toString())
                    }
                    "plus" -> {
                        result = number1?.plus(number2!!)
                        numberText = result.toString()
                        binding.edit.setText(result!!.toString())
                    }
                    else -> {
                        binding.edit.setText(numberText)
                    }
                }
            }
        }
    }
}