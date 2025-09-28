package navigation

    sealed class Screen(val route: String) {
        object SignInScreen: Screen(ROUTE_SIGN_IN)
        object SignUpScreen: Screen(ROUTE_SIGN_UP)

        object CatalogScreen: Screen(ROUTE_CATALOG)

        companion object {
            const val ROUTE_SIGN_IN = "sign_in"
            const val ROUTE_SIGN_UP = "sign_up"

            const val ROUTE_CATALOG = "catalog"
        }
    }