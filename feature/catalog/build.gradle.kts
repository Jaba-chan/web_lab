import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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
			implementation(compose.components.resources)
			implementation(compose.components.uiToolingPreview)
			implementation(libs.androidx.lifecycle.viewmodelCompose)
			implementation(libs.androidx.lifecycle.runtimeCompose)
			implementation(libs.koin.compose)
			implementation(libs.koin.core)
			implementation(libs.koin.core.wasm.js)

			implementation(project(":component:common-di"))
			implementation(project(":component:design:async-image"))
			implementation(project(":component:design:theme"))
			implementation(project(":shared:catalog"))

		}
	}

}