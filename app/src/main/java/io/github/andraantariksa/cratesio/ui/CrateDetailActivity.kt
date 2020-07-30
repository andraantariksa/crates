package io.github.andraantariksa.cratesio.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.snackbar.Snackbar
import io.github.andraantariksa.cratesio.R
import io.github.andraantariksa.cratesio.data.api.ConnectivityInterceptorImpl
import kotlinx.android.synthetic.main.activity_crate.*
import kotlinx.android.synthetic.main.activity_main.*

class CrateDetailActivity : AppCompatActivity() {

    private lateinit var actionTargetName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crate)
        setupBottomNavigation(R.id.fragmentMain)

        val actionType = intent.getSerializableExtra("actionType") as ActionType
        if (actionType != ActionType.Crates) {
            throw IllegalArgumentException("CratesDetailActivity is only available for Crates ActionType")
        }

        actionTargetName = intent.getStringExtra("actionTargetName")!!

        val connectivity = ConnectivityInterceptorImpl(this)
        if (!connectivity.isOnline()) {
            Snackbar.make(
                coordinatorLayoutSnackbar,
                R.string.no_internet,
                Snackbar.LENGTH_INDEFINITE
            ).show()
        }

        setFloatingActionBarBackOnClickListener()
    }

    private fun setFloatingActionBarBackOnClickListener() {
        floatActionButtonBack.setOnClickListener {
            finish()
        }
    }

    private fun setupBottomNavigation(fragmentHostId: Int) {
//        val navHostFragment = supportFragmentManager
//            .findFragmentById(fragmentHostId) as NavHostFragment
//        val navController = navHostFragment.navController
//        NavigationUI.setupWithNavController(bottomNavigationViewMain, navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = Navigation.findNavController(this, R.id.fragmentMain)
        val navigated = NavigationUI.onNavDestinationSelected(item, navController)
        return super.onOptionsItemSelected(item) || navigated
    }

}
