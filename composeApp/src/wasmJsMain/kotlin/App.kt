import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ru.evgeny.kuzakov.compose.CatalogScreen
import ru.evgeny.kuzakov.theme.DnsTheme

@Composable
fun App() {
	DnsTheme {
		CatalogScreen()
	}
}