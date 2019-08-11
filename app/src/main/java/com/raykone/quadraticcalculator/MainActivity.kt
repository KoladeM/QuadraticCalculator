package com.raykone.quadraticcalculator

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.raykone.quadraticcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mySquares:MySquares = MySquares()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.mySquares = mySquares


        binding.buttonCompute.setOnClickListener {
            computeSquares (it)
        }

        binding.buttonClear.setOnClickListener {
            clearText (it)
        }


    }

    private fun clearText(view: View) {

        binding.editTextA.text.clear()

        binding.editTextB.text.clear()

        binding.editTextC.text.clear()

        binding.squareOne.text = ""

        binding.squareTwo.text = ""

        view.setBackgroundColor(resources.getColor(R.color.material_blue_grey_800))

        binding.buttonCompute.setBackgroundColor(android.R.drawable.btn_default)
    }

    private fun computeSquares(view: View) {

        var a: Double

        var b: Double

        var c: Double

        if (binding.editTextA.text.toString().trim().isEmpty()){
            Toast.makeText(applicationContext, "Enter coefficient of x^2", Toast.LENGTH_SHORT).show()
            return
        }

        else {
            a = binding.editTextA.text.toString().toDouble()
        }

        if (binding.editTextB.text.toString().trim().isEmpty()){
            Toast.makeText(applicationContext, "Enter coefficient of x", Toast.LENGTH_SHORT).show()
            return
        }

        else {
            b = binding.editTextB.text.toString().toDouble()
        }

        if (binding.editTextC.text.toString().trim().isEmpty()){
            Toast.makeText(applicationContext, "Enter constant C", Toast.LENGTH_SHORT).show()
            return
        }

        else {
            c = binding.editTextA.text.toString().toDouble()
        }

        if ((b*b)<(4*a*c)){

            Toast.makeText(applicationContext, "Cannot calculate root of complex numbers", Toast.LENGTH_SHORT).show()

            return
        }


        var z: Double = (b*b)-(4*a*c)

        var rootZ: Double = Math.sqrt(z)

        binding.squareOne.text = computeX1(b, rootZ, a).toString()

        binding.squareTwo.text = computeX2(b, rootZ, a).toString()

        view.setBackgroundColor(resources.getColor(R.color.material_blue_grey_800))

        binding.buttonClear.setBackgroundColor(android.R.drawable.btn_default)


    }



    private fun computeX1(b: Double, rootZ: Double, a: Double):Double {

        var x1:Double = (-b + rootZ)/(2*a)

        return x1


    }

    private fun computeX2(b: Double, rootZ: Double, a: Double): Double {

        var x2: Double = (-b - rootZ)/(2*a)

        return x2

    }
}
