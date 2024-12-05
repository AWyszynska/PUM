package pl.edu.uwr.lista4

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuizScreen(
    question: String,
    answers: List<String>,
    currentQuestion: Int,
    totalQuestions: Int,
    selectedAnswer: Int?,
    onAnswerSelected: (Int) -> Unit,
    onNextClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column {
            Text(
                text = "Pytanie $currentQuestion/$totalQuestions",
                style = MaterialTheme.typography.h6
            )
            LinearProgressIndicator(
                progress = currentQuestion / totalQuestions.toFloat(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            )
        }


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = question,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                answers.forEachIndexed { index, answer ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable { onAnswerSelected(index) },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = index == selectedAnswer,
                            onClick = { onAnswerSelected(index) }
                        )
                        Text(
                            text = answer,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }
        }


        Button(
            onClick = onNextClicked,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Następne")
        }
    }
}
