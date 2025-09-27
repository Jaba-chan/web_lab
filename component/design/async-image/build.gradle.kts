import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
	alias(libs.plugins.kotlinMultiplatform)
	alias(libs.plugins.composeMultiplatform)
	alias(libs.plugins.composeCompiler)
}

kotlin {
	@OptIn(ExperimentalWasmDsl::class)
	wasmJs {
		browser()
		binaries.executable()
	}
	compilerOptions {
		languageVersion.set(KotlinVersion.KOTLIN_2_0)
	}
	sourceSets {
		wasmJsMain.dependencies {
			implementation(compose.runtime)
			implementation(compose.foundation)
			implementation(compose.material3)
			implementation(compose.ui)
		}
	}

}