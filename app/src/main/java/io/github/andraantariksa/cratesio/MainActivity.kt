package io.github.andraantariksa.cratesio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import io.github.andraantariksa.cratesio.data.network.ConnectivityInterceptorImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val connectivity = ConnectivityInterceptorImpl(this)
        if (!connectivity.isOnline()) {
            Snackbar.make(mainLayout, R.string.no_internet, Snackbar.LENGTH_INDEFINITE)
                .show()
        }
    }
}
