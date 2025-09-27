import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import org.koin.core.context.startKoin
import ru.evgeny.kuzakov.di.appModule

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
	startKoin {
		printLogger()
		modules(appModule)
	}

	ComposeViewport {
		App()
	}
}