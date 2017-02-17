package me.anuraag.userprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = (Button) findViewById(R.id.add_button);
        final EditText usernameEditText = (EditText) findViewById(R.id.name_edit_text);
        final EditText passwordEditText = (EditText) findViewById(R.id.position_edit_text);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), SuccessActivity.class)
                .putExtra("name", usernameEditText.getText().toString())
                .putExtra("pass", passwordEditText.getText().toString()));

            }
        });
    }
}
