package pl.edu.uwr.lista1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int kolejne = 1;
    TextView totalQuestionTextView;
    TextView questionTextView;
    Button submitBtn;
    int score = 0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    private ProgressBar progressBar;
    private int progressStatus = 0;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.choices_layout);
        totalQuestionTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        submitBtn = findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(this);
        progressBar = findViewById(R.id.progressBar);


        loadNewQuestion();

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.submit_btn) {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            if (selectedId != -1) { // Check if an answer is selected
                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectAnswer = selectedRadioButton.getText().toString();
                if(kolejne <10) {
                    kolejne++;
                }
                if (selectAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])) {
                    score++;
                }
                currentQuestionIndex++;
                if (currentQuestionIndex < totalQuestion) {
                    loadNewQuestion();
                } else {
                    finishQuiz();
                }
                updateProgressText();

                progressStatus++;
                progressBar.setProgress(progressStatus);
            }
        }
    }

    void loadNewQuestion() {
        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        RadioButton ansA = findViewById(R.id.Ans_A);
        RadioButton ansB = findViewById(R.id.Ans_B);
        RadioButton ansC = findViewById(R.id.Ans_C);

        ansA.setText(QuestionAnswer.choice[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choice[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choice[currentQuestionIndex][2]);

        radioGroup.clearCheck(); // Clear previous selection
        updateProgressText();
    }

    void finishQuiz() {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("SCORE", score);
        intent.putExtra("TOTAL_QUESTION", totalQuestion);
        startActivity(intent);
        finish();
    }

    void updateProgressText() {
        totalQuestionTextView.setText("Pytanie: " + kolejne + "/" + totalQuestion);
    }
}
