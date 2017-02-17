package me.anuraag.encrypt;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText textEditText = (EditText) findViewById(R.id.text_edit_text);
        final EditText keyEditText = (EditText) findViewById(R.id.key_edit_text);
        final TextView ansTextView = (TextView) findViewById(R.id.ans_text_view);
        final LinearLayout layout = (LinearLayout) findViewById(R.id.activity_main);
        final EditText colorEditText = (EditText) findViewById(R.id.color_edit_text);
        Button encryptButton = (Button) findViewById(R.id.encrypt_button);
        Button decryptButton = (Button) findViewById(R.id.decrypt_button);
        Button colorButton = (Button) findViewById(R.id.color_button);

        encryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ansTextView.setText(encrypt(textEditText.getText().toString(), keyEditText.getText().toString()));
            }
        });

        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ansTextView.setText(decrypt(textEditText.getText().toString(), keyEditText.getText().toString()));
            }
        });

        ansTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                textEditText.setText(ansTextView.getText());
                return false;
            }
        });

        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout.setBackgroundColor(Color.parseColor(colorEditText.getText().toString()));
            }
        });

    }

    String encrypt(String plaintext, String key) {
        plaintext = plaintext.toUpperCase();
        key = key.toUpperCase();
        String ciphertext = "";
        for (int i = 0; i < plaintext.length(); i++) {
            ciphertext += (char) (((plaintext.charAt(i) + key.charAt(i % key.length())) % 26) + 65);
        }
        return ciphertext;
    }

    String decrypt(String text, String key) {

        String plaintext = "";
        text = text.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            if ((text.charAt(i) - key.charAt(i % key.length())) < 0) {
                int res = 26 + ((text.charAt(i) - key.charAt(i % key.length())));
                plaintext += (char) (res + 65);
            } else
                plaintext += (char) (((text.charAt(i) - key.charAt(i % key.length())) % 26) + 65);
        }

        return  plaintext;
    }
}
