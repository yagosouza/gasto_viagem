package com.yagosouza.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.yagosouza.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            calculate()
        }
    }

    private fun isValid(): Boolean {
        return (!binding.editDistance.text.toString().isNullOrEmpty() &&
                !binding.editPrice.text.toString().isNullOrEmpty() &&
                !binding.editAutonomy.text.toString().isNullOrEmpty() &&
                binding.editAutonomy.text.toString().toFloat() != 0f)

    }

    private fun calculate() {
        if (isValid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy
            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
        } else {
            binding.textTotalValue.text = R.string.total_value.toString()
            Toast.makeText(this, R.string.validation_all_fileds, Toast.LENGTH_LONG).show()
        }

    }
}