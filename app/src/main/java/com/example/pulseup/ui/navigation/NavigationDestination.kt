package com.example.pulseup.ui.navigation

/**
 * Interface to describe the navigation destinations for the app.
 */
interface NavigationDestination {
    /**
     * Unique name to identify the path for a composable.
     */
    val route: String

    /**
     * String resource id that contains the title to be displayed for the screen.
     */
    val titleRes: Int
}