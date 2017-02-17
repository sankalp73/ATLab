package me.anuraag.evaluation2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = (EditText) findViewById(R.id.edit_text);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), Boolean.toString(checkPalindrome(editText.getText().toString())), Toast.LENGTH_SHORT).show();
            }
        });
    }

    Boolean checkPalindrome(String string){

        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder = stringBuilder.reverse();
        String revString = new String(stringBuilder);
        return string.equalsIgnoreCase(revString);
    }
}
