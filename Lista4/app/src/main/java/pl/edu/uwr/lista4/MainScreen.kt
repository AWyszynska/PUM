package pl.edu.uwr.lista4



import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
fun MainScreen() {
    val questions = generateQuestions()
    var currentQuestionIndex by rememberSaveable { mutableStateOf(0) }
    var selectedAnswerIndex by rememberSaveable { mutableStateOf<Int?>(null) }
    var score by rememberSaveable { mutableStateOf(0) }
    var showResult by rememberSaveable { mutableStateOf(false) }

    if (showResult) {
        QuizResultScreen(score = score, totalQuestions = questions.size)
    } else {
        val currentQuestion = questions[currentQuestionIndex]

        QuizScreen(
            question = currentQuestion.text,
            answers = currentQuestion.answers,
            currentQuestion = currentQuestionIndex + 1,
            totalQuestions = questions.size,
            selectedAnswer = selectedAnswerIndex,
            onAnswerSelected = { index -> selectedAnswerIndex = index },
            onNextClicked = {
                if (selectedAnswerIndex == currentQuestion.correctAnswerIndex) {
                    score++
                }
                selectedAnswerIndex = null
                if (currentQuestionIndex < questions.size - 1) {
                    currentQuestionIndex++
                } else {
                    showResult = true
                }
            }
        )
    }
}
