import androidx.navigation.NavController
import kotlinx.browser.window
import navigation.Screen

class NavigationState(
	private val navController: NavController
) {
	init {
		window.onpopstate = {
			val route = window.location.hash.removePrefix("#")
			navController.navigate(
				route.ifEmpty { Screen.SignInScreen.route }
			)
		}
	}

	fun navigateTo(route: String) {
		navController.navigate(route) {
			launchSingleTop = true
		}
		window.history.pushState(route.toJsString(), "", "#$route")
	}
}
