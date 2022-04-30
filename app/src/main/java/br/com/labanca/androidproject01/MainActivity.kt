package br.com.labanca.androidproject01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import br.com.labanca.androidproject01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnSave.setOnClickListener {
            Log.d("MainActivity", "Save button clicked")

            binding.txtName.text = binding.edtName.text
            binding.txtDescription.text = binding.edtDescription.text
            binding.txtCode.text = binding.edtCode.text
            binding.txtPrice.text = binding.edtPrice.text
        }
    }
}