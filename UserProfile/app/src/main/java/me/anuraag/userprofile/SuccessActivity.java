package me.anuraag.userprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        final String username = getIntent().getStringExtra("name");
        final String password = getIntent().getStringExtra("pass");
        Log.d(username, password);
        final EditText usernameEditText = (EditText) findViewById(R.id.email_reg_edit_text);
        final EditText passwordEditText = (EditText) findViewById(R.id.password_reg_edit_text);
        Button loginButton = (Button) findViewById(R.id.email_sign_in_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(usernameEditText.getText().toString().equals(username) && passwordEditText.getText().toString().equals(password)){

                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
