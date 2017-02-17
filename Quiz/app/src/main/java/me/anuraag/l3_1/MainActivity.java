package me.anuraag.l3_1;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = 0;

        RadioGroup questionOneRadioGroup = (RadioGroup) findViewById(R.id.q1_radio_group);
        questionOneRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.q1_true)
                    count++;
            }
        });

        RadioGroup questionTwoRadioGroup = (RadioGroup) findViewById(R.id.q2_radio_group);
        questionTwoRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i == R.id.q2_false)
                    count++;
            }
        });

        RadioGroup questionThreeRadioGroup = (RadioGroup) findViewById(R.id.q3_radio_group);
        questionThreeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i == R.id.q3_false)
                    count++;
            }
        });

        final Button scoreButton = (Button) findViewById(R.id.score_button);
        scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Do you want to view your score?")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialogInterface, int id){

                                Log.d("Count", Integer.toString(count));
                                startActivity(new Intent(getApplicationContext(),ScoreActivity.class)
                                .putExtra("score", count));
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }
}
