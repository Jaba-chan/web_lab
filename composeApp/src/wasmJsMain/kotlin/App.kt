import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import navigation.AppNavGraph
import navigation.Screen
import ru.evgeny.kuzakov.AuthScreen
import ru.evgeny.kuzakov.compose.CatalogScreen
import ru.evgeny.kuzakov.theme.DnsTheme

@Composable
fun App() {
	DnsTheme {
		val navController = rememberNavController()
		val navState = remember { NavigationState(navController) }

		AppNavGraph(
			navHostController = navController,
			signInScreenContent = {
				AuthScreen(onSuccess = { navState.navigateTo(Screen.CatalogScreen.route) })
			},
			signUpScreenContent = {},
			catalogScreenContent = { CatalogScreen() }
		)
	}
}