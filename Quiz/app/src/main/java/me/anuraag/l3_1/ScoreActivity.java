package me.anuraag.l3_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        TextView textView = (TextView) findViewById(R.id.score_text_view);
        textView.setGravity(Gravity.CENTER);
        int score = getIntent().getIntExtra("score", 0);
        textView.setText(Integer.toString(score));
    }
}
