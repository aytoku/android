package com.example.myapplication_1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityCodeScreen extends AppCompatActivity {

    EditText code_field1;
    EditText code_field2;
    EditText code_field3;
    EditText code_field4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.code);

        code_field1 = (EditText)findViewById(R.id.ll_code_screen1);
        code_field2 = (EditText)findViewById(R.id.ll_code_screen2);
        code_field3 = (EditText)findViewById(R.id.ll_code_screen3);
        code_field4 = (EditText)findViewById(R.id.ll_code_screen4);


        code_field1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(code_field1.getText().toString().length()==1)
                {
                    code_field2.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                code_field1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean b) {
                        code_field1.getText();
                    }
                });
            }

            public void afterTextChanged(Editable s) {
                code_field1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean b) {
                        code_field1.setText("");
                    }
                });
            }
        });

        code_field2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                if(code_field2.getText().toString().length()==1)
                {
                    code_field3.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        code_field3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                if(code_field3.getText().toString().length()==1)
                {
                    code_field4.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        code_field4.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
                {
                        code_field4.requestFocus();
                }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void afterTextChanged(Editable s) {
            }
        });
        
        code_field2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                if(code_field2.getText().toString().length()==0)
                {
                    code_field2.focusSearch(View.FOCUS_LEFT).requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        code_field3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                if(code_field3.getText().toString().length()==0)
                {
                    code_field3.focusSearch(View.FOCUS_LEFT).requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });

        code_field4.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                if(code_field4.getText().toString().length()==0)
                {
                    code_field4.focusSearch(View.FOCUS_LEFT).requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });
    }
}
