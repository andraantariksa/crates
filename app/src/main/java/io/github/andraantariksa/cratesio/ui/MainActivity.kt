package io.github.andraantariksa.cratesio.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.snackbar.Snackbar
import io.github.andraantariksa.cratesio.R
import io.github.andraantariksa.cratesio.data.api.ConnectivityInterceptorImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation(R.id.fragmentMain)

        val connectivity = ConnectivityInterceptorImpl(this)
        if (!connectivity.isOnline()) {
            Snackbar.make(
                coordinatorLayoutSnackbar,
                R.string.no_internet,
                Snackbar.LENGTH_INDEFINITE
            ).show()
        }
    }

    private fun setupBottomNavigation(fragmentHostId: Int) {
        val navHostFragment = supportFragmentManager
            .findFragmentById(fragmentHostId) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(bottomNavigationViewMain, navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = Navigation.findNavController(this, R.id.fragmentMain)
        val navigated = NavigationUI.onNavDestinationSelected(item, navController)
        return super.onOptionsItemSelected(item) || navigated
    }

}
