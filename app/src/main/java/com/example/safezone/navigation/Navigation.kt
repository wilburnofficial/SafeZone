package com.example.safezone.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Science
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

// Sealed class to represent all main screen destinations
sealed class Screen(val route: String, val icon: ImageVector, val label: String) {
    object Recipes : Screen("recipes", Icons.Default.Restaurant, "Recipes")
    object Research : Screen("research", Icons.Default.Science, "Research")
    object Connections : Screen("connections", Icons.Default.Group, "Connect")
}

// List of screens to show in the Bottom Navigation Bar
val navItems = listOf(Screen.Recipes, Screen.Research, Screen.Connections)

@Composable
fun AppStructure() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (navItems.any { it.route == currentRoute }) {
                NavigationBar {
                    navItems.forEach { screen ->
                        val selected = currentRoute == screen.route
                        NavigationBarItem(
                            icon = { Icon(screen.icon, contentDescription = screen.label) },
                            label = { Text(screen.label) },
                            selected = selected,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Recipes.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Recipes.route) { RecipesScreen() }
            composable(Screen.Research.route) { ResearchFeedScreen() }
            composable(Screen.Connections.route) { ConnectionsScreen() }
        }
    }
}


// Placeholder for the Recipes Screen
@Composable
fun RecipesScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Recipes Screen Content", style = MaterialTheme.typography.headlineLarge)
    }
}

// Placeholder for the Research Feed Screen
@Composable
fun ResearchFeedScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Medical Research Feed", style = MaterialTheme.typography.headlineLarge)
    }
}

// Placeholder for the Connections Screen
@Composable
fun ConnectionsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Connections/Reviews Feed", style = MaterialTheme.typography.headlineLarge)
    }
}
