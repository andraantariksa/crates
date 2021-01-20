package io.github.andraantariksa.cratesio.ui.misc

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

class LinearLayoutNoScrollManager(context: Context?) : LinearLayoutManager(context) {
    override fun canScrollVertically(): Boolean = false
}
