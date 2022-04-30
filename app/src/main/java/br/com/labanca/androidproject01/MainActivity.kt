package br.com.labanca.androidproject01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import br.com.labanca.androidproject01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnSave.setOnClickListener {
            Log.d("MainActivity", "Save button clicked")

            if (!binding.edtName.text.isEmpty()) {
                binding.txtName.text = binding.edtName.text
                binding.txtDescription.text = binding.edtDescription.text
                binding.txtCode.text = binding.edtCode.text
                binding.txtPrice.text = binding.edtPrice.text
            } else {
                Toast.makeText(this, "Please, enter the name.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("MainActivity", "onSaveInstanceState")

        val product = Product(
            name = binding.edtName.text.toString(),
            description = binding.edtDescription.text.toString(),
            code = binding.edtCode.text.toString(),
            price = binding.edtPrice.text.toString().toDouble()
        )

        outState.putSerializable("product", product)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("MainActivity", "onRestoreInstanceState")

        val product = savedInstanceState.getSerializable("product") as Product

        binding.txtName.text = product.name
        binding.txtDescription.text = product.description
        binding.txtCode.text = product.code
        binding.txtPrice.text = product.price.toString()
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }
}