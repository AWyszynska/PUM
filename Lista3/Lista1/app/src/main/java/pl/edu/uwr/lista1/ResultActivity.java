package pl.edu.uwr.lista1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int score = intent.getIntExtra("SCORE", 0);
        int totalQuestion = intent.getIntExtra("TOTAL_QUESTION", 0);

        TextView congratulationsTextView = findViewById(R.id.congratulationsTextView);
        TextView scoreTextView = findViewById(R.id.scoreTextView);

        congratulationsTextView.setText("Gratulacje");
        scoreTextView.setText("Zdobyłeś " + (100/10 * score) + " % ");
    }
}
