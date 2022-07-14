package io.github.andraantariksa.crates.feature_crates.ui.crate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class CrateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val crateId = intent?.extras?.getInt(Extra.CRATE_ID_NAME)

        setContent {
            if (crateId != null) {
                CrateScreen(crateId)
            } else {

            }
        }
    }

    companion object {
        object Extra {
            const val CRATE_ID_NAME = "crateId"
        }
    }
}