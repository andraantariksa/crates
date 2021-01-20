package io.github.andraantariksa.cratesio.ui

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import io.github.andraantariksa.cratesio.R

enum class MainFragmentNavigation(
    @IdRes val menuItemId: Int,
    val fragment: Fragment
) {
    Summary(R.id.menu_main_summary, SummaryFragment()),
    Search(R.id.menu_main_search, SearchFragment()),
    Misc(R.id.menu_main_misc, MiscFragment());

    companion object {
        fun findMenuItem(menuItemId: Int): MainFragmentNavigation? {
            for (mainFragment in values()) {
                if (mainFragment.menuItemId == menuItemId) {
                    return mainFragment
                }
            }
            return null
        }
    }
}
