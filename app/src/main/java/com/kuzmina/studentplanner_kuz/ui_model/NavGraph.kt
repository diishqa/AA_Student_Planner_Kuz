package com.kuzmina.studentplanner_kuz.ui_model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.kuzmina.studentplanner_kuz.navigation.Screen

@Composable
fun StudentPlannerNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(route = Screen.Home.route)
        {
            HomeScreen(
                onSubjectClick = { subjectId ->
                    navController.navigate(Screen.Details.createRoute(subjectId))
                },
                onProfileClick = {
                    navController.navigate(Screen.Profile.route)
                },
                onSettingsClick = {
                    navController.navigate(Screen.Settings.route)
                },
                onRaspisanieClick = {
                    navController.navigate(Screen.Raspisanie.route)
                }
            )
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument("subjectId") {
                    type = NavType.StringType
                }
            )
        ){
            backStackEntry ->
            val subjectId = backStackEntry.arguments?.getString("subjectId") ?: ""
            DetailsScreen (
                subjectId = subjectId,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Screen.Profile.route){
            ProfileScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Screen.Settings.route){
            SettingsScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.Raspisanie.route) {
            RaspisanieScreen(
                lessonClick = { lessons ->
                    navController.navigate(Screen.Lessons.createLess(lessons))
                },
                navigator = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = Screen.Lessons.route,
            arguments = listOf(
                navArgument("lessonName") {
                    type = NavType.StringType
                }
            )
        ) {
            backStackEntry ->
            val lessonName = backStackEntry.arguments?.getString("lessonName") ?: ""
            LessonDetailsScreen(
                lessonName = lessonName,
                back = {
                    navController.popBackStack()
                }
            )
        }
    }
}