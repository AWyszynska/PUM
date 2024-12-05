package pl.edu.uwr.lista4



import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuizResultScreen(score: Int, totalQuestions: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Twój wynik to:",
            style = MaterialTheme.typography.h5
        )
        Text(
            text = "$score/$totalQuestions",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primary
        )
    }
}
