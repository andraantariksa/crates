package io.github.andraantariksa.crates.feature_crates.ui.crate

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class CrateActivity : ComponentActivity() {

    companion object {
        object Args {
            const val CRATE_ID_NAME = "crateId"
        }

        fun init(context: Context, crateId: String) = Intent(context, CrateActivity::class.java).apply {
            putExtra(Args.CRATE_ID_NAME, crateId)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val crateId = intent?.extras?.getString(Args.CRATE_ID_NAME)

        setContent {
            CrateScreen(crateId)
        }
    }
}