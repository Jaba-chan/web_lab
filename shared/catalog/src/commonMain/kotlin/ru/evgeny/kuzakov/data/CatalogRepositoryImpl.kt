package ru.evgeny.kuzakov.data

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import ru.evgeny.kuzakov.domain.CatalogRepository
import ru.evgeny.kuzakov.domain.Product

class CatalogRepositoryImpl(
	private val authToken: String? = null,
	private val client: HttpClient = defaultHttp
) : CatalogRepository {

	private val baseUrl = "https://weblab-87441-default-rtdb.europe-west1.firebasedatabase.app/products"

	override suspend fun getAll(withHidden: Boolean): List<Product> {
		val url = "$baseUrl.json${auth()}"
		val response = client.get(url)
		val raw: Map<String, ProductDto> = Json.decodeFromString(response.bodyAsText())

		return raw.map { (id, product) ->
			product.toDomain(id)
		}.filter { withHidden || !it.hidden }
			.sortedBy { it.title }
	}

	override suspend fun get(id: String): Product {
		val url = "$baseUrl/$id.json${auth()}"
		val response = client.get(url)
		val p = Json.decodeFromString<ProductDto>(response.bodyAsText())
		return p.toDomain(id)
	}

	private fun auth(): String = authToken?.let { "?auth=$it" } ?: ""

	companion object {
		val defaultHttp = HttpClient {
			install(ContentNegotiation) {
				json(Json {
					ignoreUnknownKeys = true
					isLenient = true
				})
			}
		}
	}
}