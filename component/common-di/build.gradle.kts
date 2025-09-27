import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
	alias(libs.plugins.kotlinMultiplatform)
}

kotlin {
	@OptIn(ExperimentalWasmDsl::class)
	wasmJs {
		browser()
		binaries.executable()
	}

	sourceSets {
		commonMain.dependencies {
			implementation(libs.koin.core)
			implementation(libs.koin.core.wasm.js)
		}
	}
}
