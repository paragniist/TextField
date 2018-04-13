package com.example.vinove.textfield;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    AppCompatEditText user;
    AppCompatEditText pass;
    RelativeLayout relativeLayout;
    TextInputLayout textInputLayout;
    TextInputLayout passLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.userNameTextField);
        textInputLayout = findViewById(R.id.username_TextInputLayout);
        pass = findViewById(R.id.passwordTextField);
        passLayout= findViewById(R.id.password_TextInputLayout);
        relativeLayout = findViewById(R.id.activity_main);
        relativeLayout.setOnClickListener(null);


        user.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (user.getText().toString().isEmpty()) {
                    textInputLayout.setErrorEnabled(true);
                    textInputLayout.setError("please enter your username!");
                } else {
                    textInputLayout.setErrorEnabled(false);
                }

            }
        });

        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                System.out.print(s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (user.getText().toString().isEmpty()) {
                    textInputLayout.setErrorEnabled(true);
                    textInputLayout.setError("please enter your username!");
                } else {
                    textInputLayout.setErrorEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        passLayout.setCounterEnabled(true);
        passLayout.setCounterMaxLength(8);

    }
}
