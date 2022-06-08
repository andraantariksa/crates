import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import io.github.andraantariksa.crates.ui.common.BottomNavigationItem
import io.github.andraantariksa.crates.ui.main.screens.mainBottomNavigationItems

@Composable
fun MainBottomNavigation(navHostController: NavHostController, items: List<BottomNavigationItem>) {
    BottomNavigation {
        mainBottomNavigationItems.forEach { bottomNavigationItem ->
            BottomNavigationItem(
                selected = navHostController.currentDestination?.route ==
                        bottomNavigationItem.route,
                onClick = {
                    navHostController
                        .navigate(bottomNavigationItem.route)
                },
                icon = {
                    Icon(
                        imageVector = bottomNavigationItem.icon,
                        contentDescription = bottomNavigationItem.name
                    )
                },
                label = {
                    Text(text = bottomNavigationItem.name)
                }
            )
        }
    }
}