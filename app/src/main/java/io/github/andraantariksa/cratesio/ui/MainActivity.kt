package io.github.andraantariksa.cratesio.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.snackbar.Snackbar
import io.github.andraantariksa.cratesio.R
import io.github.andraantariksa.cratesio.data.api.ConnectivityInterceptorImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val connectivity = ConnectivityInterceptorImpl(this)
        if (!connectivity.isOnline()) {
            Snackbar.make(
                coordinatorLayoutSnackbar,
                R.string.no_internet, Snackbar.LENGTH_INDEFINITE
            )
                .show()
        }

        val navController = Navigation.findNavController(this, R.id.fragmentMain)
        setupBottomNavigation(navController)
    }

    private fun setupBottomNavigation(navController: NavController) {
        NavigationUI.setupWithNavController(bottomNavigationViewMain, navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController  = Navigation.findNavController(this, R.id.fragmentMain)
        val navigated = NavigationUI.onNavDestinationSelected(item, navController)
        return super.onOptionsItemSelected(item) || navigated
    }
}
