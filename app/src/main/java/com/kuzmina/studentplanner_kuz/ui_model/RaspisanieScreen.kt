package com.kuzmina.studentplanner_kuz.ui_model

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


val lessons = listOf(
    "Понедельник - РПМ",
    "Вторник - ИСПРО",
    "Среда - Математика",
    "Четверг - РМП",
    "Пятница - Проет"
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RaspisanieScreen(
    lessonClick: (String) -> Unit,
    navigator: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Расписание") }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(lessons) { lesson ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            lessonClick(lesson)
                        }
                ) {
                    Text(
                        text = lesson,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}