import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
	alias(libs.plugins.kotlinMultiplatform)
	alias(libs.plugins.kotlinxSerialization)
}

kotlin {
	@OptIn(ExperimentalWasmDsl::class)
	wasmJs {
		browser()
		binaries.executable()
	}

	sourceSets {
		commonMain.dependencies {
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.client.content.negotiation)
			implementation(libs.koin.core)
			implementation(libs.koin.core.wasm.js)
		}
	}
}
