package io.github.andraantariksa.cratesio.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import io.github.andraantariksa.cratesio.R
import io.github.andraantariksa.cratesio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        setupFragmentNavigation()
    }

    private fun setupFragmentNavigation() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            MainFragmentNavigation.findMenuItem(it.itemId)?.apply {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, this.fragment)
                    .commit()
                return@setOnNavigationItemSelectedListener true
            }
            false
        }
    }
}
